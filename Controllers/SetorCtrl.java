package Controllers;

import Models.Setor;
import dao.SetorDAO;
import javax.swing.JOptionPane;

public class SetorCtrl {

    private SetorDAO dao;

    public SetorCtrl() {
        this.dao = new SetorDAO();
    }

    public boolean cadastrarSetor(String nomeSetor, String vt, String vr, String va, String ps) {
        try {
            double valeTransporte = Double.parseDouble(vt);
            double valeRefeicao = Double.parseDouble(vr);
            double valeAlimentacao = Double.parseDouble(va);
            double planoDeSaude = Double.parseDouble(ps);

            Setor setor = new Setor(Sessao.getIdFarmaciaLogada(), nomeSetor, valeTransporte, valeRefeicao, valeAlimentacao, planoDeSaude);
            return dao.criarSetor(setor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Todos os valores devem ser números válidos (use ponto para decimais).", "Erro de conversão", JOptionPane.ERROR_MESSAGE);
            return false;
    }
    }

}
