package dao;

import Models.Compra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompraDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/farmaciateste";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    
    
    public int gerarCompra(Compra compra){
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        int idGerado = -1;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "INSERT INTO compras (idFarmacia, idFuncionario) VALUES (?, ?) RETURNING idCompra";
            p = con.prepareStatement(sql);
            p.setInt(1, compra.getIdFarmacia());
            p.setInt(2, compra.getIdFuncionario());

            rs = p.executeQuery();
            if (rs.next()) {
                idGerado = rs.getInt("idCompra");
            }
            
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexões: " + ex.getMessage());
            }
        }
        
        return idGerado;
        
    }
}
