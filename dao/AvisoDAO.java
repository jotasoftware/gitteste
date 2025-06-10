package dao;

import Models.Aviso;
import java.sql.*;
import java.util.ArrayList;

public class AvisoDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public void adicionar(Aviso aviso){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String adiciona = "INSERT INTO \"Aviso\" (\"textoAviso\") VALUES (?)";
            p = con.prepareStatement(adiciona);
            p.setString(1, aviso.getTextoAviso());

            p.execute();
            p.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }
        
    }
    

    public void apagarAviso(int tagId) {
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "DELETE FROM \"Aviso\" WHERE \"idAviso\" = ?";
            p = con.prepareStatement(sql);
            p.setInt(1, tagId);
            p.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Erro ao excluir tag: " + e.getMessage());
        }
    }
    
    public ArrayList<Aviso> listarAvisos() {
        ArrayList<Aviso> avisos = new ArrayList<>();
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
            String sql = "SELECT \"idAviso\", \"textoAviso\" FROM \"Aviso\"";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();
            while (rs.next()) {
                Aviso aviso = new Aviso();
                aviso.setIdAviso(rs.getInt("idAviso"));
                aviso.setTextoAviso(rs.getString("textoAviso")); 
                avisos.add(aviso);
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
        return avisos;
    }
}
