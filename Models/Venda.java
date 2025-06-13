package Models;

import java.time.LocalDate;

public class Venda {
    
    private int idVenda;
    private int idFuncionario;
    private LocalDate dataVenda;
    private int idFarmacia;


    public Venda(int idFarmacia, int idFuncionario) {

        this.idVenda = 0;
        this.idFuncionario = idFuncionario;
        this.idFarmacia = idFarmacia;
        this.dataVenda = null;

    }
    
     public int getIdFarmacia() {

        return idFarmacia;

    }
     
    public void setIdFarmacia(int idFarmacia) {

        this.idFarmacia = idFarmacia;

    }

    public void setIdVenda(int idVenda) {
        
        this.idVenda = idVenda;

    }

    public int getIdVenda() {
        
        return idVenda;

    }

    public void setIdFuncionario(int idFuncionario) {
    
        this.idFuncionario = idFuncionario;

    }

    public int getIdFuncionario() {
    
        return idFuncionario;

    }

    public void setDataVenda(LocalDate dataVenda) {
        
        this.dataVenda = dataVenda;

    }

    public LocalDate getDataVenda() {
     
        return dataVenda;

    }

    


}
