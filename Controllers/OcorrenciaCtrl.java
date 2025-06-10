package Controllers;

import Models.Ocorrencia;
import dao.OcorrenciaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class OcorrenciaCtrl {
        private OcorrenciaDAO dao;

    public OcorrenciaCtrl() {
        this.dao = new OcorrenciaDAO();
    }
    
    public void criarOcorrencia(String texto) {
        if (texto == null || texto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Texto obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Ocorrencia ocorrencia = new Ocorrencia();
            ocorrencia.setTextoOcorrencia(texto);
            dao.adicionar(ocorrencia, Sessao.getCpfUsuarioLogado());
            JOptionPane.showMessageDialog(null, "Ocorrencia adicionada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O texto deve ser válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Ocorrencia> listarOcorrencia() {
        return dao.listarOcorrencia();
    }
}
