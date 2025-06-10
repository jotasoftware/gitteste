package dao;

import Models.Funcionario;
import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
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
            String adiciona = "INSERT INTO \"Funcionario\" (cpf, \"cargoFuncionario\", \"turnoFuncionario\") VALUES (?, ?, ?)";
            p = con.prepareStatement(adiciona);
            String cpf = funcionario.getCpf().replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
            p.setLong(1, cpfLong);
            p.setString(2, funcionario.getCargoFuncionario());
            p.setString(3, funcionario.getTurnoFuncionario());
            p.execute();
            p.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }
        
    }
    
    public boolean verificarCPF(String cpf) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        boolean existe = false;

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT cpf FROM \"Funcionario\" WHERE cpf = ?";
            p = con.prepareStatement(sql);
            p.setLong(1, Long.parseLong(cpf));
            rs = p.executeQuery();
            if (rs.next()) { 
                existe = true;
            }
            rs.close();
            p.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro na verificação do CPF em Funcionario: " + e.getMessage());
        }
        return existe;
    }
   
    public ArrayList<Funcionario> consultarTodosFuncionarios() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT p.nome, f.\"cargoFuncionario\", f.\"turnoFuncionario\" " +
                         "FROM \"Pessoa\" p " +
                         "JOIN \"Funcionario\" f ON p.cpf = f.cpf";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargoFuncionario(rs.getString("cargoFuncionario"));
                funcionario.setTurnoFuncionario(rs.getString("turnoFuncionario"));
                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return funcionarios;
    }
    
   public String consultarDados(String cpf) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        String dados = "";

        try {
            con = DriverManager.getConnection(url, usuario, senha);
                    String sql = "SELECT p.cpf, p.nome, p.endereco, p.telefone, p.email, f.\"cargoFuncionario\", f.\"turnoFuncionario\"" +
                         "FROM \"Pessoa\" p JOIN \"Funcionario\" f ON p.cpf = f.cpf " +
                         "WHERE p.cpf = ?";
            p = con.prepareStatement(sql);
            p.setLong(1, Long.parseLong(cpf));
            rs = p.executeQuery();
            
            if (rs.next()) { 
                dados = "Nome: " + rs.getString("nome") + "\n"
                        + "CPF: " + rs.getString("cpf") + "\n"
                        + "Endereço: " + rs.getString("endereco") + "\n"
                        + "Telefone: " + rs.getString("telefone") + "\n"
                        + "Email: " + rs.getString("email") + "\n"
                        + "Função: " + rs.getString("cargoFuncionario") + "\n"
                        + "Turno: " + rs.getString("turnoFuncionario");
            }
            rs.close();
            p.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao verificar: " + e.getMessage());
        }

        return dados;
    }
}
