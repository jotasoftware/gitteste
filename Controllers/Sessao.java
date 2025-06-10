package Controllers;

public class Sessao {
    private static int idFarmacia;

    public static int getIdFarmacia() {
        return idFarmacia;
    }

    public static void setIdFarmacia(int id) {
        idFarmacia = id;
    }
    
    public static void limparSessao() {
        idFarmacia = 0;
    }
}
