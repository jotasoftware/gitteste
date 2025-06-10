package Models;

public class Venda {
    private String cnpjFarmacia;
    private int idVendaProduto;
    private int idVenda;
    private int idFuncionario;

    public Venda(String cnpjFarmacia, int idVendaProduto, int idVenda, int idFuncionario) {
        this.cnpjFarmacia = cnpjFarmacia;
        this.idVendaProduto = idVendaProduto;
        this.idVenda = idVenda;
        this.idFuncionario = idFuncionario;
    }

    public Venda() {
        
        this.idVendaProduto = 0;
        this.idVenda = 0;
        this.idFuncionario = 0;
        
    }
    
    public String getcnpjFarmacia() {
        
        return cnpjFarmacia;
    
    }
    
    public void setIdVendaProduto(int idVendaProduto) {
        
        this.idVendaProduto = idVendaProduto;

    }

    public int getIdVendaProduto() {
        
        return idVendaProduto;

    }

    public void setIdVenda(int idVenda) {
        
        this.idVenda = idVenda;

    }
    public int getIdVenda() {
        
        return idVenda;

    }

    public void setIdFuncionario(int idFuncionario) {
        
        this.idFuncionario = idFuncionario;

    }

    public int getIdFuncionario() {
        
        return idFuncionario;

    }


}
