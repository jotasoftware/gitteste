package dto;

import java.time.LocalDate;

public class CompraListagemDTO {
    
    private int idCompra;
    private String nomeFuncionario;
    private LocalDate dataCompra;
    private int qtdProdutos;
    private double valorFinal;


    public CompraListagemDTO() {

        this.idCompra = 0;
        this.nomeFuncionario = "";
        this.dataCompra = null;
        this.qtdProdutos = 0;
        this.valorFinal = 0;

    }


    public void setIdCompra(int idCompra) {

        this.idCompra = idCompra;

    }

    public int getIdCompra() {

        return idCompra;

    }

    public void setNomeFuncionario(String nomeFuncionario) {

        this.nomeFuncionario = nomeFuncionario;

    }

    public String getNomeFuncionario() {

        return nomeFuncionario;

    }

    public void setDataCompra(LocalDate dataCompra) {

        this.dataCompra = dataCompra;

    }

    public LocalDate getDataCompra() {

        return dataCompra;

    }

    public void setQtdProdutos(int qtdProdutos) {

        this.qtdProdutos = qtdProdutos;

    }

    public int getQtdProdutos() {
        
        return qtdProdutos;

    }

    public void setValorFinal(double valorFinal) {

        this.valorFinal = valorFinal;

    }

    public double getValorFinal() {

        return valorFinal;
        
    }

}
