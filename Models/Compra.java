package Projeto.models;

import java.time.LocalDate;

public class Compra {
    
    private int idCompra;
    private int idFuncionario;
    private LocalDate dataCompra;
    private String cnpjFarmacia;

    
    public String getCnpjFarmacia() {

        return cnpjFarmacia;

    }


    public Compra() {

        this.idCompra = 0;
        this.idFuncionario = 0;
        this.dataCompra = null;

    }

    public void setIdCompra(int idCompra) {
        
        this.idCompra = idCompra;

    }

    public int getIdCompra() {
        
        return idCompra;

    }

    public void setIdFuncionario(int idFuncionario) {
    
        this.idFuncionario = idFuncionario;

    }

    public int getIdFuncionario() {
    
        return idFuncionario;

    }

    public void setDataCompra(LocalDate dataCompra) {
        
        this.dataCompra = dataCompra;

    }

    public LocalDate getDataCompra() {
     
        return dataCompra;

    }

    


}
