package dto;

public class SetorListagemDTO {
    private int id;
    private String cnpjFarmacia;
    private String nome;
    private double valeTransporte;
    private double valeRefeicao;
    private double valeAlimentacao;
    private double planoSaude;
    private double planoOdontologico;
    private int qtdFuncionarios;

    public SetorListagemDTO() {
        this.id = 0;
        this.cnpjFarmacia = "";
        this.nome = "";
        this.valeTransporte = 0;
        this.valeRefeicao = 0;
        this.valeAlimentacao = 0;
        this.planoSaude = 0;
        this.qtdFuncionarios = 0;
    }

    public String getCnpjFarmacia() {
        return cnpjFarmacia;
    }

    public void setCnpjFarmacia(String cnpjFarmacia) {
        this.cnpjFarmacia = cnpjFarmacia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(double valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public double getValeRefeicao() {
        return valeRefeicao;
    }

    public void setValeRefeicao(double valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    public double getValeAlimentacao() {
        return valeAlimentacao;
    }

    public void setValeAlimentacao(double valeAlimentacao) {
        this.valeAlimentacao = valeAlimentacao;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(double planoSaude) {
        this.planoSaude = planoSaude;
    }
    
    public double getPlanoOdontologico() {
        return planoOdontologico;
    }

    public void setPlanoOdontologico(double planoOdontologico) {
        this.planoOdontologico = planoOdontologico;
    }

    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
