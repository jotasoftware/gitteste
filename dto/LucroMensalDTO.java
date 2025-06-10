package dto;

public class LucroMensalDTO {
    
    private double somatorioVenda;
    private double somatorioCompra;
    private double lucroMes;
    private String mes;

    public LucroMensalDTO() {

        this.somatorioCompra = 0;
        this.somatorioVenda = 0;
        this.lucroMes = 0;
        this.mes = "";

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


    public void setLucroMes(double lucroMes) {
        
        this.lucroMes = lucroMes;

    }
    
    public void setMes(String mes) {
    
        this.mes = mes;
    
    }
    
    public String getMes() {
            
        return mes;
    
    }

    public double getLucroMes() {
     
        return lucroMes;

    }


}
