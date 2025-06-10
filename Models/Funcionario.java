package Models;

public class Funcionario {

    private String nome;
    private int id;
    private int idade;
    private Genero genero;
    private double salario;
    private int idFarmacia;
    private int idSetor;


    public Funcionario(String nome, int idade, double salario, Genero genero, int idSetor) {

        this.nome = nome;
        this.id = 0;
        this.idade = idade;
        this.genero = genero;
        this.salario = salario;
        this.idSetor = idSetor;
        
    }
    
    public int getIdFarmacia() {
        
        return idFarmacia;

    }

    public void setNome(String nome) {
        
        this.nome = nome;
        
    }

    public String getNome() {
        
        return nome;

    }

    public void setID(int id) {

        this.id = id;

    }

    public int getID() {

        return id;

    }

    public void setIdade(int idade) {

        this.idade = idade;

    }

    public int getIdade() {

        return idade;

    }

    public void setGenero(Genero genero) {

        this.genero = genero;

    }


    public Genero getGenero() {

        return genero;

    }

    public void setSalario(double salario) {
    
        this.salario = salario;

    }

    public double getSalario() {

        return salario;

    }

    public void setIdSetor(int idSetor) {
    
        this.idSetor = idSetor;

    }

    public int getIdSetor() {

        return idSetor;

    }


    
}