package Controllers;

import Models.Setor;
import config.DatabaseConnection;
import dao.SetorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SetorCtrl {

    private SetorDAO dao;

    public SetorCtrl() {
    }

    public boolean cadastrarSetor(String nomeSetor, String vt, String vr, String va, String ps, String po) {
    try {
        double valeTransporte = Double.parseDouble(vt.replace(",", "."));
        double valeRefeicao = Double.parseDouble(vr.replace(",", "."));
        double valeAlimentacao = Double.parseDouble(va.replace(",", "."));
        double planoDeSaude = Double.parseDouble(ps.replace(",", "."));
        double planoOdontologico = Double.parseDouble(po.replace(",", "."));

        if (nomeSetor == null || nomeSetor.trim().isEmpty() ||
            valeTransporte < 0 || valeRefeicao < 0 || valeAlimentacao < 0 || planoDeSaude < 0) {
            return false;
        }

        Setor setor = new Setor(Sessao.getIdFarmaciaLogada(), nomeSetor, valeTransporte, valeRefeicao, valeAlimentacao, planoDeSaude, planoOdontologico);

        try (Connection conn = DatabaseConnection.getConnection()) {
            SetorDAO dao = new SetorDAO(conn);
            return dao.criarSetor(setor);
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao cadastrar setor: " + e.getMessage());
            return false;
        }

    } catch (NumberFormatException e) {
        System.err.println("Erro de conversão de número: " + e.getMessage());
        return false;
    } catch (Exception e) {
        System.err.println("Erro inesperado ao cadastrar setor: " + e.getMessage());
        return false;
    }
}
}
