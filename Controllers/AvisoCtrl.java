package Controllers;

import javax.swing.JOptionPane;
import Models.Aviso;
import dao.AvisoDAO;
import java.util.ArrayList;

public class AvisoCtrl {
    private AvisoDAO dao;

    public AvisoCtrl() {
        this.dao = new AvisoDAO();
    }
    
    public void criarAviso(String texto) {
        if (texto == null || texto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Texto obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Aviso aviso = new Aviso();
            aviso.setTextoAviso(texto);
            dao.adicionar(aviso);
            JOptionPane.showMessageDialog(null, "Aviso adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O texto deve ser válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluirAviso(int id) {
        dao.apagarAviso(id);
    }
    
    public ArrayList<Aviso> listarAvisos() {
        return dao.listarAvisos();
    }
}
