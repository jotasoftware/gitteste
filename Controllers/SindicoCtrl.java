
package Controllers;
import Models.Funcionario;
import dao.SindicoDAO;
import Models.Sindico;
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import javax.swing.JOptionPane;

public class SindicoCtrl {
    private SindicoDAO dao;

    public SindicoCtrl() {
        this.dao = new SindicoDAO();
    }

    public boolean verificarSindico(String cpf) {
        return dao.verificarCPF(cpf);
    }
    
    public boolean criarFuncionario(String cpf, String cargo, String turno){
        PessoaDAO pd = new PessoaDAO();
        
        if(!pd.verificarCPF(cpf)){
            JOptionPane.showMessageDialog(null, "CPF não encontrado.", "Erro", 0);
            return false;
        }else{
            FuncionarioDAO fd = new FuncionarioDAO();
            if(fd.verificarCPF(cpf)){
                JOptionPane.showMessageDialog(null, "Funcionário já adicionado.", "Erro", 0);
                return false;
            }else{
                Funcionario f = new Funcionario();
                
                f.setCpf(cpf);
                f.setCargoFuncionario(cargo);
                f.setTurnoFuncionario(turno);
                fd.adicionar(f);
                JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return true;
    }
}
