/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;
import Controllers.ComprasCtrl;
import Controllers.FuncionarioCtrl;
import Controllers.Sessao;
import Controllers.VendasCtrl;
import dto.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaopedro
 */
public class FuncionarioResponsavelGUI extends javax.swing.JFrame {
    private ArrayList<FuncionarioListagemDTO> funcionarios;
    private int funcionarioSelecionado = -1;
    private int tipo;
    
    public FuncionarioResponsavelGUI(int tipo) {
        initComponents();
        this.tipo = tipo;
        populaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbFuncionarios = new javax.swing.JTable();
        btnProximo = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MnOpcoes = new javax.swing.JMenu();
        itMnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("Funcionário Responsavel");

        tbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        if (tbFuncionarios.getColumnModel().getColumnCount() > 0) {
            tbFuncionarios.getColumnModel().getColumn(0).setResizable(false);
            tbFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbFuncionarios.getColumnModel().getColumn(1).setResizable(false);
            tbFuncionarios.getColumnModel().getColumn(2).setResizable(false);
        }

        btnProximo.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnProximo.setText("Proximo");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar)
                        .addGap(16, 16, 16)
                        .addComponent(btnProximo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnProximo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itMnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnSairActionPerformed
        fechaAtual();
        sair();
    }//GEN-LAST:event_itMnSairActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        if(!funcionarios.isEmpty()){
           if(tipo ==1){
            abreCriarCompra();
            }else{
                abreCriarVenda();
            }
        }
        
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        abreHomeFarmacia();
        fechaAtual();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tbFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFuncionariosMouseClicked
        int linhaSelecionada = tbFuncionarios.getSelectedRow();
        if (linhaSelecionada != -1) {
            FuncionarioListagemDTO funcionario = funcionarios.get(linhaSelecionada);
            funcionarioSelecionado = funcionario.getIdFuncionario();
        }  
    }//GEN-LAST:event_tbFuncionariosMouseClicked

    public void abreHomeFarmacia() {
        HomeFarmaciaGUI homeFarmacia = new HomeFarmaciaGUI();
        homeFarmacia.setVisible(true); 
    }
    
    private void populaTabela() {
        FuncionarioCtrl funcionarioCtrl = new FuncionarioCtrl();
        funcionarios = funcionarioCtrl.listarResponsaveis(tipo);
        DefaultTableModel model1 = (DefaultTableModel) tbFuncionarios.getModel();
        model1.setRowCount(0);
        for (FuncionarioListagemDTO funcionario : funcionarios) {
            model1.addRow(new Object[] {
                funcionario.getIdFuncionario(),
                funcionario.getNomeFuncionario(),
                funcionario.getNomeSetor(),
            });
        }
        if(funcionarios.isEmpty()){
            JOptionPane.showMessageDialog(this, "Sem responsáveis " + (tipo == 1? "pelo almoxarifado" : " pelas vendas") + " para listar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abreCriarVenda() {
        if (funcionarioSelecionado == -1) {
            JOptionPane.showMessageDialog(this, "Escolha um funcionário", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        VendasCtrl vendasCtrl = new VendasCtrl();
        int idVendaGerada = vendasCtrl.criarNovaVenda(funcionarioSelecionado);
        if (idVendaGerada != -1) {
            CriarVendaGUI criarVenda = new CriarVendaGUI(idVendaGerada);
            criarVenda.setVisible(true); 
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao iniciar compra.", "Erro", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private void abreCriarCompra() {
        if (funcionarioSelecionado == -1) {
            JOptionPane.showMessageDialog(this, "Escolha um funcionário", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ComprasCtrl comprasCtrl = new ComprasCtrl();
        int idCompraGerada = comprasCtrl.criarNovaCompra(funcionarioSelecionado);
        if (idCompraGerada != -1) {
            CriarCompraGUI criarCompra = new CriarCompraGUI(idCompraGerada);
            criarCompra.setVisible(true); 
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao iniciar compra.", "Erro", JOptionPane.ERROR_MESSAGE);
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
    
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioResponsavelGUI(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnOpcoes;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JMenuItem itMnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbFuncionarios;
    // End of variables declaration//GEN-END:variables
}
