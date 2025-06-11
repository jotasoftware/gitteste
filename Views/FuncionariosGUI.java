/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;
import Controllers.FarmaciaCtrl;
import Controllers.FuncionarioCtrl;
import Controllers.Sessao;
import dto.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaopedro
 */
public class FuncionariosGUI extends javax.swing.JFrame {
    private ArrayList<SetorListagemDTO> setores;
    private ArrayList<FuncionarioListagemDTO> funcionarios;
    
    public FuncionariosGUI() {
        initComponents();
        populaTabelas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSetores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAddSetor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbFuncionarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnAddAtualizar = new javax.swing.JButton();
        btnAddFuncionario = new javax.swing.JButton();
        btnAddSetor2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MnOpcoes = new javax.swing.JMenu();
        itMnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbSetores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Setor", "Funcionarios", "Vale Transporte", "Vale Refeição", "Vale Alimentação", "Plano de Saude"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbSetores);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("Funcionários");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setText("Setores");

        btnAddSetor.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddSetor.setText("Adicionar Setor");
        btnAddSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSetorActionPerformed(evt);
            }
        });

        tbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Salario", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbFuncionarios);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Funcionários");

        btnAddAtualizar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddAtualizar.setText("Atualizar");
        btnAddAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAtualizarActionPerformed(evt);
            }
        });

        btnAddFuncionario.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddFuncionario.setText("Adicionar Funcionario");
        btnAddFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFuncionarioActionPerformed(evt);
            }
        });

        btnAddSetor2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddSetor2.setText("Voltar");
        btnAddSetor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSetor2ActionPerformed(evt);
            }
        });

        jMenu2.setText("Inicio");
        jMenuBar1.add(jMenu2);

        MnOpcoes.setText("Opcões");

        itMnSair.setText("Sair");
        itMnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itMnSairActionPerformed(evt);
            }
        });
        MnOpcoes.add(itMnSair);

        jMenuBar1.add(MnOpcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddSetor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddAtualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddFuncionario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 630, Short.MAX_VALUE)
                        .addComponent(btnAddSetor2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAtualizar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnAddSetor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnAddFuncionario))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddSetor2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSetorActionPerformed
        fechaAtual();
        abreAdicionarSetor();
    }//GEN-LAST:event_btnAddSetorActionPerformed

    private void itMnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnSairActionPerformed
        fechaAtual();
        sair();
    }//GEN-LAST:event_itMnSairActionPerformed

    private void btnAddAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAtualizarActionPerformed
        populaTabelas();
    }//GEN-LAST:event_btnAddAtualizarActionPerformed

    private void btnAddFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFuncionarioActionPerformed
        fechaAtual();
        abreAdicionarFuncionario();
    }//GEN-LAST:event_btnAddFuncionarioActionPerformed

    private void btnAddSetor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSetor2ActionPerformed
        
    }//GEN-LAST:event_btnAddSetor2ActionPerformed

    private void tbFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFuncionariosMouseClicked
        int linhaSelecionada = tbFuncionarios.getSelectedRow();
        FuncionarioCtrl funcionarioCtrl = new FuncionarioCtrl();

        if (linhaSelecionada != -1) {
            FuncionarioListagemDTO funcionario = funcionarios.get(linhaSelecionada);

            String mensagem = String.format(
                "ID: %d\n" +
                "Nome: %s\n" +
                "Setor: %s\n" +
                "Vale Transporte: %s\n" +
                "Vale Refeição: %s\n" +
                "Vale Alimentação: %s\n" +
                "Plano de Saúde: %s\n" +
                "Salário Bruto: R$ %.2f\n" +
                "Imposto: R$ %.2f\n" +
                "Salário Líquido: R$ %.2f\n" +
                "Deseja excluir este funcionário?\n",
                funcionario.getIdFuncionario(),
                funcionario.getNomeFuncionario(),
                funcionario.getNomeSetor(),
                funcionario.getValeTransporte(),
                funcionario.getValeRefeicao(),
                funcionario.getValeAlimentacao(),
                funcionario.getPlanoSaude(),
                funcionario.getSalarioBase(),
                funcionarioCtrl.getImposto(funcionario.getSalarioBase()),
                funcionarioCtrl.getSalarioLiquido(funcionario.getSalarioBase())
            );

            int resposta = JOptionPane.showConfirmDialog(
                this,
                mensagem,
                "Confirmação de Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {
                if(funcionarioCtrl.apagar(funcionario.getIdFuncionario())){
                    JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!");
                }
            }

        }
    }//GEN-LAST:event_tbFuncionariosMouseClicked

    private void populaTabelas() {
        populaTabelaSetores();
        populaTabelaFuncionarios();
    }

    private void populaTabelaSetores() {
        FarmaciaCtrl farmaciaCtrl = new FarmaciaCtrl();
        setores = farmaciaCtrl.listarSetores();
        DefaultTableModel model1 = (DefaultTableModel) tbSetores.getModel();
        model1.setRowCount(0);
        for (SetorListagemDTO setor : setores) {
            model1.addRow(new Object[] {
                setor.getNome(),
                setor.getQtdFuncionarios(),
                setor.getValeTransporte(),
                setor.getValeRefeicao(),
                setor.getValeAlimentacao(),
                setor.getPlanoSaude(),
            });
        }
        
    }
    
    private void populaTabelaFuncionarios() {
        FarmaciaCtrl farmaciaCtrl = new FarmaciaCtrl();
        funcionarios = farmaciaCtrl.listarFuncionarios();
        DefaultTableModel model1 = (DefaultTableModel) tbFuncionarios.getModel();
        model1.setRowCount(0);
        for (FuncionarioListagemDTO funcionario : funcionarios) {
            model1.addRow(new Object[] {
                funcionario.getIdFuncionario(),
                funcionario.getNomeFuncionario(),
                funcionario.getSalarioBase(),
                funcionario.getNomeSetor(),
            });
        }
        
    }
    
    private void abreAdicionarSetor() {
        CriarSetorGUI criarSetorGUI = new CriarSetorGUI();
        criarSetorGUI.setVisible(true); 
    }
    
    private void abreAdicionarFuncionario() {
        CriarSetorGUI criarSetorGUI = new CriarSetorGUI();
        criarSetorGUI.setVisible(true); 
    }  

    public void fechaAtual(){
        this.dispose();
    }
    
    public void sair(){
        Sessao.limparSessao();
        LoginGUI login = new LoginGUI();
        login.setVisible(true); 
    }
    
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionariosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnOpcoes;
    private javax.swing.JButton btnAddAtualizar;
    private javax.swing.JButton btnAddFuncionario;
    private javax.swing.JButton btnAddSetor;
    private javax.swing.JButton btnAddSetor2;
    private javax.swing.JMenuItem itMnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbFuncionarios;
    private javax.swing.JTable tbSetores;
    // End of variables declaration//GEN-END:variables
}
