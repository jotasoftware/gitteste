package Models;

import java.time.LocalDate;

public class Encomenda {
    private int idEncomenda;
    private LocalDate dataEncomenda;
    private int aptoEncomenda;
    private String cpfFuncionario;

    public Encomenda() {
        this.idEncomenda = 0;
        this.dataEncomenda = LocalDate.now();
        this.aptoEncomenda = 0;
        this.cpfFuncionario = "";
    }

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public LocalDate getDataEncomenda() {
        return dataEncomenda;
    }

    public void setDataEncomenda(LocalDate dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public int getAptoEncomenda() {
        return aptoEncomenda;
    }

    public void setAptoEncomenda(int aptoEncomenda) {
        this.aptoEncomenda = aptoEncomenda;
    }
    
    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }
    
    
}
