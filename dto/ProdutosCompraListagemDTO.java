package dto;

public class ProdutosCompraListagemDTO {

    private String nomeProduto;
    private int idProduto;
    private int qtdProduto;
    private double valorTotal;


    public void setIdProduto(int idProduto) {

        this.idProduto = idProduto;

    }

    public int getIdProduto() {
     
        return  idProduto;

    }

    public void setNomeProduto(String nomeProduto) {

        this.nomeProduto = nomeProduto;

    }

    public String getNomeProduto() {

        return nomeProduto;

    }

    public void setQtdProduto(int qtdProduto) {

        this.qtdProduto = qtdProduto;

    }

    public int getQtdProduto() {

        return qtdProduto;

    }

    public void setValorTotal(double valorTotal) {

        this.valorTotal = valorTotal;

    }

    public double getValorTotal() {

        return valorTotal;
        
    }







}
