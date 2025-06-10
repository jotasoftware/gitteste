package Controllers;

import javax.swing.JOptionPane;
import dao.TagDAO;
import Models.Tag;
import java.util.ArrayList;

public class TagCtrl {
    private final TagDAO dao;

    public TagCtrl() {
        this.dao = new TagDAO();
    }

    public void criarTag() {
        
        Tag tag = new Tag();
        tag.setCpfDono(Sessao.getCpfUsuarioLogado());

        int idGerado = dao.adicionar(tag);
        
        JOptionPane.showMessageDialog(null, "Tag solicitada com sucesso!\nEm 12 horas estará disponível na portaria.\nID da tag: " + idGerado, "\n", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public ArrayList<Tag> listarTagsCpf() {
        return dao.buscarTagsCpf(Sessao.getCpfUsuarioLogado());
    }
    
    public void excluirTag(int id) {
        dao.apagarTag(id);
    }
}
