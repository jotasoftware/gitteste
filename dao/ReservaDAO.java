package dao;

import Models.Reserva;
import java.sql.*;
import java.util.ArrayList;

public class ReservaDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public void adicionar(Reserva reserva){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String adiciona = "INSERT INTO \"Reserva\" (\"localReserva\", \"dataReserva\", \"cpfReserva\") VALUES (?, ?, ?)";
            Date dataAcesso = Date.valueOf(reserva.getDataReserva());
            p = con.prepareStatement(adiciona);
            String cpf = reserva.getCpfReserva().replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
           
            p.setString(1, reserva.getLocalReserva());
            p.setDate(2, dataAcesso);
            p.setLong(3, cpfLong);

            p.execute();
            p.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }
        
    }

        public ArrayList<Reserva> reservaCpf(String cpfReserva) {
        ArrayList<Reserva> reservas = new ArrayList<>();
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
            String sql = "SELECT \"idReserva\", \"dataReserva\", \"localReserva\" FROM \"Reserva\" WHERE \"cpfReserva\" = ?";
            p = con.prepareStatement(sql);
            String cpf = cpfReserva.replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
            p.setLong(1, cpfLong);
            rs = p.executeQuery();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("idReserva"));
                reserva.setDataReserva(rs.getDate("dataReserva").toLocalDate());
                reserva.setLocalReserva(rs.getString("localReserva")); 
                reservas.add(reserva);
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
        return reservas;
    }
        
        
    public void apagarReserva(int reservaId) {
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "DELETE FROM \"Reserva\" WHERE \"idReserva\" = ?";
            p = con.prepareStatement(sql);
            p.setInt(1, reservaId);
            p.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Erro ao excluir reserva: " + e.getMessage());
        }
    }
}
