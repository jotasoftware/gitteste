package Projeto.controllers;

import Projeto.models.Venda;
import Projeto.models.Produto;

public class VendasCtrl {
    private double valorVenda;
    private double qtdVenda;
    private double totalVenda;
    SessaoDAO dao;
    ProdutoDAO daoProduto;

    public double getValorVenda() {
        return valorVenda;
    }
    public double getQtdVenda() {
        return qtdVenda;
    }
    public void setValorVenda(double valorVenda) {
        this.valorVenda = produto.getValorVenda();
    }
    public void setQtdVenda(double qtdVenda) {
        this.qtdVenda = qtdVenda;
    }
    Produto produto = new Produto();

    public void setTotalVenda(){
        this.totalVenda = qtdVenda * valorVenda;
    }

    public double getTotalVenda () {
        return totalVenda;
    }

    public vendasCtrl(){
        dao = new SessaoDAO();
        daoProduto = new ProdutoDao();
    }

}
