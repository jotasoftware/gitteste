package Models;

public class Produto {
    
    private int idProduto;
    private int idFarmacia;
    private String nomeProduto;
    private int qtdProduto;
    private double valorVenda;
    private double valorCusto;

    public Produto(int idFarmacia, String nomeProduto, double valorVenda, double valorCusto) {
        this.idFarmacia = idFarmacia;
        this.nomeProduto = nomeProduto;
        this.qtdProduto = 0;
        this.valorVenda = valorVenda;
        this.valorCusto = valorCusto;
        this.idProduto = 0;
    }
    
    public Produto() {
        this.idFarmacia = 0;
        this.nomeProduto = "";
        this.qtdProduto = 0;
        this.valorVenda = 0;
        this.valorCusto = 0;
        this.idProduto = 0;
    }
    
    public int getIdProduto() {

        return idProduto;

    }
    
    public void setIdProduto(int idProduto) {

        this.idProduto = idProduto;

    }

    public int getidFarmacia() {

        return idFarmacia;

    }
    
    public void setidFarmacia(int idFarmacia) {

        this.idFarmacia = idFarmacia;

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

    @Override
    public String toString() {
        return this.nomeProduto + " " + this.qtdProduto; // ou qualquer info útil
    }

    

}