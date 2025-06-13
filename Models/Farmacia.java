package Models;

public class Farmacia {
    private String nome;
    private String cnpjFarmacia;
    private double saldoInicial;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setCnpj(String cnpjFarmacia) {

        this.cnpjFarmacia = cnpjFarmacia;

    }
    
    public String getCnpj() {

        return cnpjFarmacia;
        
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Farmacia(String nome, String cnpjFarmacia, double saldoInicial) {
       
        this.nome = nome;
        this.cnpjFarmacia = cnpjFarmacia;
        this.saldoInicial = saldoInicial;
       
    }
}