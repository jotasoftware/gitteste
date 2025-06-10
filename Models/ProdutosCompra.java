package Models;

public class ProdutosCompra {

    private String cnpjFarmacia;
    private int idNotaCompra;
    private int idProduto;

    private String getCnpjFarmacia() {
     
        return cnpjFarmacia;

    }

    public void setIdNotaCompra(int idNotaCompra) {
    
        this.idNotaCompra = idNotaCompra;

    }

    public int getIdNotaCompra() {

        return idNotaCompra;

    }

    public void setIdProduto(int idProduto) {

        this.idProduto = idProduto;

    }

    public int getIdProduto() {
     
        return  idProduto;

    }

}
