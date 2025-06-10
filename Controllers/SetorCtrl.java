package Controllers;

import Models.Setor;

public class SetorCtrl {

    private SetorDAO dao;

    public SetorCtrl() {
        this.dao = new SetorDAO();
    }

    public boolean cadastrarSetor(String nomeSetor, double valeTransporte, double valeRefeicao, double valeAlimentacao, double planoSaude) {
        try {
            if (nomeSetor == null || nomeSetor.trim().isEmpty()) {
                return false;
            }

            Setor setor = new Setor(Sessao.getCnpjFarmaciaLogada(), nomeSetor, valeTransporte, valeRefeicao, valeAlimentacao, planoSaude);
            return dao.criarSetor(setor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
