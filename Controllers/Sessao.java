package Controllers;

public class Sessao {
    private static int idFarmacia;

    public static int getIdFarmaciaLogada() {
        return idFarmacia;
    }

    public static void setIdFamaciaLogada(int id) {
        idFarmacia = id;
    }
    
    public static void limparSessao() {
        idFarmacia = 0;
    }
}
