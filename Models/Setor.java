package Models;

import java.util.List;

public class Setor {
    private String cnpjFarmacia;
    private String nome;
    private double valeTransporte;
    private double valeRefeicao;
    private double valeAlimentacao;
    private double planoSaude;

    public String getCnpjFarmacia() {
        return cnpjFarmacia;
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

    public void setCnpjFarmacia(String cnpjFarmacia) {
        this.cnpjFarmacia = cnpjFarmacia;
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


    public Setor(String cnpjFarmacia, String nome, double valeTransporte, double valeRefeicao,
                 double valeAlimentacao, double planoSaude) {
        this.cnpjFarmacia = cnpjFarmacia;
        this.nome = nome;
        this.valeTransporte = valeTransporte;
        this.valeRefeicao = valeRefeicao;
        this.valeAlimentacao = valeAlimentacao;
        this.planoSaude = planoSaude;
    }
}
