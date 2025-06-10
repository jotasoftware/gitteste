package dao;

import Models.Produto;
import java.sql.*;

public class ProdutoDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public void criarProduto(Produto produto){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "INSERT INTO \"Produto\" (\"nomeProduto\", \"valorVenda\", \"valorCusto\", \"idFarmacia\", \"quantidade\") VALUES (?, ?, ?, ?, ?)";
            p = con.prepareStatement(sql);
            p.setString(1, produto.getNomeProduto());
            p.setDouble(2, produto.getValorVenda());
            p.setDouble(3, produto.getValorCusto());
            p.setString(4, produto.getidFarmacia());
            p.setInt(5, produto.getQtdProduto());

            p.execute();
            p.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }
        
    }
}
