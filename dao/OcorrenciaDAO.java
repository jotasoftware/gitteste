package dao;

import Models.Ocorrencia;
import java.sql.*;
import java.util.ArrayList;

public class OcorrenciaDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public void adicionar(Ocorrencia ocorrencia, String cpfCondomino){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String adiciona = "INSERT INTO \"Ocorrencia\" (\"textoOcorrencia\", \"cpfOcorrencia\") VALUES (?, ?)";
            p = con.prepareStatement(adiciona);
            p.setString(1, ocorrencia.getTextoOcorrencia());
            String cpf = cpfCondomino.replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
            p.setLong(2, cpfLong);

            p.execute();
            p.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }
        
    }
    
    public ArrayList<Ocorrencia> listarOcorrencia() {
        ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT \"idOcorrencia\", \"textoOcorrencia\", \"cpfOcorrencia\" FROM \"Ocorrencia\"";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();
            while (rs.next()) {
                Ocorrencia ocorrencia = new Ocorrencia();
                ocorrencia.setIdOcorrencia(rs.getInt("idOcorrencia"));
                ocorrencia.setTextoOcorrencia(rs.getString("textoOcorrencia"));
                ocorrencia.setCpfocorrencia(rs.getString("cpfOcorrencia"));
                ocorrencias.add(ocorrencia);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar avisos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return ocorrencias;
    }
}
