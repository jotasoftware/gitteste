package dao;

import Models.*;
import dto.*;
import java.sql.*;
import java.util.ArrayList;

public class FarmaciaDAO {

    private final Connection connection;

    public FarmaciaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean adicionar(Farmacia farmacia){
        String sql = "INSERT INTO Farmacia (nome, cnpj, saldoinicial) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            String cnpj = farmacia.getCnpj().replaceAll("[^0-9]", "");
            pstmt.setString(1, farmacia.getNome());
            pstmt.setString(2, cnpj);
            pstmt.setDouble(3, farmacia.getSaldoInicial());
            pstmt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Falha na inserção da farmácia: " + e.getMessage());
            return false;
        }
    }
    
    public int verificarCnpj(String cnpjString) {
        String sql = "SELECT idFarmacia FROM farmacia WHERE cnpj = ?";
        String cnpj = cnpjString.replaceAll("[^0-9]", "");

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setString(1, cnpj);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idFarmacia");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro na verificação do CNPJ em Farmacias: " + e.getMessage());
        }
        return -1;
    }
    
    public double buscaSaldo(int idFarmacia) {
        String sql = "SELECT saldoinicial FROM farmacia WHERE idFarmacia = ?";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, idFarmacia);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("saldoinicial");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro na busca do Saldo Inicial em Farmacias: " + e.getMessage());
        }
        return 0;
    }
    
    
    public ArrayList<CompraListagemDTO> listarComprasCnpj(int idFarmacia) {
        ArrayList<CompraListagemDTO> compras = new ArrayList<>();
        String sql = "SELECT " +
                     "    C.idCompra, F.nomeCompleto AS nomeFuncionario, C.dataCompra, " +
                     "    SUM(CP.qtdCompraProduto) AS quantidadeProdutos, C.totalCompra " +
                     "FROM compra C " +
                     "JOIN funcionario F ON C.idFuncionario = F.idFuncionario " +
                     "JOIN compraprodutos CP ON C.idCompra = CP.idCompra " +
                     "WHERE C.idFarmacia = ? AND C.status = true " +
                     "GROUP BY C.idCompra, F.nomeCompleto, C.dataCompra, C.totalCompra " +
                     "ORDER BY C.dataCompra DESC";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, idFarmacia);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CompraListagemDTO compra = new CompraListagemDTO();
                    compra.setIdCompra(rs.getInt("idCompra"));
                    compra.setNomeFuncionario(rs.getString("nomeFuncionario"));
                    compra.setDataCompra(rs.getDate("dataCompra").toLocalDate());
                    compra.setQtdProdutos(rs.getInt("quantidadeProdutos"));
                    compra.setValorFinal(rs.getDouble("totalCompra"));
                    compras.add(compra);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar compras da farmácia: " + e.getMessage());
        }
        return compras;
    }
    
    public ArrayList<VendaListagemDTO> listarVendasCnpj(int idFarmacia) {
        ArrayList<VendaListagemDTO> vendas = new ArrayList<>();
        String sql = "SELECT " +
                     "    V.idVenda, F.nomeCompleto AS nomeFuncionario, V.dataVenda, " +
                     "    SUM(VP.qtdVendaProduto) AS quantidadeProdutos, V.totalVenda " +
                     "FROM venda V " +
                     "JOIN funcionario F ON V.idFuncionario = F.idFuncionario " +
                     "JOIN vendaprodutos VP ON V.idVenda = VP.idVenda " +
                     "WHERE V.idFarmacia = ? AND V.status = true " +
                     "GROUP BY V.idVenda, F.nomeCompleto, V.dataVenda, V.totalVenda " +
                     "ORDER BY V.dataVenda DESC";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, idFarmacia);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    VendaListagemDTO venda = new VendaListagemDTO();
                    venda.setIdVenda(rs.getInt("idVenda"));
                    venda.setNomeFuncionario(rs.getString("nomeFuncionario"));
                    venda.setDataVenda(rs.getDate("dataVenda").toLocalDate());
                    venda.setQtdProdutos(rs.getInt("quantidadeProdutos"));
                    venda.setValorFinal(rs.getDouble("totalVenda"));
                    vendas.add(venda);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar vendas da farmácia: " + e.getMessage());
        }
        return vendas;
    }
    
     public ArrayList<LucroListagemDTO> listarLucrosMensaisCnpj(int idFarmacia, boolean buscarFuturo) {
         
        ArrayList<LucroListagemDTO> lucrosMensais = new ArrayList<>();
        String operador = buscarFuturo ? ">" : "<=";
        String sqlTemplate = "SELECT " +
                             "    F.idFarmacia, " +
                             "    TO_CHAR(mes_transacao, 'YYYY-MM') AS mesReferencia, " +
                             "    SUM(totalVenda) AS somatorioVendas, " +
                             "    SUM(totalCompra) AS somatorioCompras, " +
                             "    (SUM(totalVenda) - SUM(totalCompra)) AS lucroMes " +
                             "FROM ( " +
                             "    SELECT idFarmacia, DATE_TRUNC('month', dataVenda) AS mes_transacao, totalVenda, 0 AS totalCompra " +
                             "    FROM Venda " +
                             "    WHERE dataVenda %s CURRENT_DATE " +
                             "    UNION ALL " +
                             "    SELECT idFarmacia, DATE_TRUNC('month', dataCompra) AS mes_transacao, 0 AS totalVenda, totalCompra " +
                             "    FROM Compra " +
                             "    WHERE dataCompra %s CURRENT_DATE " +
                             ") AS Transacoes " +
                             "JOIN farmacia F ON F.idFarmacia = Transacoes.idFarmacia " +
                             "WHERE F.idFarmacia = ? " +
                             "GROUP BY F.idFarmacia, mes_transacao " +
                             "ORDER BY F.idFarmacia, mesReferencia";
        String sql = String.format(sqlTemplate, operador, operador);

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, idFarmacia);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    LucroListagemDTO lucroMensal = new LucroListagemDTO();
                    lucroMensal.setData(rs.getString("mesReferencia"));
                    lucroMensal.setSomatorioVenda(rs.getDouble("somatorioVendas"));
                    lucroMensal.setSomatorioCompra(rs.getDouble("somatorioCompras"));
                    lucroMensal.setLucro(rs.getDouble("lucroMes"));
                    lucrosMensais.add(lucroMensal);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar lucros mensais: " + e.getMessage());
        }
        return lucrosMensais;
    }
     
     
     public ArrayList<LucroListagemDTO> listarLucrosAnuaisCnpj(int idFarmacia, boolean buscarFuturo) {
         
        ArrayList<LucroListagemDTO> lucrosMensais = new ArrayList<>();
        String operador = buscarFuturo ? ">=" : "<";
        String sqlTemplate = "SELECT " +
                         "    F.idFarmacia, " +
                         "    TO_CHAR(ano_transacao, 'YYYY') AS anoReferencia, " +
                         "    SUM(totalVenda) AS somatorioVendas, " +
                         "    SUM(totalCompra) AS somatorioCompras, " +
                         "    (SUM(totalVenda) - SUM(totalCompra)) AS lucroAno " +
                         "FROM ( " +
                         "    SELECT idFarmacia, DATE_TRUNC('year', dataVenda) AS ano_transacao, totalVenda, 0 AS totalCompra " +
                         "    FROM Venda " +
                         "    WHERE EXTRACT(YEAR FROM dataVenda) %s EXTRACT(YEAR FROM CURRENT_DATE) " +
                         "    UNION ALL " +
                         "    SELECT idFarmacia, DATE_TRUNC('year', dataCompra) AS ano_transacao, 0 AS totalVenda, totalCompra " +
                         "    FROM Compra " +
                         "    WHERE EXTRACT(YEAR FROM dataCompra) %s EXTRACT(YEAR FROM CURRENT_DATE) " +
                         ") AS Transacoes " +
                         "JOIN farmacia F ON F.idFarmacia = Transacoes.idFarmacia " +
                         "WHERE F.idFarmacia = ? " +
                         "GROUP BY F.idFarmacia, ano_transacao " +
                         "ORDER BY F.idFarmacia, anoReferencia";
        String sql = String.format(sqlTemplate, operador, operador);

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, idFarmacia);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    LucroListagemDTO lucroAnual = new LucroListagemDTO();
                    lucroAnual.setData(rs.getString("anoReferencia"));
                    lucroAnual.setSomatorioVenda(rs.getDouble("somatorioVendas"));
                    lucroAnual.setSomatorioCompra(rs.getDouble("somatorioCompras"));
                    lucroAnual.setLucro(rs.getDouble("lucroAno"));
                    lucrosMensais.add(lucroAnual);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar lucros mensais: " + e.getMessage());
        }
        return lucrosMensais;
    }
    
    
}