package Controllers;

import Models.Funcionario;
import Models.Genero;
import Projeto.models.Setor;
import Projeto.models.Transportadora;
import Projeto.utils.ValidadorCNPJ;
import java.util.ArrayList;


public class FuncionarioCtrl {
    
    private FuncionarioDAO dao;

    public FuncionarioCtrl() {

        this.dao = new FuncionarioDAO();

    }
    
    public boolean salvar(Funcionario Funcionario) {

        if (Funcionario.getNome() == null || Funcionario.getNome().isEmpty() || 
            Funcionario.getIdade() == 0 ||  Funcionario.getSalario() == 0 ){

                return false;

            }


            boolean sucesso = dao.adicionar(Funcionario);
            
    }

    public boolean verificarFuncionario(String cnpjFuncionario) {

        return dao.verificarCnpj(cnpjFuncionario);
        
    }
    

    public boolean cadastrar(String nome, int idade, double salario, String genero, int idSetor) {
        
        if (nome == null || nome.isEmpty() || 
            idade == 0 ||  salario == 0 ){

                return false;

            }
        
        String generoParaEnum = genero.toUpperCase();
        Genero generoEnum = Genero.valueOf(generoParaEnum);
        
        Funcionario funcionario = new Funcionario(nome, idade, salario, generoEnum, idSetor);
       
        return dao.adicionar(funcionario);

    }


    public ArrayList<Setor> listarSetores() {

        return dao.listarSetoresPorFuncionario(Sessao.getCnpjFuncionario());

    }

    public ArrayList<Transportadora> listaTransportadoras() {

        return dao.listarTransportadorasPorFuncionario(Sessao.getCnpjFuncionario());

    }

    public ArrayList<Funcionario> listarFuncionarios() {

        return dao.listarFuncionarios;
        
    }

    public ArrayList<Produtos> listarProdutos() {

        return dao.listarProdutos();
        
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




