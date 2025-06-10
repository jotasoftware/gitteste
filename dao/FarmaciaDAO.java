package dao;

import Models.*;
import dto.*;
import java.sql.*;
import java.util.ArrayList;

public class FarmaciaDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public void adicionar(Farmacia farmacia){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "INSERT INTO Farmacia (nome, cnpj) VALUES (?, ?)";
            p = con.prepareStatement(sql);
            String cnpj = farmacia.getCnpj().replaceAll("[^0-9]", "");
            p.setString(1, farmacia.getNome());
            p.setString(2, cnpj);
            p.execute();
            p.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }
        
    }
    
    public int verificarCnpj(String cnpj) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        int id = -1;

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT id FROM \"Famacia\" WHERE cnpj = ?";
            p = con.prepareStatement(sql);
            p.setLong(1, Long.parseLong(cnpj));
            rs = p.executeQuery();
            if (rs.next()) { 
                id = rs.getInt("id");
            }
            rs.close();
            p.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro na verificação do CNPJ em Farmacias: " + e.getMessage());
        }

        return id;
    }
    
    
    public ArrayList<CompraListagemDTO> listarComprasCnpj(int idFarmacia) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<CompraListagemDTO> compras = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT " +
                    "    C.\"idCompra\", " +
                    "    F.\"nomeCompleto\" AS \"nomeFuncionario\", " +
                    "    C.\"dataCompra\", " +
                    "    SUM(CP.\"qtdCompraProduto\") AS \"quantidadeProdutos\", " +
                    "    C.\"totalCompra\" " +
                    "FROM " +
                    "    \"Compra\" C " +
                    "JOIN " +
                    "    \"Funcionario\" F ON C.\"idFuncionario\" = F.\"idFuncionario\" " +
                    "JOIN " +
                    "    \"CompraProdutos\" CP ON C.\"idCompra\" = CP.\"idCompra\" " +
                    "WHERE " +
                    "    C.\"idFarmacia\" = ? " +
                    "GROUP BY " +
                    "    C.\"idCompra\", F.\"nomeCompleto\", C.\"dataCompra\", C.\"totalCompra\" " +
                    "ORDER BY " +
                    "    C.\"dataCompra\" DESC";
        p = con.prepareStatement(sql);
        p.setInt(1, idFarmacia);
            rs = p.executeQuery();
            while (rs.next()) {
                CompraListagemDTO compra = new CompraListagemDTO();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setNomeFuncionario(rs.getString("nomeFuncionario"));
                compra.setDataCompra(rs.getDate("dataCompra").toLocalDate());
                compra.setQtdProdutos(rs.getInt("quantidadeProdutos"));
                compra.setValorFinal(rs.getDouble("totalCompra"));
                compras.add(compra);
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return compras;
    }
    
    public ArrayList<VendaListagemDTO> listarVendasCnpj(int idFarmacia) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<VendaListagemDTO> vendas = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT " +
                        "    V.\"idVenda\", " +
                        "    F.\"nomeCompleto\" AS \"nomeFuncionario\", " +
                        "    V.\"dataVenda\", " +
                        "    SUM(VP.\"qtdVendaProduto\") AS \"quantidadeProdutos\", " +
                        "    V.\"totalVenda\" " +
                        "FROM " +
                        "    \"Venda\" V " +
                        "JOIN " +
                        "    \"Funcionario\" F ON V.\"idFuncionario\" = F.\"idFuncionario\" " +
                        "JOIN " +
                        "    \"VendaProdutos\" VP ON V.\"idVenda\" = VP.\"idVenda\" " +
                        "WHERE " +
                        "    V.\"idFarmacia\" = ? " +
                        "GROUP BY " +
                        "    V.\"idVenda\", F.\"nomeCompleto\", V.\"dataVenda\", V.\"totalVenda\" " +
                        "ORDER BY " +
                        "    V.\"dataVenda\" DESC";
        
            p = con.prepareStatement(sql);
            p.setInt(1, idFarmacia);
            rs = p.executeQuery();
            while (rs.next()) {
                VendaListagemDTO venda = new VendaListagemDTO();
                venda.setIdVenda(rs.getInt("idVenda"));
                venda.setNomeFuncionario(rs.getString("nomeFuncionario"));
                venda.setDataVenda(rs.getDate("dataVenda").toLocalDate());
                venda.setQtdProdutos(rs.getInt("quantidadeProdutos"));
                venda.setValorFinal(rs.getDouble("totalVenda"));
                vendas.add(venda);

            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return vendas;
    }
    
     public ArrayList<LucroMensalDTO> listarLucrosMensaisCnpj(int idFarmacia) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<LucroMensalDTO> lucrosMensais = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT " +
                        "    Fa.\"nome\" AS \"Nome da Farmácia\", " +
                        "    TO_CHAR(CURRENT_DATE, 'YYYY-MM') AS \"mesReferencia\", " +
                        "    ( " +
                        "        SELECT COALESCE(SUM(V.\"totalVenda\"), 0) " +
                        "        FROM \"Venda\" V " +
                        "        WHERE V.\"idFarmacia\" = Fa.\"idFarmacia\" " +
                        "          AND V.\"dataVenda\" >= DATE_TRUNC('month', CURRENT_DATE) " +
                        "          AND V.\"dataVenda\" < DATE_TRUNC('month', CURRENT_DATE) + INTERVAL '1 month' " +
                        "    ) AS \"somatorioVendas\", " +
                        "    ( " +
                        "        SELECT COALESCE(SUM(C.\"totalCompra\"), 0) " +
                        "        FROM \"Compra\" C " +
                        "        WHERE C.\"idFarmacia\" = Fa.\"idFarmacia\" " +
                        "          AND C.\"dataCompra\" >= DATE_TRUNC('month', CURRENT_DATE) " +
                        "          AND C.\"dataCompra\" < DATE_TRUNC('month', CURRENT_DATE) + INTERVAL '1 month' " +
                        "    ) AS \"somatorioCompras\", " +
                        "    ( " +
                        "        (SELECT COALESCE(SUM(V.\"totalVenda\"), 0) " +
                        "         FROM \"Venda\" V " +
                        "         WHERE V.\"idFarmacia\" = Fa.\"idFarmacia\" " +
                        "           AND V.\"dataVenda\" >= DATE_TRUNC('month', CURRENT_DATE) " +
                        "           AND V.\"dataVenda\" < DATE_TRUNC('month', CURRENT_DATE) + INTERVAL '1 month') " +
                        "        - " +
                        "        (SELECT COALESCE(SUM(C.\"totalCompra\"), 0) " +
                        "         FROM \"Compra\" C " +
                        "         WHERE C.\"idFarmacia\" = Fa.\"idFarmacia\" " +
                        "           AND C.\"dataCompra\" >= DATE_TRUNC('month', CURRENT_DATE) " +
                        "           AND C.\"dataCompra\" < DATE_TRUNC('month', CURRENT_DATE) + INTERVAL '1 month') " +
                        "    ) AS \"lucroMes\" " +
                        "FROM " +
                        "    \"Farmacia\" Fa " +
                        "WHERE " +
                        "    Fa.\"idFarmacia\" = ?";
        
            p = con.prepareStatement(sql);
            p.setInt(1, idFarmacia);
            rs = p.executeQuery();
            while (rs.next()) {
                LucroMensalDTO lucroMensal = new LucroMensalDTO();
                lucroMensal.setMes(rs.getString("mesReferencia"));
                lucroMensal.setSomatorioVenda(rs.getDouble("somatorioVendas"));
                lucroMensal.setSomatorioCompra(rs.getDouble("somatorioCompras"));
                lucroMensal.setLucroMes(rs.getDouble("lucroMes"));
                lucrosMensais.add(lucroMensal);

            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return lucrosMensais;
    }
     
     
    //verificar dados no bd
    public ArrayList<Produto> listarProdutosCnpj(int idFarmacia) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT \"id\", \"nomeProduto\", \"valorVenda\", \"valorCusto\", \"idFarmacia\", \"quantidade\" " +
                         "FROM \"Produto\" WHERE \"idFarmacia\" = ?";
            p = con.prepareStatement(sql);
            p.setInt(1, idFarmacia);
            rs = p.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id")); 
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setValorVenda(rs.getDouble("valorVenda"));
                produto.setValorCusto(rs.getDouble("valorCusto"));
                produto.setQtdProduto(rs.getInt("quantidade"));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return produtos;
    }
    
    public ArrayList<SetorListagemDTO> listarSetoresCnpj(int idFarmacia) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<SetorListagemDTO> setores = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = ""
                        + "SELECT "
                        + "    S.\"nome\", "
                        + "    COUNT(F.\"idFuncionario\") OVER (PARTITION BY S.\"idSetor\") AS totalFuncionariosSetor, "
                        + "    F.\"idFuncionario\", "
                        + "    F.\"nomeCompleto\", "
                        + "    F.\"salarioBase\", "
                        + "    S.\"valeRefeicao\", "
                        + "    S.\"valeAlimentacao\", "
                        + "    S.\"planoSaude\", "
                        + "    S.\"planoOdonto\", "
                        + "    S.\"valeTransporte\" "
                        + "FROM "
                        + "    \"Funcionario\" F "
                        + "JOIN "
                        + "    \"Setor\" S ON F.\"idSetor\" = S.\"idSetor\" "
                        + "WHERE "
                        + "    F.\"idFarmacia\" = ? "
                        + "ORDER BY "
                        + "    S.\"nome\", F.\"nomeCompleto\"";
            p = con.prepareStatement(sql);
            p.setInt(1, idFarmacia);
            rs = p.executeQuery();
            while (rs.next()) {
                SetorListagemDTO setor = new SetorListagemDTO();
                setor.setNome(rs.getString("nome"));
                setor.setValeTransporte(rs.getDouble("valeTransporte"));
                setor.setValeAlimentacao(rs.getDouble("valeAlimentacao"));
                setor.setValeRefeicao(rs.getDouble("valeRefeicao"));
                setor.setPlanoSaude(rs.getDouble("planoDeSaude"));
                setor.setQtdFuncionarios(rs.getInt("totalFuncionariosSetor"));

                setores.add(setor);
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return setores;
    }
    
    public ArrayList<FuncionarioListagemDTO> listarFuncionariosCnpj(int idFarmacia) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<FuncionarioListagemDTO> funcionarios = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT " +
                         "    Fc.\"idFuncionario\", " +
                         "    Fc.\"nomeCompleto\", " +
                         "    S.\"nome\", " +
                         "    Fc.\"salarioBase\" " +
                         "FROM " +
                         "    \"Funcionario\" Fc " +
                         "JOIN " +
                         "    \"Setor\" S ON Fc.\"idSetor\" = S.\"idSetor\" " +
                         "WHERE " +
                         "    Fc.\"idFarmacia\" = ? " +
                         "ORDER BY " +
                         "    Fc.\"nomeCompleto\"";
            p = con.prepareStatement(sql);
            p.setInt(1, idFarmacia);
            rs = p.executeQuery();
            while (rs.next()) {
                FuncionarioListagemDTO funcionario = new FuncionarioListagemDTO();
                funcionario.setNomeFuncionario(rs.getString("nomeCompleto"));
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNomeSetor(rs.getString("nome"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));

                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return funcionarios;
    }
}
