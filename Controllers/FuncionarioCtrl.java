package Controllers;

import Models.Funcionario;
import Models.Genero;
import config.DatabaseConnection;
import dao.FarmaciaDAO;
import dao.FuncionarioDAO;
import dto.FuncionarioListagemDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class FuncionarioCtrl {
    
    public FuncionarioCtrl() {
    }

    public boolean cadastrar(String nome, String idade, String salario, String genero, int idSetor) {
        try {
            int idadeInt = Integer.parseInt(idade);
            double salarioDouble = Double.parseDouble(salario.replace(",", ".")); 

            if (nome == null || nome.trim().isEmpty() || idadeInt <= 0 || salarioDouble <= 0) {
                return false;
            }

            Genero generoEnum = Genero.valueOf(genero);

            Funcionario funcionario = new Funcionario(nome, idadeInt, salarioDouble, generoEnum, idSetor, Sessao.getIdFarmaciaLogada());
            
            try (Connection conn = DatabaseConnection.getConnection()) {
                FuncionarioDAO dao = new FuncionarioDAO(conn);
                return dao.adicionar(funcionario);
            } catch (SQLException e) {
                System.err.println("Erro de banco de dados ao cadastrar funcionário: " + e.getMessage());
                return false;
            }

        } catch (NumberFormatException e) {
            System.err.println("Erro de conversão numérica: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro com valor de enum ou argumentos inválidos: " + e.getMessage());
            return false;
        }
    }
    
    public boolean editar(String nome, String idade, String salario, String genero, int idSetor, int id) {
        try {
            int idadeInt = Integer.parseInt(idade);
            double salarioDouble = Double.parseDouble(salario.replace(",", ".")); 

            if (nome == null || nome.trim().isEmpty() || idadeInt <= 0 || salarioDouble <= 0) {
                return false;
            }

            Genero generoEnum = Genero.valueOf(genero);

            Funcionario funcionario = new Funcionario(nome, idadeInt, salarioDouble, generoEnum, idSetor, Sessao.getIdFarmaciaLogada());
            funcionario.setID(id);
            
            try (Connection conn = DatabaseConnection.getConnection()) {
                FuncionarioDAO dao = new FuncionarioDAO(conn);
                return dao.editar(funcionario);
            } catch (SQLException e) {
                System.err.println("Erro de banco de dados ao editar funcionário: " + e.getMessage());
                return false;
            }

        } catch (NumberFormatException e) {
            System.err.println("Erro de conversão numérica: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro com valor de enum ou argumentos inválidos: " + e.getMessage());
            return false;
        }
    }

    public boolean apagar(int idFuncionario) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            FuncionarioDAO dao = new FuncionarioDAO(conn);
            return dao.remover(idFuncionario);
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao apagar funcionário: " + e.getMessage());
            return false;
        }
    }

    public double getImposto(double salario) {
        if (salario <= 2428.80) {
            return 0;
        } else if (salario <= 2826.65) {
            return salario * 0.075;
        } else if (salario <= 3751.05) {
            return salario * 0.15;
        } else if (salario <= 4664.68) {
            return salario * 0.225;
        } else {
            return salario * 0.275;
        }
    }
    
    public double getSalarioLiquido(double salario) {
        return salario - getImposto(salario);
    }
    
    public ArrayList<FuncionarioListagemDTO> listarFuncionarios() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            FuncionarioDAO dao = new FuncionarioDAO(conn);
            return dao.listarFuncionariosCnpj(Sessao.getIdFarmaciaLogada());
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao listar funcionários: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public ArrayList<FuncionarioListagemDTO> listarResponsaveis(int tipo) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            FuncionarioDAO dao = new FuncionarioDAO(conn);
            return dao.listarResponsaveis(Sessao.getIdFarmaciaLogada(), tipo);
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao listar funcionários: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}    




