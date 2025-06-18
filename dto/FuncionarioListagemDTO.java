package dto;

public class FuncionarioListagemDTO {
    
    private int idFuncionario;
    private String nomeFuncionario;
    private int idade;
    private double salarioBase;
    private String nomeSetor;
    private double valeTransporte;
    private double valeRefeicao;
    private double valeAlimentacao;
    private double planoSaude;
    private double planoOdontologico;

    
    public FuncionarioListagemDTO() {

        this.idFuncionario = 0;
        this.nomeFuncionario = "";
        this.salarioBase = 0.0;
        this.idade = 0;
        this.nomeSetor = "";
        this.valeTransporte = 0.0;
        this.valeRefeicao = 0.0;
        this.valeAlimentacao = 0.0;
        this.planoSaude = 0.0;
        this.planoOdontologico = 0.0;

    }

    public void setIdFuncionario(int idFuncionario) {
     
        this.idFuncionario = idFuncionario;

    }

    public int getIdFuncionario() {
     
        return idFuncionario;

    }
    
    public void setIdade(int idade) {
     
        this.idade = idade;

    }

    public int getIdade() {
     
        return idade;

    }

    public void setNomeFuncionario(String nomeFuncionario) {

        this.nomeFuncionario = nomeFuncionario;

    }

    public  String getNomeFuncionario() {
        
        return nomeFuncionario;

    }

    public void setSalarioBase(double salarioBase) {
     
        this.salarioBase = salarioBase;

    }

    public double getSalarioBase() {

        return salarioBase;

    }

    public void setNomeSetor(String nomeSetor) {
     
        this.nomeSetor = nomeSetor;

    }

    public String getNomeSetor() {
     
        return nomeSetor;

    }

    public void setValeTransporte(double valeTransporte) {

        this.valeTransporte = valeTransporte;

    }

    public double getValeTransporte() {
     
        return valeTransporte;

    }

    public void setValeRefeicao(double valeRefeicao) {
     
        this.valeRefeicao = valeRefeicao;

    }

    public double getValeRefeicao() {
        
        return valeRefeicao;

    }

    public void setValeAlimentacao(double valeAlimentacao) {

        this.valeAlimentacao = valeAlimentacao;

    }

    public double getValeAlimentacao() {
        
        return valeAlimentacao;
        
    }

    public void setPlanoSaude(double planoSaude) {
        
        this.planoSaude = planoSaude;

    }

    public double getPlanoSaude() {
    
        return planoSaude;

    }
    
    public double getPlanoOdontologico() {
        return planoOdontologico;
    }

    public void setPlanoOdontologico(double planoOdontologico) {
        this.planoOdontologico = planoOdontologico;
    }



}
