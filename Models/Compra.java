package Models;

import java.time.LocalDate;

public class Compra {
    
    private int idCompra;
    private int idFuncionario;
    private LocalDate dataCompra;
    private int idFarmacia;


    public Compra(int idFarmacia) {

        this.idCompra = 0;
        this.idFuncionario = 0;
        this.idFarmacia = idFarmacia;
        this.dataCompra = null;

    }
    
     public int getIdFarmacia() {

        return idFarmacia;

    }
     
    public void setIdFarmacia(int idFarmacia) {

        this.idFarmacia = idFarmacia;

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
