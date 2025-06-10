package dao;

import Models.Pessoa;
import java.sql.*;

public class PessoaDAO {
    static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/smartcondo";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "niver2500";
    
    public void adicionar(Pessoa pessoa){
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("Falha na criação");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String adiciona = "INSERT INTO \"Pessoa\" (nome, cpf, telefone, email, endereco, condomino) VALUES (?, ?, ?, ?, ?, ?)";
            p = con.prepareStatement(adiciona);
            String cpf = pessoa.getCpf().replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpf);
            p.setString(1, pessoa.getNome());
            p.setLong(2, cpfLong);
            p.setString(3, pessoa.getTelefone());
            p.setString(4, pessoa.getEmail());
            p.setString(5, pessoa.getEndereco());
            p.setBoolean(6, pessoa.isCondomino());
            p.execute();
            p.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        }
        
    }
    
    public boolean verificarCPF(String cpf){
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        boolean existe = false;

        try{
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT cpf FROM \"Pessoa\" WHERE cpf = ?";
            p = con.prepareStatement(sql);
            p.setLong(1, Long.parseLong(cpf));
            rs = p.executeQuery();
            if (rs.next()) { 
                existe = true;
            }
            rs.close();
            p.close();
            con.close();
        }catch (Exception e){
            System.out.println("Erro na verificação do CPF em Pessoa: " + e.getMessage());
        }

        return existe;
    }
    
    public Pessoa buscarDados(String cpf){
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        Pessoa pessoa = null;

        try{
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT nome, endereco, telefone, email FROM \"Pessoa\" WHERE cpf = ?";
            p = con.prepareStatement(sql);

            String cpfNumerico = cpf.replaceAll("[^0-9]", "");
            long cpfLong = Long.parseLong(cpfNumerico);
            p.setLong(1, cpfLong);

            rs = p.executeQuery();

            if(rs.next()){
                pessoa = new Pessoa();
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setEmail(rs.getString("email"));
            }

        }catch(SQLException e){
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            try {
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return pessoa;
    }
    
    public void editarPessoa(String cpf, Pessoa pessoa) {
        Connection con = null;
        PreparedStatement p = null;

        try {
            con = DriverManager.getConnection(url, usuario, senha);
            String sql = "UPDATE \"Pessoa\" SET nome = ?, telefone = ?, email = ?, endereco = ? WHERE cpf = ?";
            p = con.prepareStatement(sql);
            
            p.setString(1, pessoa.getNome());
            p.setString(2, pessoa.getTelefone());
            p.setString(3, pessoa.getEmail());
            p.setString(4, pessoa.getEndereco());

            String cpfNumerico = cpf.replaceAll("[^0-9]", ""); 
            long cpfLong = Long.parseLong(cpfNumerico);
            p.setLong(5, cpfLong);
            p.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao atualizar os dados: " + e.getMessage());
        }finally{
            try {
                if (p != null) p.close();
                if (con != null) con.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public String consultarDados(String cpf) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        String dados = "";
     

        try {
            con = DriverManager.getConnection(url, usuario, senha);
                    String sql = "SELECT p.cpf, p.nome, p.endereco, p.telefone, p.email " +
                         "FROM \"Pessoa\" p " +
                         "WHERE p.cpf = ?";
            p = con.prepareStatement(sql);
            p.setLong(1, Long.parseLong(cpf));
            rs = p.executeQuery();
            
            if (rs.next()) { 
                dados = "Nome: " + rs.getString("nome") + "\n"
                        + "CPF: " + rs.getString("cpf") + "\n"
                        + "Endereço: " + rs.getString("endereco") + "\n"
                        + "Telefone: " + rs.getString("telefone") + "\n"
                        + "Email: " + rs.getString("email") + "\n";
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
