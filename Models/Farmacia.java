package Models;

public class Farmacia {
    private String nome;
    private String cnpjFarmacia;

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




    public Farmacia(String nome, String cnpjFarmacia) {
       
        this.nome = nome;
        this.cnpjFarmacia = cnpjFarmacia;
       
    }
}