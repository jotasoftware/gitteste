package dao;

import Models.Funcionario;
import java.sql.*;

public class FuncionarioDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/farmaciateste";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public void adicionar(Funcionario funcionario){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "INSERT INTO Funcionario (nomeCompleto, idade, genero, idSetor, salarioBase, idFarmacia) VALUES (?, ?, ?::genero_enum, ?, ?, ?)";
            p = con.prepareStatement(sql);
            p.setString(1, funcionario.getNome());
            p.setDouble(2, funcionario.getIdade());
            p.setString(3, funcionario.getGenero().name());
            p.setDouble(4, funcionario.getIdSetor());
            p.setDouble(5, funcionario.getSalario());
            p.setInt(6, funcionario.getIdFarmacia());
            p.execute();
            p.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }
        
    }
    

    public boolean remover(int idFuncionario) {
        Connection con = null;
        PreparedStatement p = null;

        try {
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println("Falha ao carregar o driver: " + e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "DELETE FROM Funcionario WHERE idFuncionario = ?";
            p = con.prepareStatement(sql);
            p.setInt(1, idFuncionario);
            int linhasAfetadas = p.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Funcionário removido com sucesso.");
                return true;
            } else {
                System.out.println("Nenhum funcionário encontrado com o ID informado.");
            }

            p.close();
            con.close();
            
            return false;
        } catch (Exception e) {
            System.out.println("Falha na exclusão: " + e.getMessage());
            return false;
        }
    }

}