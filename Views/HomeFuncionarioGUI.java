/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;
import Controllers.EncomendaCtrl;
import Controllers.PessoaCtrl;
import Controllers.Sessao;
import Controllers.VisitanteCtrl;
import Models.Encomenda;
import Models.Visitante;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaopedro
 */
public class HomeFuncionarioGUI extends javax.swing.JFrame {
    private ArrayList<Encomenda> encomendas;
    private ArrayList<Visitante> visitantes;
    
    public HomeFuncionarioGUI() {
        initComponents();
        populaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbEncomendas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAddEncomenda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVisitantes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnAddAtualizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MnOpcoes = new javax.swing.JMenu();
        itMnPerfil = new javax.swing.JMenuItem();
        itMnEditar = new javax.swing.JMenuItem();
        itMnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbEncomendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Apartamento", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbEncomendas);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setText("Tela do Funcionário");

        jLabel2.setText("Encomendas");

        btnAddEncomenda.setText("Adicionar Encomenda");
        btnAddEncomenda.setActionCommand("Adicionar Encomenda");
        btnAddEncomenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEncomendaActionPerformed(evt);
            }
        });

        tbVisitantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data", "Nome", "CPF Visitante", "Apartamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbVisitantes);

        jLabel3.setText("Visitantes Liberados");

        btnAddAtualizar.setText("Atualizar");
        btnAddAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAtualizarActionPerformed(evt);
            }
        });

        jMenu2.setText("Inicio");
        jMenuBar1.add(jMenu2);

        MnOpcoes.setText("Opcões");

        itMnPerfil.setText("Perfil");
        itMnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itMnPerfilActionPerformed(evt);
            }
        });
        MnOpcoes.add(itMnPerfil);

        itMnEditar.setText("Editar");
        itMnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itMnEditarActionPerformed(evt);
            }
        });
        MnOpcoes.add(itMnEditar);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddEncomenda))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddAtualizar)))
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
                    .addComponent(btnAddEncomenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itMnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnPerfilActionPerformed
        abrePerfil();
    }//GEN-LAST:event_itMnPerfilActionPerformed

    private void btnAddEncomendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEncomendaActionPerformed
        abreCriarEncomenda();
    }//GEN-LAST:event_btnAddEncomendaActionPerformed

    private void itMnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnSairActionPerformed
        fechaAtual();
        sair();
    }//GEN-LAST:event_itMnSairActionPerformed

    private void btnAddAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAtualizarActionPerformed
        populaTabela();
    }//GEN-LAST:event_btnAddAtualizarActionPerformed

    private void itMnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnEditarActionPerformed
        abreEditar();
    }//GEN-LAST:event_itMnEditarActionPerformed


    private void populaTabela() {
        EncomendaCtrl encomendaCtrl = new EncomendaCtrl();
        encomendas = encomendaCtrl.listarEncomendasPorteiro();
        DefaultTableModel model1 = (DefaultTableModel) tbEncomendas.getModel();
        model1.setRowCount(0);
        for (Encomenda encomenda : encomendas) {
            model1.addRow(new Object[] {
                encomenda.getIdEncomenda(),
                encomenda.getAptoEncomenda(),
                encomenda.getDataEncomenda(),
            });
        }
        
        VisitanteCtrl visitanteCtrl = new VisitanteCtrl();
        visitantes = visitanteCtrl.todosVisitantes();
        DefaultTableModel model2 = (DefaultTableModel) tbVisitantes.getModel();
        model2.setRowCount(0);
        for (Visitante visitante : visitantes) {
            model2.addRow(new Object[] {
                visitante.getData(),
                visitante.getNome(),
                visitante.getCpf(),
                visitante.getApto(),
            });
        }
        
    }
    public void fechaAtual(){
        this.dispose();
    }
    
    public void sair(){
        Sessao.limparSessao();
        LoginGUI login = new LoginGUI();
        login.setVisible(true); 
    }
    
    public void abreEditar(){
        EditarContaGUI editarConta = new EditarContaGUI();
        editarConta.setVisible(true); 
    }
    
    public void abrePerfil() {
        PessoaCtrl pessoaCtrl = new PessoaCtrl();
        JOptionPane.showMessageDialog(null, pessoaCtrl.verificarDados(), "Perfil do Usuário", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void abreCriarEncomenda() {
        CriarEncomendaGUI criarEncomenda = new CriarEncomendaGUI();
        criarEncomenda.setVisible(true); 
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFuncionarioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnOpcoes;
    private javax.swing.JButton btnAddAtualizar;
    private javax.swing.JButton btnAddEncomenda;
    private javax.swing.JMenuItem itMnEditar;
    private javax.swing.JMenuItem itMnPerfil;
    private javax.swing.JMenuItem itMnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbEncomendas;
    private javax.swing.JTable tbVisitantes;
    // End of variables declaration//GEN-END:variables
}
