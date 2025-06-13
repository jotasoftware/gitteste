package dto;

public class LucroListagemDTO {
    
    private double somatorioVenda;
    private double somatorioCompra;
    private double lucro;
    private String data;

    public LucroListagemDTO() {

        this.somatorioCompra = 0;
        this.somatorioVenda = 0;
        this.lucro = 0;
        this.data = "";

    }

    public void setSomatorioVenda(double somatorioVenda) {
        
        this.somatorioVenda = somatorioVenda;

    }

    public double getSomatorioVenda() {
        
        return somatorioVenda;

    }

    public void setSomatorioCompra(double somatorioCompra) {
        
        this.somatorioCompra = somatorioCompra;

    }

    public double getSomatorioCompra() {
        
        return somatorioCompra;

    }


    public void setLucro(double lucro) {
        
        this.lucro = lucro;

    }
    
    public void setData(String data) {
    
        this.data = data;
    
    }
    
    public String getData() {
            
        return data;
    
    }

    public double getLucro() {
     
        return lucro;

    }


}
