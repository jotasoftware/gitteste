package Models;

public class produtosVenda {
    private String cnpjFarmacia;
    private int idProduto;
    private int qtdProduto;

    private double valorProduto;

    public String getCnpjFarmacia() {
        return cnpjFarmacia;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public double getQtdProduto() {
        return qtdProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }


    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
}
