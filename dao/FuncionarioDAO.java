package dao;

import Models.Funcionario;
import java.sql.*;

public class FuncionarioDAO {

    private final Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean adicionar(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionario (nomeCompleto, idade, genero, idSetor, salarioBase, idFarmacia) VALUES (?, ?, ?::genero_enum, ?, ?, ?)";
        
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNome());
            pstmt.setInt(2, funcionario.getIdade()); 
            pstmt.setString(3, funcionario.getGenero().name());
            pstmt.setInt(4, funcionario.getIdSetor());
            pstmt.setDouble(5, funcionario.getSalario());
            pstmt.setInt(6, funcionario.getIdFarmacia());
            
            pstmt.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("Falha na inserção do funcionário: " + e.getMessage());
            return false;
        }
    }

    public boolean remover(int idFuncionario) {
        String sql = "DELETE FROM Funcionario WHERE idFuncionario = ?";
        
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, idFuncionario);
            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0; 

        } catch (SQLException e) {
            System.err.println("Falha na exclusão do funcionário: " + e.getMessage());
            return false;
        }
    }

}