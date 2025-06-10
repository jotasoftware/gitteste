package Controllers;

import Models.Visitante;
import dao.VisitanteDAO;
import dao.CondominoDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VisitanteCtrl {
    
    private VisitanteDAO dao;
    private CondominoDAO cd;

    public VisitanteCtrl() {
        this.dao = new VisitanteDAO();
        this.cd = new CondominoDAO();
    }
    
    public void solicitarAcesso(String cpf, String apto, LocalDate data) {
        if (apto == null || apto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Apartamento é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int aptoCondomino = Integer.parseInt(apto);
            Visitante visitante = new Visitante();
            visitante.setCpf(cpf);
            visitante.setData(data);
            visitante.setApto(aptoCondomino);
            dao.adicionar(visitante);
            JOptionPane.showMessageDialog(null, "Acesso adicionado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O número do apartamento deve ser valido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Visitante> listarVisita() {
        return dao.consultarVisitanteCpf(Sessao.getCpfUsuarioLogado());
    }
    
    public ArrayList<Visitante> todosVisitantes() {
        return dao.todosVisitantes();
    }
    
    public ArrayList<Visitante> apartamentoVisitantes() {
        return dao.consultarVisitanteApto();
    }
}
