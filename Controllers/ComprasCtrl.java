package Controllers;

import dao.CompraDAO;
import Models.Compra;
import Models.ProdutosCompraVenda;
import dto.ProdutosCompraListagemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ComprasCtrl {

    private CompraDAO dao;
    
    public ComprasCtrl() {
        this.dao = new CompraDAO();
    }

    public int criarNovaCompra(int idFuncionario) {
        try {

            Compra compra = new Compra(Sessao.getIdFarmaciaLogada(), idFuncionario);
            return dao.gerarCompra(compra);

        } catch (Exception e) {
            System.out.println("Erro ao criar nova compra: " + e.getMessage());
            return -1;
        }
    }

    public boolean adicionarProdutoEmCompra(int idCompra, int idProduto, int quantidade) {
        
       
        ProdutosCompraVenda produtoCompra = new ProdutosCompraVenda(Sessao.getIdFarmaciaLogada(), idCompra, idProduto, quantidade);
        boolean sucesso = dao.adicionarProdutoNaCompra(produtoCompra);

        return sucesso;
    }
    
    public ArrayList<ProdutosCompraListagemDTO> listarProdutosEmCompra(int idCompra) {
        
      
        return dao.listarProdutosNaCompra(idCompra);

    }
    
    public boolean apagar(int idCompra, int idProduto) {
     
        return dao.remover(idCompra, idProduto);

    }
    
    public boolean finalizarCompra(int idCompra, double total) {
        return dao.finalizarCompra(idCompra, total);
    }

}