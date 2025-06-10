package Controllers;

import Models.Reserva;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import dao.ReservaDAO;
import java.util.ArrayList;

public class ReservaCtrl {
    
    private ReservaDAO dao;

    public ReservaCtrl() {
        this.dao = new ReservaDAO();
    }
    
    
    public void registrarReserva(String local,  LocalDate data) {
        if (local == null || local.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Reserva reserva = new Reserva();
            reserva.setCpfReserva(Sessao.getCpfUsuarioLogado());
            reserva.setDataReserva(data);
            reserva.setLocalReserva(local);
            dao.adicionar(reserva);
            JOptionPane.showMessageDialog(null, "Reserva adicionada", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Reserva não adicionada", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public ArrayList<Reserva> listarReservas() {
        return dao.reservaCpf(Sessao.getCpfUsuarioLogado());
    }
    
    public void cancelarReserva(int id) {
        dao.apagarReserva(id);
    }
}
