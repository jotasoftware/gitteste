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

            if (nomeSetor == null || nomeSetor.isEmpty() ||
                valeTransporte < 0 || valeRefeicao < 0 || valeAlimentacao < 0 || planoDeSaude < 0) {

                return false;
            }

            Setor setor = new Setor(Sessao.getIdFarmaciaLogada(), nomeSetor, valeTransporte, valeRefeicao, valeAlimentacao, planoDeSaude);
            boolean sucesso = dao.criarSetor(setor);
            return sucesso;

        } catch (NumberFormatException e) {
            return false;
        }
    }


}
