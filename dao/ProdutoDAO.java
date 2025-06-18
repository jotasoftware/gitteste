package dao;

import Models.Produto;
import dto.ProdutosCompraListagemDTO;
import java.sql.*;
import java.util.ArrayList;

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
    
    public ArrayList<Produto> listarProdutosCnpj(int idFarmacia) {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT idProduto, nomeProduto, valorVenda, valorCusto, quantidade " +
                     "FROM Produto WHERE idFarmacia = ?";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, idFarmacia);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getInt("idProduto"));
                    produto.setNomeProduto(rs.getString("nomeProduto"));
                    produto.setValorVenda(rs.getDouble("valorVenda"));
                    produto.setValorCusto(rs.getDouble("valorCusto"));
                    produto.setQtdProduto(rs.getInt("quantidade"));
                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos da farmácia: " + e.getMessage());
        }
        return produtos;
    }
}