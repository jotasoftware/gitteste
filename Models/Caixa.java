package Models;


public class Caixa {

    private String cnpjFarmacia;
    private double valorInicial;
    private double valorAtual;

    public Caixa(double valorInicial, String cnpjFarmacia) {

        this.valorInicial = valorInicial;
        this.valorAtual = 0;
        this.cnpjFarmacia = cnpjFarmacia;

    }


    public String getCnpjFarmacia() {

        return cnpjFarmacia;

    }

    public void setValorInicial(double valorInicial) {

        this.valorInicial = valorInicial;

    }

    public double getValorInicial() {
        
        return valorInicial;

    }

    public void setValorAtual(double valorAtual) {

        this.valorAtual = valorAtual;

    }

    public double getValorAtual() {

        return valorAtual;

    }

}
