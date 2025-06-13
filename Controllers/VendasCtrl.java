package Controllers;

import dao.VendaDAO;
import Models.ProdutosCompraVenda;
import Models.Venda;
import dto.ProdutosCompraListagemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendasCtrl {

    private VendaDAO dao;
    
    public VendasCtrl() {
        this.dao = new VendaDAO();
    }

    public int criarNovaVenda(int idFuncionario) {
        try {

            Venda venda = new Venda(Sessao.getIdFarmaciaLogada(), idFuncionario);
            return dao.gerarVenda(venda);

        } catch (Exception e) {
            System.out.println("Erro ao criar nova venda: " + e.getMessage());
            return -1;
        }
    }

    public boolean adicionarProdutoEmVenda(int idVenda, int idProduto, int quantidade) {
        
       
        ProdutosCompraVenda produtoVenda = new ProdutosCompraVenda(Sessao.getIdFarmaciaLogada(), idVenda, idProduto, quantidade);
        boolean sucesso = dao.adicionarProdutoNaVenda(produtoVenda);

        return sucesso;
    }
    
    public ArrayList<ProdutosCompraListagemDTO> listarProdutosEmVenda(int idVenda) {
        
      
        return dao.listarProdutosNaVenda(idVenda);

    }
    
    public boolean apagar(int idVenda, int idProduto) {
     
        return dao.remover(idVenda, idProduto);

    }
    
    public boolean finalizarVenda(int idVenda, double total, LocalDate data) {
        return dao.finalizarVenda(idVenda, total, data);
    }

}