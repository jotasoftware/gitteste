package Projeto.controllers;

import Projeto.dao.TransportadoraDAO;
import Projeto.dto.TransportadoraDTO;
import Projeto.models.Estado;
import Projeto.models.Transportadora;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class TransportadoraController {

    private TransportadoraDAO transportadoraDAO;

    public TransportadoraController(Connection connection) {
        this.transportadoraDAO = new TransportadoraDAO(connection);
    }

    public TransportadoraDTO buscarDetalhesTransportadora(int id) {
        try {
            Transportadora transportadora = transportadoraDAO.buscarPorId(id);
            if (transportadora != null) {
                return converterParaDTO(transportadora);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null; 
    }

    public void criarNovaTransportadora(TransportadoraDTO dto) {
        Transportadora transportadora = converterParaModel(dto);
        try {
            transportadoraDAO.salvar(transportadora);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private TransportadoraDTO converterParaDTO(Transportadora transportadora) {
        TransportadoraDTO dto = new TransportadoraDTO();
        dto.setId(transportadora.getId());
        dto.setNome(transportadora.getNome());
        dto.setEstadosAtendidos(
            transportadora.getEstadosAtendidos().stream()
                .map(Estado::name)
                .collect(Collectors.toSet())
        );
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
