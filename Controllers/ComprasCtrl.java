package Controllers;

import dao.CompraDAO;
import Models.Compra;
import Models.ProdutosCompra;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ComprasCtrl {

    private CompraDAO compraDAO;
    
    public ComprasCtrl() {
        this.compraDAO = new CompraDAO();
    }

    public int criarNovaCompra() {
    try {

        Compra compra = new Compra(Sessao.getIdFarmaciaLogada());
        return compraDAO.gerarCompra(compra);

    } catch (Exception e) {
        System.out.println("Erro ao criar nova compra: " + e.getMessage());
        return -1;
    }
}

//    public Compra buscarCompra(int idCompra) {
//        try {
//            return ComprasDAO.buscarCompraPorId(idCompra);
//        } catch (SQLException e) {
//            System.err.println("Erro ao buscar compra no banco de dados: " + e.getMessage());
//            return null;
//        }
//    }
//
//    public List<CompraListagemDTO> listarCompras() {
//        try {
//            return ComprasDAO.listarTodasCompras();
//        } catch (SQLException e) {
//            System.err.println("Erro ao listar compras do banco de dados: " + e.getMessage());
//            return List.of(); // Retorna uma lista vazia em caso de erro
//        }
//    }
//
//    public boolean atualizarInformacoesCompra(int idCompra, int novoIdFuncionario, LocalDate novaDataCompra, String novoCnpjFarmacia) {
//        try {
//            Compra compraExistente = ComprasDAO.buscarCompraPorId(idCompra);
//            if (compraExistente == null) {
//                System.err.println("Compra com ID " + idCompra + " não encontrada para atualização.");
//                return false;
//            }
//
//            compraExistente.setIdFuncionario(novoIdFuncionario);
//            compraExistente.setDataCompra(novaDataCompra);
//
//            boolean sucesso = ComprasDAO.atualizarCompra(compraExistente);
//            if (sucesso) {
//                System.out.println("Compra com ID " + idCompra + " atualizada com sucesso.");
//            } else {
//                System.err.println("Falha ao atualizar a compra com ID " + idCompra + ".");
//            }
//            return sucesso;
//        } catch (SQLException e) {
//            System.err.println("Erro ao atualizar a compra no banco de dados: " + e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean excluirCompra(int idCompra) {
//        try {
//            boolean sucesso = ComprasDAO.excluirCompra(idCompra);
//            if (sucesso) {
//                System.out.println("Compra com ID " + idCompra + " e seus produtos associados excluídos e estoque atualizado com sucesso.");
//            } else {
//                System.err.println("Falha ao excluir a compra com ID " + idCompra + ".");
//            }
//            return sucesso;
//        } catch (SQLException e) {
//            System.err.println("Erro ao excluir a compra no banco de dados: " + e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean adicionarProdutoEmCompra(int idCompra, int idProduto, String cnpjFarmacia, int quantidade) {
//        if (quantidade <= 0) {
//            System.err.println("Erro: A quantidade a ser adicionada deve ser maior que zero.");
//            return false;
//        }
//        try {
//            boolean sucesso = ComprasDAO.adicionarProdutoNaCompra(idCompra, idProduto, cnpjFarmacia, quantidade);
//            if (sucesso) {
//                System.out.println("Produto " + idProduto + " (qtd: " + quantidade + ") adicionado à compra " + idCompra + " e estoque atualizado.");
//            } else {
//                System.err.println("Falha ao adicionar produto " + idProduto + " à compra " + idCompra + ".");
//            }
//            return sucesso;
//        } catch (SQLException e) {
//            System.err.println("Erro ao adicionar produto à compra no banco de dados: " + e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean removerProdutoDeCompra(int idCompra, int idProduto) {
//        try {
//            boolean sucesso = ComprasDAO.removerProdutoDaCompra(idCompra, idProduto);
//            if (sucesso) {
//                System.out.println("Produto " + idProduto + " removido da compra " + idCompra + " e estoque atualizado.");
//            } else {
//                System.err.println("Falha ao remover produto " + idProduto + " da compra " + idCompra + ".");
//            }
//            return sucesso;
//        } catch (SQLException e) {
//            System.err.println("Erro ao remover produto da compra no banco de dados: " + e.getMessage());
//            return false;
//        }
//    }
}