package dao;

import Models.Setor;
import java.sql.*;

public class SetorDAO {

    private final Connection connection;

    public SetorDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean criarSetor(Setor setor) {
        String sql = "INSERT INTO Setor (nome, valeTransporte, valeRefeicao, valeAlimentacao, planoSaude, planoOdontologico, idFarmacia) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            
            pstmt.setString(1, setor.getNome());
            pstmt.setDouble(2, setor.getValeTransporte());
            pstmt.setDouble(3, setor.getValeRefeicao());
            pstmt.setDouble(4, setor.getValeAlimentacao());
            pstmt.setDouble(5, setor.getPlanoSaude());
            pstmt.setDouble(6, setor.getPlanoOdontologico());
            pstmt.setInt(7, setor.getIdFarmacia());

            pstmt.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("Falha na inserção do setor: " + e.getMessage());
            return false;
        }
    }
}