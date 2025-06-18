package dao;

import Models.Venda;
import Models.ProdutosCompraVenda;
import dto.ProdutosCompraListagemDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class VendaDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/farmaciateste";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    
    public int gerarVenda(Venda venda){
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        int idGerado = -1;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "INSERT INTO venda (idFarmacia, idFuncionario) VALUES (?, ?) RETURNING idVenda";
            p = con.prepareStatement(sql);
            p.setInt(1, venda.getIdFarmacia());
            p.setInt(2, venda.getIdFuncionario());

            rs = p.executeQuery();
            if (rs.next()) {
                idGerado = rs.getInt("idVenda");
            }
            
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexões: " + ex.getMessage());
            }
        }
        
        return idGerado;
        
    }
    
    public boolean adicionarProdutoNaVenda(ProdutosCompraVenda produtosVenda){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "INSERT INTO vendaProdutos (idVenda, idProduto, qtdVendaProduto) VALUES (?, ?, ?)";
            p = con.prepareStatement(sql);
            p.setInt(1, produtosVenda.getIdNota());
            p.setInt(2, produtosVenda.getIdProduto());
            p.setInt(3, produtosVenda.getQuant());
            p.execute();
            p.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
            return false;
        }
        
    }
    
    public ArrayList<ProdutosCompraListagemDTO> listarProdutosNaVenda(int idVenda) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<ProdutosCompraListagemDTO> produtos = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT p.nomeProduto, p.idProduto, vp.qtdVendaProduto, " +
                         "(vp.qtdVendaProduto * p.valorVenda) AS valor_total_item " +
                         "FROM VendaProdutos vp " +
                         "JOIN Produto p ON vp.idProduto = p.idProduto " +
                         "WHERE vp.idVenda = ? " +
                         "ORDER BY p.nomeProduto;";
            p = con.prepareStatement(sql);
            p.setInt(1, idVenda);
            rs = p.executeQuery();
            while (rs.next()) {
                ProdutosCompraListagemDTO produto = new ProdutosCompraListagemDTO();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setQtdProduto(rs.getInt("qtdVendaProduto"));
                produto.setValorTotal(rs.getDouble("valor_total_item"));
                produtos.add(produto);

            }

        } catch (SQLException e) {
            System.out.println("Erro na consultaa: " + e.getMessage());
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
    
     public boolean remover(int idVenda, int idProduto) {
        Connection con = null;
        PreparedStatement p = null;

        try {
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println("Falha ao carregar o driver: " + e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "DELETE FROM VendaProdutos WHERE idVenda = ? AND idProduto = ?";
            p = con.prepareStatement(sql);
            p.setInt(1, idVenda);
            p.setInt(2, idProduto);
            int linhasAfetadas = p.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Produto removido com sucesso.");
                return true;
            } else {
                System.out.println("Nenhum produto encontrado com o ID informado.");
            }

            p.close();
            con.close();
            
            return false;
        } catch (Exception e) {
            System.out.println("Falha na exclusão: " + e.getMessage());
            return false;
        }
     }
     
    public boolean finalizarVenda(int idVenda, double total, LocalDate data) {
        Connection con = null;
        PreparedStatement p = null;

        try {
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println("Falha ao carregar o driver: " + e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "UPDATE Venda SET status = true, totalVenda = ?, dataVenda = ? WHERE idVenda = ?";
            p = con.prepareStatement(sql);
            p.setDouble(1, total);
            p.setDate(2, Date.valueOf(data));
            p.setInt(3, idVenda);

            int linhasAfetadas = p.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Compra finalizada com sucesso.");
                return true;
            } else {
                System.out.println("Nenhuma Venda encontrada com o ID informado.");
            }

            return false;
        } catch (Exception e) {
            System.out.println("Falha ao finalizar a venda: " + e.getMessage());
            return false;
        } finally {
            try {
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexões: " + e.getMessage());
            }
        }
    }
    
    

}
