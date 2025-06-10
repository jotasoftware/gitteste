package dao;

import Models.Tag;
import java.sql.*;
import java.util.ArrayList;

public class TagDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public int adicionar(Tag tag){
        Connection con = null;
        PreparedStatement p = null;
        int idGerado = -1;
        ResultSet rs = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String adiciona = "INSERT INTO \"Tag\" (\"cpfCodomino\") VALUES (?) RETURNING \"idTag\"";
            System.out.println("Inserindo dados.......");
            p = con.prepareStatement(adiciona);
            String cpf = tag.getCpfDono().replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
            p.setLong(1, cpfLong);

            rs = p.executeQuery();
            if (rs.next()) {
                idGerado = rs.getInt("idTag");
            }
            
            
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return idGerado;
        
    }
    
    public ArrayList<Tag> buscarTagsCpf(String cpfUsuario) {
        ArrayList<Tag> tags = new ArrayList<>();
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
            String sql = "SELECT \"idTag\" FROM \"Tag\" WHERE \"cpfCodomino\" = ?";
            p = con.prepareStatement(sql);
            p.setLong(1, Long.parseLong(cpfUsuario));

            rs = p.executeQuery();
            while (rs.next()) {
                Tag tag = new Tag();
                tag.setIdTag(rs.getInt("idTag"));
                tags.add(tag);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar tags: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return tags;
    }
    
    public void apagarTag(int tagId) {
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "DELETE FROM \"Tag\" WHERE \"idTag\" = ?";
            p = con.prepareStatement(sql);
            p.setInt(1, tagId);
            p.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Erro ao excluir tag: " + e.getMessage());
        }
    }

}
