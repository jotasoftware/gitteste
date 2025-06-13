package Models;

public class Setor {
    private int idFarmacia;
    private String nome;
    private double valeTransporte;
    private double valeRefeicao;
    private double valeAlimentacao;
    private double planoSaude;
    private double planoOdontologico;

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public String getNome() {
        return nome;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    public double getValeRefeicao() {
        return valeRefeicao;
    }

    public double getValeAlimentacao() {
        return valeAlimentacao;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }
    
    public double getPlanoOdontologico() {
        return planoOdontologico;
    }

    public void setidFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValeTransporte(double valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public void setValeRefeicao(double valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    public void setValeAlimentacao(double valeAlimentacao) {
        this.valeAlimentacao = valeAlimentacao;
    }

    public void setPlanoSaude(double planoSaude) {
        this.planoSaude = planoSaude;
    }
    
    public void setPlanoOdontologico(double planoOdontologico) {
        this.planoOdontologico = planoOdontologico;
    }


    public Setor(int idFarmacia, String nome, double valeTransporte, double valeRefeicao,
                 double valeAlimentacao, double planoSaude, double planoOdontologico) {
        this.idFarmacia = idFarmacia;
        this.nome = nome;
        this.valeTransporte = valeTransporte;
        this.valeRefeicao = valeRefeicao;
        this.valeAlimentacao = valeAlimentacao;
        this.planoSaude = planoSaude;
        this.planoOdontologico = planoOdontologico;
    }
}