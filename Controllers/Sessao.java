package Controllers;

public class Sessao {
    private static String cpfUsuarioLogado;
    private static int tipoUsuario; 
    //1 = Síndico, 2 = Funcionário, 3 = Condômino, 4 = Visitante

    public static String getCpfUsuarioLogado() {
        return cpfUsuarioLogado;
    }

    public static void setCpfUsuarioLogado(String cpf) {
        cpfUsuarioLogado = cpf;
    }

    public static int getTipoUsuario() {
        return tipoUsuario;
    }

    public static void setTipoUsuario(int tipo) {
        tipoUsuario = tipo;
    }
    
    public static void limparSessao() {
        cpfUsuarioLogado = null;
        tipoUsuario = 0;
    }
}
