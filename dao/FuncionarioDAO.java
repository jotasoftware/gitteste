package dao;

import Models.Funcionario;
import dto.FuncionarioListagemDTO;
import java.sql.*;
import java.util.ArrayList;

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
    
    public boolean editar(Funcionario funcionario) {
    String sql = "UPDATE Funcionario SET nomeCompleto = ?, idade = ?, genero = ?::genero_enum, idSetor = ?, salarioBase = ?, idFarmacia = ? WHERE idFuncionario = ?";
    
    try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
        pstmt.setString(1, funcionario.getNome());
        pstmt.setInt(2, funcionario.getIdade());
        pstmt.setString(3, funcionario.getGenero().name());
        pstmt.setInt(4, funcionario.getIdSetor());
        pstmt.setDouble(5, funcionario.getSalario());
        pstmt.setInt(6, funcionario.getIdFarmacia());
        pstmt.setInt(7, funcionario.getID());

        pstmt.execute();
        return true;

    } catch (SQLException e) {
        System.err.println("Falha na atualização do funcionário: " + e.getMessage());
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
    
    public ArrayList<FuncionarioListagemDTO> listarFuncionariosCnpj(int idFarmacia) {
        ArrayList<FuncionarioListagemDTO> funcionarios = new ArrayList<>();
        String sql = "SELECT F.idFuncionario, F.nomeCompleto, F.salarioBase, F.idade, " +
                     "       S.nome AS nomeSetor, S.valeRefeicao, S.valeAlimentacao, " +
                     "       S.planoSaude, S.valeTransporte, S.planoOdontologico " +
                     "FROM Funcionario F " +
                     "JOIN Setor S ON F.idSetor = S.idSetor " +
                     "WHERE F.idFarmacia = ? " +
                     "ORDER BY S.nome, F.nomeCompleto";

        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, idFarmacia);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    FuncionarioListagemDTO funcionario = new FuncionarioListagemDTO();
                    funcionario.setNomeFuncionario(rs.getString("nomeCompleto"));
                    funcionario.setIdade(rs.getInt("idade"));
                    funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                    funcionario.setNomeSetor(rs.getString("nomeSetor"));
                    funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                    funcionario.setValeTransporte(rs.getDouble("valeTransporte"));
                    funcionario.setValeAlimentacao(rs.getDouble("valeAlimentacao"));
                    funcionario.setValeRefeicao(rs.getDouble("valeRefeicao"));
                    funcionario.setPlanoSaude(rs.getDouble("planoSaude"));
                    funcionario.setPlanoOdontologico(rs.getDouble("planoOdontologico"));
                    funcionarios.add(funcionario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar funcionários da farmácia: " + e.getMessage());
        }
        return funcionarios;
    }
    
    public ArrayList<FuncionarioListagemDTO> listarResponsaveis(int idFarmacia, int tipo) {
        ArrayList<FuncionarioListagemDTO> funcionarios = new ArrayList<>();
        String sql = "SELECT F.idFuncionario, F.nomeCompleto, S.nome AS nomeSetor " +
             "FROM Funcionario F " +
             "JOIN Setor S ON F.idSetor = S.idSetor " +
             "WHERE F.idFarmacia = ? " +
             "AND ((? = 1 AND S.nome LIKE 'Almoxarifad%') OR (? = 2 AND S.nome LIKE 'Vend%'))";


        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setInt(1, idFarmacia);
            pstmt.setInt(2, tipo);
            pstmt.setInt(3, tipo);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    FuncionarioListagemDTO funcionario = new FuncionarioListagemDTO();
                    funcionario.setNomeFuncionario(rs.getString("nomeCompleto"));
                    funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                    funcionario.setNomeSetor(rs.getString("nomeSetor"));
                    funcionarios.add(funcionario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar funcionários da farmácia: " + e.getMessage());
        }
        return funcionarios;
    }
}