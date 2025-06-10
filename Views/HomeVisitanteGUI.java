/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;
import Controllers.PessoaCtrl;
import Controllers.Sessao;
import Controllers.VisitanteCtrl;
import Models.Visitante;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HomeVisitanteGUI extends javax.swing.JFrame {

    public HomeVisitanteGUI() {
        initComponents();
        populaTabela();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSolicitarAcesso = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVisitantes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnAddAviso1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MnOpcoes = new javax.swing.JMenu();
        itMnPerfil = new javax.swing.JMenuItem();
        itMnEditar = new javax.swing.JMenuItem();
        itMnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setText("Tela do Visitante");

        btnSolicitarAcesso.setText("Solicitar Acesso");
        btnSolicitarAcesso.setActionCommand("Adicionar Encomenda");
        btnSolicitarAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarAcessoActionPerformed(evt);
            }
        });

        tbVisitantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Data", "Apartamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbVisitantes);

        jLabel3.setText("Acessos Confirmados");

        btnAddAviso1.setText("Atualizar");
        btnAddAviso1.setToolTipText("");
        btnAddAviso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAviso1ActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSolicitarAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddAviso1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnAddAviso1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSolicitarAcesso)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itMnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnPerfilActionPerformed
        abrePerfil();
    }//GEN-LAST:event_itMnPerfilActionPerformed

    private void itMnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnSairActionPerformed
        fechaAtual();
        sair();
    }//GEN-LAST:event_itMnSairActionPerformed

    private void btnSolicitarAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarAcessoActionPerformed
        abreAcessos();
    }//GEN-LAST:event_btnSolicitarAcessoActionPerformed

    private void itMnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnEditarActionPerformed
        abreEditar();
    }//GEN-LAST:event_itMnEditarActionPerformed

    private void btnAddAviso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAviso1ActionPerformed
        populaTabela();
    }//GEN-LAST:event_btnAddAviso1ActionPerformed

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
    
    public void abreAcessos() {
        CriarAcessoVisitanteGUI criarAcessoVistante = new CriarAcessoVisitanteGUI();
        criarAcessoVistante.setVisible(true); 
    }
    
    private void populaTabela() {
        VisitanteCtrl visitanteCtrl = new VisitanteCtrl();
        ArrayList<Visitante> visitantes = visitanteCtrl.listarVisita();
        DefaultTableModel model = (DefaultTableModel) tbVisitantes.getModel();
        model.setRowCount(0);
        for (Visitante visitante : visitantes) {
            model.addRow(new Object[] {
                visitante.getData(),
                visitante.getApto(),
            });
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeVisitanteGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnOpcoes;
    private javax.swing.JButton btnAddAviso1;
    private javax.swing.JButton btnSolicitarAcesso;
    private javax.swing.JMenuItem itMnEditar;
    private javax.swing.JMenuItem itMnPerfil;
    private javax.swing.JMenuItem itMnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbVisitantes;
    // End of variables declaration//GEN-END:variables
}
