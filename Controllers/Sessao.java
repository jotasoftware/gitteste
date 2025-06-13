package Controllers;

public class Sessao {
    private static int idFarmacia;
    private static int idFuncionarioCompraVenda;

    public static int getIdFarmaciaLogada() {
        return idFarmacia;
    }

    public static void setIdFamaciaLogada(int id) {
        idFarmacia = id;
    }
    
    public static int getIdFuncionarioCompraVenda() {
        return idFuncionarioCompraVenda;
    }

    public static void setIdFuncionarioCompraVenda(int id) {
        idFuncionarioCompraVenda = id;
    }
    
    public static void limparSessao() {
        idFarmacia = 0;
    }

}
