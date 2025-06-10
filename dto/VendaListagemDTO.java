package dto;

import java.time.LocalDate;

public class VendaListagemDTO {
    
    private int idCompra;
    private String nomeFuncionario;
    private LocalDate dataCompra;
    private int qtdProdutos;
    private double valorFinal;


    public VendaListagemDTO() {

        this.idCompra = 0;
        this.nomeFuncionario = "";
        this.dataCompra = null;
        this.qtdProdutos = 0;
        this.valorFinal = 0;

    }


    public void setIdVenda(int idCompra) {

        this.idCompra = idCompra;

    }

    public int getIdVenda() {

        return idCompra;

    }

    public void setNomeFuncionario(String nomeFuncionario) {

        this.nomeFuncionario = nomeFuncionario;

    }

    public String getNomeFuncionario() {

        return nomeFuncionario;

    }

    public void setDataVenda(LocalDate dataCompra) {

        this.dataCompra = dataCompra;

    }

    public LocalDate getDataVenda() {

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
