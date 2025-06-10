package Controllers;

import dao.*;
import Models.Condomino;
import Models.Encomenda;
import Models.Visitante;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CondominoCtrl {
    private final CondominoDAO dao;
    private final VisitanteDAO vd;
    private final EncomendaDAO ed;

    public CondominoCtrl() {
        this.dao = new CondominoDAO();
        this.vd = new VisitanteDAO();
        this.ed = new EncomendaDAO();
    }

    public void cadastrar(String cpf, String apto) {
        if (cpf == null || cpf.isEmpty() || apto == null || apto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Apartamento é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int aptoCondomino = Integer.parseInt(apto);
            Condomino condomino = new Condomino();
            condomino.setCpf(cpf);
            condomino.setAptoCondomino(aptoCondomino);
            dao.adicionar(condomino);
            JOptionPane.showMessageDialog(null, "Condomino cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O número do apartamento deve ser valido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean verificarCondomino(String cpf) {
        return dao.verificarCPF(cpf);
    }
    
    public void liberarAcesso(String cpf, String cpfVisita, LocalDate data) {

        try {
            Visitante visitante = new Visitante();
            visitante.setCpf(cpfVisita);
            visitante.setData(data);
            visitante.setApto(dao.verificarApto(cpf));

            vd.adicionar(visitante);
            JOptionPane.showMessageDialog(null, "Visitante adicionado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O número do apartamento deve ser valido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public ArrayList<Encomenda> listarEncomendasApto() {
        return ed.encomendasCpf(dao.verificarApto(Sessao.getCpfUsuarioLogado()));
    }
    
}
