package dao;

import Models.Estado;
import Models.Transportadora;
import config.DatabaseConnection;

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

    public List<Transportadora> listarTodasComCobertura() throws SQLException {
        List<Transportadora> transportadoras = new ArrayList<>();
        String sqlPrincipal = "SELECT idtransportadora, nome FROM transportadora ORDER BY nome";

        try (Connection connection = DatabaseConnection.getConnection()) {

            try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sqlPrincipal)) {

                while (rs.next()) {
                    Transportadora transportadora = new Transportadora();
                    transportadora.setId(rs.getInt("idtransportadora"));
                    transportadora.setNome(rs.getString("nome"));
                    transportadoras.add(transportadora);
                }
            }

            String sqlCobertura = "SELECT estado FROM coberturatransportadora WHERE idTransportadora = ?";
            try (PreparedStatement pstmtCobertura = connection.prepareStatement(sqlCobertura)) {

                for (Transportadora transportadora : transportadoras) {
                    pstmtCobertura.setInt(1, transportadora.getId());

                    Set<Estado> estados = new HashSet<>();
                    try (ResultSet rsCobertura = pstmtCobertura.executeQuery()) {
                        while (rsCobertura.next()) {
                            estados.add(Estado.valueOf(rsCobertura.getString("estado")));
                        }
                    }
                    transportadora.setEstadosAtendidos(estados);
                }
            }
        }
        return transportadoras;
    }


    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM transportadora WHERE idtransportadora = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao deletar, ID da transportadora não encontrado: " + id);
            }
        }
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

        try (PreparedStatement pstmtPrincipal = connection.prepareStatement(sqlPrincipal, Statement.RETURN_GENERATED_KEYS); PreparedStatement pstmtCobertura = connection.prepareStatement(sqlCobertura)) {

            pstmtPrincipal.setString(1, transportadora.getNome());
            pstmtPrincipal.executeUpdate();

            try (ResultSet generatedKeys = pstmtPrincipal.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    transportadora.setId(generatedKeys.getInt(1));
                } else {
                    //jOptionPane com erro
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
