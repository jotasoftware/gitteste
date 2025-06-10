package Views;

import Controllers.AvisoCtrl;
import Controllers.PessoaCtrl;
import Controllers.Sessao;
import Models.Aviso;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HomeCondominoGUI extends javax.swing.JFrame {
    private ArrayList<Aviso> avisos;
    public HomeCondominoGUI() {
        initComponents();
        populaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEncomendas = new javax.swing.JButton();
        btnReserva = new javax.swing.JButton();
        btnVisitantes = new javax.swing.JButton();
        btnTags = new javax.swing.JButton();
        btnOcorrencias = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAvisos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MnOpcoes = new javax.swing.JMenu();
        itMnPerfil = new javax.swing.JMenuItem();
        itMnEditar = new javax.swing.JMenuItem();
        itMnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnEncomendas.setText("Encomendas");
        btnEncomendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncomendasActionPerformed(evt);
            }
        });

        btnReserva.setText("Reservas");
        btnReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservaActionPerformed(evt);
            }
        });

        btnVisitantes.setText("Visitantes");
        btnVisitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisitantesActionPerformed(evt);
            }
        });

        btnTags.setText("Tags");
        btnTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagsActionPerformed(evt);
            }
        });

        btnOcorrencias.setText("Ocorrencias");
        btnOcorrencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcorrenciasActionPerformed(evt);
            }
        });

        tbAvisos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Aviso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbAvisos);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setText("Tela do Condomino");

        jLabel2.setText("Principais avisos");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnVisitantes, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(btnReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOcorrencias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEncomendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnTags, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEncomendas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTags, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(btnOcorrencias, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itMnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnPerfilActionPerformed
        abrePerfil();
    }//GEN-LAST:event_itMnPerfilActionPerformed

    private void btnEncomendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncomendasActionPerformed
        fechaAtual();
        abreEncomendas();
    }//GEN-LAST:event_btnEncomendasActionPerformed

    private void btnReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservaActionPerformed
        fechaAtual();
        abreReservas();
    }//GEN-LAST:event_btnReservaActionPerformed

    private void btnVisitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisitantesActionPerformed
        fechaAtual();
        abreVisitantes();
    }//GEN-LAST:event_btnVisitantesActionPerformed

    private void btnTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagsActionPerformed
        fechaAtual();
        abreTags();
    }//GEN-LAST:event_btnTagsActionPerformed

    private void btnOcorrenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcorrenciasActionPerformed
        fechaAtual();
        abreCriarOcorrencias();
    }//GEN-LAST:event_btnOcorrenciasActionPerformed

    private void itMnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnSairActionPerformed
        fechaAtual();
        sair();
    }//GEN-LAST:event_itMnSairActionPerformed

    private void itMnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnEditarActionPerformed
        abreEditar();
    }//GEN-LAST:event_itMnEditarActionPerformed

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
    
    public void abreReservas() {
        ReservasCondominoGUI reservas = new ReservasCondominoGUI();
        reservas.setVisible(true); 
    }
    
    public void abreTags() {
        TagsGUI tags = new TagsGUI();
        tags.setVisible(true); 
    }
    
    public void abreEncomendas() {
        EncomendasGUI encomendas = new EncomendasGUI();
        encomendas.setVisible(true); 
    }
    
    public void abreVisitantes() {
        VisitantesCondominoGUI visitantes = new VisitantesCondominoGUI();
        visitantes.setVisible(true); 
    }
    
    public void abreCriarOcorrencias() {
        CriarOcorrenciaGUI criarOcorrencia = new CriarOcorrenciaGUI();
        criarOcorrencia.setVisible(true); 
    }
    
    private void populaTabela() {
        AvisoCtrl avisoCtrl = new AvisoCtrl();
        avisos = avisoCtrl.listarAvisos();
        DefaultTableModel model = (DefaultTableModel) tbAvisos.getModel();
        model.setRowCount(0);
        for (Aviso aviso : avisos) {
            model.addRow(new Object[] {
                aviso.getTextoAviso(),
            });
        }
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
            java.util.logging.Logger.getLogger(HomeCondominoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeCondominoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeCondominoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeCondominoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeCondominoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnOpcoes;
    private javax.swing.JButton btnEncomendas;
    private javax.swing.JButton btnOcorrencias;
    private javax.swing.JButton btnReserva;
    private javax.swing.JButton btnTags;
    private javax.swing.JButton btnVisitantes;
    private javax.swing.JMenuItem itMnEditar;
    private javax.swing.JMenuItem itMnPerfil;
    private javax.swing.JMenuItem itMnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAvisos;
    // End of variables declaration//GEN-END:variables
}
