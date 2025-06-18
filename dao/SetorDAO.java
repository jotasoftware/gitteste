package dao;

import Models.Setor;
import dto.SetorListagemDTO;
import java.sql.*;
import java.util.ArrayList;

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
    
    public ArrayList<SetorListagemDTO> listarSetoresCnpj(int idFarmacia) {
        ArrayList<SetorListagemDTO> setores = new ArrayList<>();
        String sql = "SELECT DISTINCT S.idSetor, S.nome, " +
                     "    COUNT(F.idFuncionario) OVER (PARTITION BY S.idSetor) AS totalFuncionariosSetor, " +
                     "    S.valeRefeicao, S.valeAlimentacao, S.planoSaude, S.valeTransporte, S.planoOdontologico " +
                     "FROM Setor S " +
                     "LEFT JOIN Funcionario F ON F.idSetor = S.idSetor " +
                     "WHERE S.idFarmacia = ? " +
                     "ORDER BY S.nome";
        
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, idFarmacia);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    SetorListagemDTO setor = new SetorListagemDTO();
                    setor.setId(rs.getInt("idSetor"));
                    setor.setNome(rs.getString("nome"));
                    setor.setValeTransporte(rs.getDouble("valeTransporte"));
                    setor.setValeAlimentacao(rs.getDouble("valeAlimentacao"));
                    setor.setValeRefeicao(rs.getDouble("valeRefeicao"));
                    setor.setPlanoSaude(rs.getDouble("planoSaude"));
                    setor.setPlanoOdontologico(rs.getDouble("planoOdontologico"));
                    setor.setQtdFuncionarios(rs.getInt("totalFuncionariosSetor"));
                    setores.add(setor);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar setores da farmácia: " + e.getMessage());
        }
        return setores;
    }
}