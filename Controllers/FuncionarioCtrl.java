package Controllers;

import Models.Funcionario;
import dao.FuncionarioDAO;
import java.util.ArrayList;


public class FuncionarioCtrl {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioCtrl() {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    public ArrayList<Funcionario> listarFuncionarios() {
        return funcionarioDAO.consultarTodosFuncionarios();
    }
    
    public boolean verificarFuncionario(String cpf) {
        return funcionarioDAO.verificarCPF(cpf);
    }
}
