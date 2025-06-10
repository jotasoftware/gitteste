package Controllers;

import Models.Encomenda;
import java.time.LocalDate;
import dao.EncomendaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EncomendaCtrl {
    
    private EncomendaDAO dao;

    public EncomendaCtrl() {
        this.dao = new EncomendaDAO();
    }
    
    public void criarEncomenda(String apto, LocalDate data) {
        if (apto == null || apto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Apartamento é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int aptoCondomino = Integer.parseInt(apto);
            Encomenda visitante = new Encomenda();
            visitante.setCpfFuncionario(Sessao.getCpfUsuarioLogado());
            visitante.setDataEncomenda(data);
            visitante.setAptoEncomenda(aptoCondomino);
            dao.adicionar(visitante);
            JOptionPane.showMessageDialog(null, "Encomenda adicionada", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O número do apartamento deve ser valido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Encomenda> listarEncomendasPorteiro() {
        return dao.encomendaPorteiro(Sessao.getCpfUsuarioLogado());
    }
}
