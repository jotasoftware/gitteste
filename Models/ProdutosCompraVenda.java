package Models;

public class ProdutosCompraVenda {

    private int idFarmacia;
    private int idNota;
    private int idProduto;
    private int quant;
    
    public ProdutosCompraVenda(int idFarmacia, int idNota, int idProduto, int quant){
        this.idFarmacia = idFarmacia;
        this.idNota = idNota;
        this.idProduto = idProduto;
        this.quant = quant;
    }

    public ProdutosCompraVenda() {
        idFarmacia = 0;
        idNota = 0;
        idProduto = 0;
        quant = 0;
    }

    private int getIdFarmacia() {
     
        return idFarmacia;

    }

    public void setIdNota(int idNota) {
    
        this.idNota = idNota;

    }

    public int getIdNota() {

        return idNota;

    }

    public void setIdProduto(int idProduto) {

        this.idProduto = idProduto;

    }

    public int getIdProduto() {
     
        return  idProduto;

    }
    
    public void setQuant(int quant) {

        this.quant = quant;

    }

    public int getQuant() {
     
        return  quant;

    }

}
