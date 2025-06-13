package dao;

import Models.Produto;
import dto.ProdutosCompraListagemDTO;
import java.sql.*;

public class ProdutoDAO {
    private final Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }
    
   public boolean criarProduto(Produto produto) {
        String sql = "INSERT INTO Produto (nomeProduto, valorVenda, valorCusto, idFarmacia, quantidade) VALUES (?, ?, ?, ?, ?)";
       
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            
            pstmt.setString(1, produto.getNomeProduto());
            pstmt.setDouble(2, produto.getValorVenda());
            pstmt.setDouble(3, produto.getValorCusto());
            pstmt.setInt(4, produto.getidFarmacia()); 
            pstmt.setInt(5, produto.getQtdProduto());

            pstmt.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("Falha na inserção do produto: " + e.getMessage());
            return false;
        }
    }
    
    public boolean adicionarProduto(ProdutosCompraListagemDTO produto) {
        String sql = "UPDATE Produto SET quantidade = quantidade + ? WHERE idProduto = ?";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, produto.getQtdProduto());
            pstmt.setInt(2, produto.getIdProduto());

            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Falha ao adicionar o produto: " + e.getMessage());
            return false;
        }
    }
    
    public boolean removerProduto(ProdutosCompraListagemDTO produto) {
        String sql = "UPDATE Produto SET quantidade = quantidade - ? WHERE idProduto = ?";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, produto.getQtdProduto());
            pstmt.setInt(2, produto.getIdProduto());

            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Falha ao remover o produto: " + e.getMessage());
            return false;
        }
    }
}