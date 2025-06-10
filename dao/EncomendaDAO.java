package dao;

import Models.Encomenda;
import java.sql.*;
import java.util.ArrayList;

public class EncomendaDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public void adicionar(Encomenda encomenda){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String adiciona = "INSERT INTO \"Encomenda\" (\"dataEncomenda\", \"aptoEncomenda\", \"cpfFuncionario\") VALUES (?, ?, ?)";
            Date dataAcesso = Date.valueOf(encomenda.getDataEncomenda());
            p = con.prepareStatement(adiciona);
            String cpf = encomenda.getCpfFuncionario().replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
            p.setDate(1, dataAcesso);
            p.setInt(2, encomenda.getAptoEncomenda());
            p.setLong(3, cpfLong);

            p.execute();
            p.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }
        
    }
    
    public ArrayList<Encomenda> encomendaPorteiro(String cpfFuncionario) {
        ArrayList<Encomenda> encomendas = new ArrayList<>();
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
            String sql = "SELECT \"idEncomenda\", \"dataEncomenda\", \"aptoEncomenda\" FROM \"Encomenda\" WHERE \"cpfFuncionario\" = ?";
            p = con.prepareStatement(sql);
            String cpf = cpfFuncionario.replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
            p.setLong(1, cpfLong);
            rs = p.executeQuery();
            while (rs.next()) {
                Encomenda encomenda = new Encomenda();
                encomenda.setIdEncomenda(rs.getInt("idEncomenda"));
                encomenda.setDataEncomenda(rs.getDate("dataEncomenda").toLocalDate());
                encomenda.setAptoEncomenda(rs.getInt("aptoEncomenda")); 
                encomendas.add(encomenda);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar encomendas: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return encomendas;
    }

        public ArrayList<Encomenda> encomendasCpf(int apto) {
        ArrayList<Encomenda> encomendas = new ArrayList<>();
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
            String sql = "SELECT \"idEncomenda\", \"dataEncomenda\", \"cpfFuncionario\" FROM \"Encomenda\" WHERE \"aptoEncomenda\" = ?";
            p = con.prepareStatement(sql);
            p.setInt(1, apto);
            rs = p.executeQuery();
            while (rs.next()) {
                Encomenda encomenda = new Encomenda();
                encomenda.setIdEncomenda(rs.getInt("idEncomenda"));
                encomenda.setDataEncomenda(rs.getDate("dataEncomenda").toLocalDate());
                encomenda.setCpfFuncionario(rs.getString("cpfFuncionario")); 
                encomendas.add(encomenda);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar encomendas: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return encomendas;
    }
}
