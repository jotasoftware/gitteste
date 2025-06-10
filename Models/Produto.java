package Models;

public class Produto {
    
    private int idProduto;
    private String cnpjFarmacia;
    private String nomeProduto;
    private int qtdProduto;
    private double valorVenda;
    private double valorCusto;

    public Produto(String cnpjFarmacia, String nomeProduto, double valorVenda, double valorCusto) {
        this.cnpjFarmacia = cnpjFarmacia;
        this.nomeProduto = nomeProduto;
        this.qtdProduto = 0;
        this.valorVenda = valorVenda;
        this.valorCusto = valorCusto;
        this.idProduto = 0;
    }
    
    public Produto() {
        this.cnpjFarmacia = "";
        this.nomeProduto = "";
        this.qtdProduto = 0;
        this.valorVenda = 0;
        this.valorCusto = 0;
        this.idProduto = 0;
    }
    
    public int getIdProduto() {

        return idProduto;

    }
    
    public void setIdProduto(int id) {

        this.idProduto = idProduto;

    }

    public String getCnpjFarmacia() {

        return cnpjFarmacia;

    }
    
    public void setCnpjFarmacia(String cnpjFarmacia) {

        this.cnpjFarmacia = cnpjFarmacia;

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

    public void setValorVenda(double valorVenda) {
     
        this.valorVenda = valorVenda;

    }

    public double getValorVenda() {

        return valorVenda;

    }

    public void setValorCusto(double valorCusto) {

        this.valorCusto = valorCusto;

    }

    public double getValorCusto() {
     
        return valorCusto;
        
    }


}
