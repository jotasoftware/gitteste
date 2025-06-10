package Controllers;

import dao.*;
import Models.Pessoa;
import javax.swing.JOptionPane;
public class PessoaCtrl {
    private final PessoaDAO dao;
    private final CondominoDAO cd;
    private final SindicoDAO sd;
    private final FuncionarioDAO fd;

    public PessoaCtrl() {
        this.dao = new PessoaDAO();
        this.cd = new CondominoDAO();
        this.sd = new SindicoDAO();
        this.fd = new FuncionarioDAO();
    }

    public void cadastrar(String nome, String cpf, String telefone, String email, String endereco, boolean type) {
        if(nome == null || nome.isEmpty() || cpf == null || cpf.isEmpty() || telefone == null || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setTelefone(telefone);
        pessoa.setEmail(email);
        pessoa.setEndereco(endereco);
        pessoa.setCondomino(type);

        dao.adicionar(pessoa);
    }
    
    public boolean verificarPessoa(String cpf) {
        return dao.verificarCPF(cpf);
    }
    
    public String verificarDados() {
        System.out.println(Sessao.getTipoUsuario());
        if(Sessao.getTipoUsuario()==1) return sd.consultarDados(Sessao.getCpfUsuarioLogado());
        if(Sessao.getTipoUsuario()==2) return fd.consultarDados(Sessao.getCpfUsuarioLogado());
        if(Sessao.getTipoUsuario()==3) return cd.consultarDados(Sessao.getCpfUsuarioLogado());
        return dao.consultarDados(Sessao.getCpfUsuarioLogado());
    }
    
    public Pessoa buscaDados() {
        return dao.buscarDados(Sessao.getCpfUsuarioLogado());
    }
    
    public void editarCadastro(String nome, String telefone, String email, String endereco){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setTelefone(telefone);
        pessoa.setEmail(email);
        pessoa.setEndereco(endereco);
        
        dao.editarPessoa(Sessao.getCpfUsuarioLogado(), pessoa);
        JOptionPane.showMessageDialog(null, "Cadastro editado com sucesso!", "\n", JOptionPane.INFORMATION_MESSAGE);
    }
}




