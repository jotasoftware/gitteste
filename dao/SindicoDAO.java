package dao;

import Models.Sindico;
import java.sql.*;
import java.text.SimpleDateFormat;

public class SindicoDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
   public void adicionar(Sindico sindico){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String adiciona = "INSERT INTO \"Sindico\" (\"mandatoInicio\", \"mandatoFim\", \"cpfSindico\") VALUES (?, ?, ?)";
            p = con.prepareStatement(adiciona);
            
            Date mandatoInicioDate = Date.valueOf(sindico.getMandatoInicio());
            Date mandatoFimDate = Date.valueOf(sindico.getMandatoFim());
            String cpf = sindico.getCpf().replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
            p.setDate(1, mandatoInicioDate);
            p.setDate(2, mandatoFimDate);
            p.setLong(3, cpfLong);
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
            String sql = "SELECT \"cpfSindico\" FROM \"Sindico\" WHERE \"cpfSindico\" = ?";
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
            System.out.println("Erro na verificação do CPF em Sindico: " + e.getMessage());
        }

        return existe;
    }
    
    public String consultarDados(String cpf) {
        int apto = 0;
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        String dados = "";

        try {
            con = DriverManager.getConnection(url, usuario, senha);
                    String sql = "SELECT p.cpf, p.nome, p.endereco, p.telefone, p.email, s.\"mandatoInicio\", s.\"mandatoFim\"" +
                         "FROM \"Pessoa\" p JOIN \"Sindico\" s ON p.cpf = s.\"cpfSindico\" " +
                         "WHERE p.cpf = ?";
            p = con.prepareStatement(sql);
            p.setLong(1, Long.parseLong(cpf));
            rs = p.executeQuery();
            
            if (rs.next()) { 
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String mandatoInicio = sdf.format(rs.getDate("mandatoInicio"));
                String mandatoFim = sdf.format(rs.getDate("mandatoFim"));
                dados = "Nome: " + rs.getString("nome") + "\n"
                        + "CPF: " + rs.getString("cpf") + "\n"
                        + "Endereço: " + rs.getString("endereco") + "\n"
                        + "Telefone: " + rs.getString("telefone") + "\n"
                        + "Email: " + rs.getString("email") + "\n"
                        + "Inicio Mandato: " + mandatoInicio + "\n"
                        + "Fim Mandato: " + mandatoFim;
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
