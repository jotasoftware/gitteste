package dao;

import Projeto.models.Estado;
import Projeto.models.Transportadora;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TransportadoraDAO {

    private Connection connection;

    public TransportadoraDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Transportadora> listarTodas() throws SQLException {
        List<Transportadora> transportadoras = new ArrayList<>();
        String sql = "SELECT * FROM transportadora ORDER BY nome";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Transportadora transportadora = new Transportadora();
                transportadora.setId(rs.getInt("idtransportadora"));
                transportadora.setNome(rs.getString("nome"));
                transportadoras.add(transportadora);
            }
        }
        return transportadoras;
    }

    public Transportadora buscarPorId(int id) throws SQLException {
        Transportadora transportadora = null;
        String sqlPrincipal = "SELECT * FROM transportadora WHERE idTransportadora = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlPrincipal)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    transportadora = new Transportadora();
                    transportadora.setId(rs.getInt("idtransportadora"));
                    transportadora.setNome(rs.getString("nome"));
                } else {
                    return null; 
                }
            }
        }

        String sqlCobertura = "SELECT estado FROM coberturatransportadora WHERE idTransportadora = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sqlCobertura)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                Set<Estado> estados = new HashSet<>();
                while (rs.next()) {
                    estados.add(Estado.valueOf(rs.getString("estado")));
                }
                transportadora.setEstadosAtendidos(estados);
            }
        }

        return transportadora;
    }

    public void salvar(Transportadora transportadora) throws SQLException {
        String sqlPrincipal = "INSERT INTO transportadora (nome) VALUES (?)";
        String sqlCobertura = "INSERT INTO coberturatransportadora (idtransportadora, estado) VALUES (?, ?::estado_enum)";

        connection.setAutoCommit(false); 

        try (PreparedStatement pstmtPrincipal = connection.prepareStatement(sqlPrincipal, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pstmtCobertura = connection.prepareStatement(sqlCobertura)) {

            pstmtPrincipal.setString(1, transportadora.getNome());
            pstmtPrincipal.executeUpdate();

            try (ResultSet generatedKeys = pstmtPrincipal.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    transportadora.setId(generatedKeys.getInt(1));
                } else {
                    //jOptionPane retornando retornando o erro
                }
            }

            for (Estado estado : transportadora.getEstadosAtendidos()) {
                pstmtCobertura.setInt(1, transportadora.getId());
                pstmtCobertura.setString(2, estado.name());
                pstmtCobertura.addBatch();
            }
            pstmtCobertura.executeBatch();

            connection.commit(); 

        } catch (SQLException e) {
            connection.rollback(); 
            throw new SQLException("Erro ao salvar transportadora.", e);
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
