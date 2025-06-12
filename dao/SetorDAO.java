package dao;

import Models.Setor;
import java.sql.*;

public class SetorDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/farmaciateste";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public boolean criarSetor(Setor setor){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "INSERT INTO Setor (nome, valeTransporte, valeRefeicao, valeAlimentacao, planoSaude, idFarmacia) VALUES (?, ?, ?, ?, ?, ?)";
            p = con.prepareStatement(sql);
            p.setString(1, setor.getNome());
            p.setDouble(2, setor.getValeTransporte());
            p.setDouble(3, setor.getValeRefeicao());
            p.setDouble(4, setor.getValeAlimentacao());
            p.setDouble(5, setor.getPlanoSaude());
            p.setInt(6, setor.getIdFarmacia());

            p.execute();
            p.close();
            con.close();
            return true;
            
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
            return false;
        }
        
    }
}