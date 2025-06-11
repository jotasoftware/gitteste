package Controllers;

import Models.Farmacia;
import Models.Produto;
import dao.ProdutoDAO;

public class ProdutoCtrl {
    private ProdutoDAO dao;

    public ProdutoCtrl() {
        this.dao = new ProdutoDAO();
    }

    public boolean registrarProduto(String nomeProduto, String valorVenda, String valorCusto) {
        
        try {
            String textoFormatado = valorVenda.replace(",", ".");
            double valorVendaDouble = Double.parseDouble(textoFormatado);

            textoFormatado = valorCusto.replace(",", ".");
            double valorCompraDouble = Double.parseDouble(textoFormatado);

            if (nomeProduto == null || nomeProduto.isEmpty() || 
                valorVendaDouble == 0 || valorCompraDouble == 0) {
                return false;
            }

            Produto produto = new Produto(Sessao.getIdFarmaciaLogada(), nomeProduto, valorVendaDouble, valorCompraDouble);
           
            dao.criarProduto(produto);
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter valores: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Erro inesperado ao registrar produto: " + e.getMessage());
            return false;
        }
    }


}
