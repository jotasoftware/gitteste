package Controllers;

import Models.Funcionario;
import Models.Genero;
import dao.FuncionarioDAO;


public class FuncionarioCtrl {
    
    private FuncionarioDAO dao;

    public FuncionarioCtrl() {

        this.dao = new FuncionarioDAO();

    }
    

    public boolean cadastrar(String nome, String idade, String salario, String genero, int idSetor) {
        try {
            int idadeInt = Integer.parseInt(idade);
            double salarioDouble = Double.parseDouble(salario);

            if (nome == null || nome.isEmpty() || idadeInt <= 0 || salarioDouble <= 0) {
                return false;
            }

            Genero generoEnum = Genero.valueOf(genero);

            Funcionario funcionario = new Funcionario(nome, idadeInt, salarioDouble, generoEnum, idSetor, Sessao.getIdFarmaciaLogada());
            dao.adicionar(funcionario);
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Erro de conversão numérica: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro com valor de enum ou argumentos inválidos: " + e.getMessage());
            return false;
        }
    }

    public double getImposto(double salario) {
        if (salario <= 2428.80 && salario > 0) {
            return 0;
        }else if (salario <= 2826.65 && salario > 2428.80){
            return salario * 0.075;
        } else if (salario <=3751.05  && salario > 2826.65) {
            return salario * 0.15;
        } else if (salario <=4664.68  && salario > 3751.05) {
            return salario * 0.225;
        } else if (salario > 4664.68) {
            return salario * 0.275;
        }else {
            return 0;
        }
    }
    
    public double getSalarioLiquido(double salario) {
        return salario - getImposto(salario);
    }
    
 
    public boolean apagar(int idFuncionario) {
     
        return dao.remover(idFuncionario);

    }
}    




