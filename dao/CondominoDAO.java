package dao;

import Models.Condomino;
import java.sql.*;

public class CondominoDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public void adicionar(Condomino condomino){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String adiciona = "INSERT INTO \"Condomino\" (\"cpfCondomino\", \"aptoCondomino\") VALUES (?, ?)";
            p = con.prepareStatement(adiciona);
            String cpf = condomino.getCpf().replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
            p.setLong(1, cpfLong);
            p.setInt(2, condomino.getAptoCondomino());
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
            String sql = "SELECT \"cpfCondomino\" FROM \"Condomino\" WHERE \"cpfCondomino\" = ?";
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
            System.out.println("Erro na verificação do CPF em Condomino: " + e.getMessage());
        }

        return existe;
    }
    
    public int verificarApto(String cpf) {
        int apto = 0;
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        boolean existe = false;

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT \"aptoCondomino\" FROM \"Condomino\" WHERE \"cpfCondomino\" = ?";
            p = con.prepareStatement(sql);
            p.setLong(1, Long.parseLong(cpf));
            rs = p.executeQuery();

            if (rs.next()) { 
                existe = true;
                apto = rs.getInt("aptoCondomino");
            } else {
                apto = -1; 
            }

            rs.close();
            p.close();
            con.close();
            
          
        } catch (Exception e) {
            System.out.println("Erro ao verificar CPF em Condomino: " + e.getMessage());
        }

        return apto;
    }
    
    public String consultarDados(String cpf) {
        int apto = 0;
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        String dados = "";

        try{
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT p.cpf, p.nome, p.endereco, p.telefone, p.email, c.\"aptoCondomino\" " +
                         "FROM \"Pessoa\" p JOIN \"Condomino\" c ON p.cpf = c.\"cpfCondomino\" " +
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
                        + "Apartamento: " + rs.getInt("aptoCondomino");
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
