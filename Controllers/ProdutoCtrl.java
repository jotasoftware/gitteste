package Controllers;

import Models.Produto;
import config.DatabaseConnection;
import dao.ProdutoDAO;
import dto.ProdutosCompraListagemDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoCtrl {
    
    public ProdutoCtrl() {
        
    }

    public boolean registrarProduto(String nomeProduto, String valorVenda, String valorCusto) {
        try {
            double valorVendaDouble = Double.parseDouble(valorVenda.replace(",", "."));
            double valorCustoDouble = Double.parseDouble(valorCusto.replace(",", "."));

            if (nomeProduto == null || nomeProduto.trim().isEmpty() || 
                valorVendaDouble <= 0 || valorCustoDouble <= 0) {
                return false;
            }

            Produto produto = new Produto(Sessao.getIdFarmaciaLogada(), nomeProduto, valorVendaDouble, valorCustoDouble);

            try (Connection conn = DatabaseConnection.getConnection()) {
                ProdutoDAO dao = new ProdutoDAO(conn);
                return dao.criarProduto(produto); 
            } catch (SQLException e) {
                System.err.println("Erro de banco de dados ao registrar produto: " + e.getMessage());
                return false;
            }

        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valores numéricos: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Erro inesperado ao registrar produto: " + e.getMessage());
            return false;
        }
    }

    
    public boolean adicionarProdutos(ArrayList<ProdutosCompraListagemDTO> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            ProdutoDAO dao = new ProdutoDAO(conn);

            for (ProdutosCompraListagemDTO produto : produtos) {
                boolean sucesso = dao.adicionarProduto(produto);
                if (!sucesso) {
                    System.err.println("Falha ao adicionar produto com ID: " + produto.getIdProduto());
                    return false;
                }
            }
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produtos: " + e.getMessage());
            return false;
        }
    }
    
    public boolean removerProdutos(ArrayList<ProdutosCompraListagemDTO> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            ProdutoDAO dao = new ProdutoDAO(conn);

            for (ProdutosCompraListagemDTO produto : produtos) {
                boolean sucesso = dao.removerProduto(produto);
                if (!sucesso) {
                    System.err.println("Falha ao remover produto com ID: " + produto.getIdProduto());
                    return false;
                }
            }
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao remover produtos: " + e.getMessage());
            return false;
        }
    }
}
