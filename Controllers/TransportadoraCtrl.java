package Controllers;

import Models.Estado;
import Models.Transportadora;
import config.DatabaseConnection;
import dao.TransportadoraDAO;
import dto.TransportadoraDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TransportadoraCtrl {

    public void criarNovaTransportadora(TransportadoraDTO dto) throws SQLException {
        Transportadora transportadora = converterParaModel(dto);
        try (Connection conn = DatabaseConnection.getConnection()) {
            TransportadoraDAO transportadoraDAO = new TransportadoraDAO(conn);
            transportadoraDAO.salvar(transportadora);
        }
    }

    public List<TransportadoraDTO> listarTodas() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            TransportadoraDAO dao = new TransportadoraDAO(conn);
            List<Transportadora> transportadoras = dao.listarTodasComCobertura();
            return transportadoras.stream()
                    .map(this::converterParaDTO)
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void excluirTransportadora(int id) throws SQLException {
        try(Connection conn = DatabaseConnection.getConnection()) {
            TransportadoraDAO dao = new TransportadoraDAO(conn);
            dao.deletar(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

    }

    private TransportadoraDTO converterParaDTO(Transportadora transportadora) {
        TransportadoraDTO dto = new TransportadoraDTO();
        dto.setId(transportadora.getId());
        dto.setNome(transportadora.getNome());
        if (transportadora.getEstadosAtendidos() != null) {
            dto.setEstadosAtendidos(
                    transportadora.getEstadosAtendidos().stream()
                            .map(Estado::name)
                            .collect(Collectors.toSet())
            );
        }
        return dto;
    }

    private Transportadora converterParaModel(TransportadoraDTO dto) {
        Transportadora transportadora = new Transportadora();
        transportadora.setId(dto.getId());
        transportadora.setNome(dto.getNome());
        if (dto.getEstadosAtendidos() != null) {
            transportadora.setEstadosAtendidos(
                    dto.getEstadosAtendidos().stream()
                            .map(Estado::valueOf)
                            .collect(Collectors.toSet())
            );
        }
        return transportadora;
    }
}
