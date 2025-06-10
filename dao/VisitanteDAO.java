package dao;

import Models.Visitante;
import Controllers.Sessao;
import java.sql.*;
import java.util.ArrayList;

public class VisitanteDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public void adicionar(Visitante visitante){
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
            
            String consulta = "SELECT COUNT(*) FROM \"Visitante\" WHERE cpf = ?";
            p = con.prepareStatement(consulta);
            String cpf = visitante.getCpf().replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
            p.setLong(1, cpfLong);
            rs = p.executeQuery();
        
            boolean existe = false;
            if (rs.next()) {
                existe = rs.getInt(1) > 0;
            }

            p.close();
            if (existe) {
                String atualiza = "UPDATE \"Visitante\" SET data = ?, apto = ? WHERE cpf = ?";
                p = con.prepareStatement(atualiza);
                Date dataAcesso = Date.valueOf(visitante.getData());
                p.setDate(1, dataAcesso);
                p.setInt(2, visitante.getApto());
                p.setLong(3, cpfLong);
            } else {
                String adiciona = "INSERT INTO \"Visitante\" (cpf, data, apto) VALUES (?, ?, ?)";
                p = con.prepareStatement(adiciona);
                Date dataAcesso = Date.valueOf(visitante.getData());
                p.setLong(1, cpfLong);
                p.setDate(2, dataAcesso);
                p.setInt(3, visitante.getApto());
            }
            p.execute();
            p.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }   
    }
    
    
    public ArrayList<Visitante> consultarVisitanteCpf(String cpf) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<Visitante> visitantes = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT v.data, v.apto, p.nome, p.endereco, p.telefone, p.email "
                    + "FROM \"Visitante\" v "
                    + "JOIN \"Pessoa\" p ON v.cpf = p.cpf "
                    + "WHERE v.cpf = ?";
            p = con.prepareStatement(sql);

            String cpfNumerico = cpf.replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpfNumerico);
            p.setLong(1, cpfLong);

            rs = p.executeQuery();

            while(rs.next()) {
                Visitante visitante = new Visitante();
                visitante.setData(rs.getDate("data").toLocalDate());
                visitante.setApto(rs.getInt("apto"));
                visitante.setNome(rs.getString("nome"));
                visitante.setEndereco(rs.getString("endereco"));
                visitante.setTelefone(rs.getString("telefone"));
                visitante.setEmail(rs.getString("email"));
                visitantes.add(visitante);
            }

        }catch(SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            }catch(SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return visitantes;
    }

    
    

    public ArrayList<Visitante> todosVisitantes() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<Visitante> visitantes = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT v.data, v.apto, p.nome, p.endereco, p.telefone, p.email, v.cpf "
                    + "FROM \"Visitante\" v "
                    + "JOIN \"Pessoa\" p ON v.cpf = p.cpf ";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            while(rs.next()) {
                Visitante visitante = new Visitante();
                visitante.setData(rs.getDate("data").toLocalDate());
                visitante.setApto(rs.getInt("apto"));
                visitante.setNome(rs.getString("nome"));
                visitante.setEndereco(rs.getString("endereco"));
                visitante.setTelefone(rs.getString("telefone"));
                visitante.setEmail(rs.getString("email"));
                visitante.setCpf(String.valueOf(rs.getLong("cpf"))); 
                visitantes.add(visitante);
            }

        }catch(SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            }catch(SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return visitantes;
    }


    public ArrayList<Visitante> consultarVisitanteApto() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        ArrayList<Visitante> visitantes = new ArrayList<>();
        int apartamento = -1; 

        try{
            con = DriverManager.getConnection(url, usuario, senha);
            String sqlApto = "SELECT \"aptoCondomino\"  FROM \"Condomino\" WHERE \"cpfCondomino\" = ?";
            p = con.prepareStatement(sqlApto);
            String cpfNumerico = Sessao.getCpfUsuarioLogado().replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpfNumerico);
            p.setLong(1, cpfLong);
            rs = p.executeQuery();


            if (rs.next()) {
                apartamento = rs.getInt("aptoCondomino");
            } else {
                return visitantes;
            }
            rs.close();
            p.close();
            String sqlVisitantes = "SELECT v.data, v.apto, p.nome, p.endereco, p.telefone, p.email, p.cpf "
                                    + "FROM \"Visitante\" v "
                                    + "JOIN \"Pessoa\" p ON v.cpf = p.cpf "
                                    + "WHERE v.apto = ?";

            p = con.prepareStatement(sqlVisitantes);
            p.setInt(1, apartamento);
            rs = p.executeQuery();

            while (rs.next()) {
                Visitante visitante = new Visitante();
                visitante.setCpf(rs.getString("cpf"));
                visitante.setData(rs.getDate("data").toLocalDate());
                visitante.setApto(rs.getInt("apto"));
                visitante.setNome(rs.getString("nome"));
                visitante.setEndereco(rs.getString("endereco"));
                visitante.setTelefone(rs.getString("telefone"));
                visitante.setEmail(rs.getString("email"));
                visitantes.add(visitante);
            }

        }catch(SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            try{
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return visitantes;
    }
    
    
}

