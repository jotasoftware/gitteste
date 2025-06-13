/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;
import Controllers.Sessao;
import Controllers.FarmaciaCtrl;
import dto.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class HomeFarmaciaGUI extends javax.swing.JFrame {
    FarmaciaCtrl farmaciaCtrl = new FarmaciaCtrl();
    
    private ArrayList<CompraListagemDTO> compras;
    private ArrayList<VendaListagemDTO> vendas;
    private ArrayList<LucroListagemDTO> lucros;
    private ArrayList<LucroListagemDTO> lucrosAnuais;
    private double saldoAtual;
    
    public HomeFarmaciaGUI() {
        initComponents();
        populaTabelas();
        atualizaSaldo();
        this.saldoAtual = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Numero = new javax.swing.JScrollPane();
        tbCompras = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tbVendas2 = new javax.swing.JScrollPane();
        tbVendas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnAddAtualizar = new javax.swing.JButton();
        btnAddVenda = new javax.swing.JButton();
        btnAddCompra = new javax.swing.JButton();
        btnAbreFuncionarios = new javax.swing.JButton();
        btnAbreTransportadoras = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        btnAbrePrevisoes = new javax.swing.JButton();
        Numero1 = new javax.swing.JScrollPane();
        tbLucros = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnAbreProdutos = new javax.swing.JButton();
        Numero2 = new javax.swing.JScrollPane();
        tbLucrosAnuais = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MnOpcoes = new javax.swing.JMenu();
        itMnPerfil = new javax.swing.JMenuItem();
        itMnEditar = new javax.swing.JMenuItem();
        itMnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Data", "Funcionario", "Quantidade", "Valor Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Numero.setViewportView(tbCompras);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("Tela inicial");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setText("Compras");

        tbVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Data", "Funcionario", "Quantidade", "Valor Final"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVendas2.setViewportView(tbVendas);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Vendas");

        btnAddAtualizar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddAtualizar.setText("Atualizar");
        btnAddAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAtualizarActionPerformed(evt);
            }
        });

        btnAddVenda.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddVenda.setText("Adicionar Venda");
        btnAddVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVendaActionPerformed(evt);
            }
        });

        btnAddCompra.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddCompra.setText("Adicionar Compra");
        btnAddCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCompraActionPerformed(evt);
            }
        });

        btnAbreFuncionarios.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAbreFuncionarios.setText("Funcionarios");
        btnAbreFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbreFuncionariosActionPerformed(evt);
            }
        });

        btnAbreTransportadoras.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAbreTransportadoras.setText("Transportadora");
        btnAbreTransportadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbreTransportadorasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel4.setText("Caixa:");

        labelValor.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        labelValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnAbrePrevisoes.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAbrePrevisoes.setText("Previsões");
        btnAbrePrevisoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrePrevisoesActionPerformed(evt);
            }
        });

        tbLucros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mês", "Compras", "Vendas", "Lucro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Numero1.setViewportView(tbLucros);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("Lucros mensais");

        btnAbreProdutos.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAbreProdutos.setText("Produtos");
        btnAbreProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbreProdutosActionPerformed(evt);
            }
        });

        tbLucrosAnuais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ano", "Compras", "Vendas", "Lucro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Numero2.setViewportView(tbLucrosAnuais);

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel6.setText("Lucros anuais");

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
                        .addComponent(btnAbreFuncionarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbreTransportadoras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbreProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbrePrevisoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddAtualizar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(labelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Numero1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAddCompra)))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(214, 214, 214)
                                                .addComponent(btnAddVenda))
                                            .addComponent(tbVendas2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addComponent(Numero2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(labelValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnAddCompra)
                    .addComponent(jLabel3)
                    .addComponent(btnAddVenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbVendas2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Numero1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Numero2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbreFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAbreProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbreTransportadoras)
                    .addComponent(btnAbrePrevisoes))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itMnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnPerfilActionPerformed

    }//GEN-LAST:event_itMnPerfilActionPerformed

    private void itMnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnSairActionPerformed
        fechaAtual();
        sair();
    }//GEN-LAST:event_itMnSairActionPerformed

    private void btnAddAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAtualizarActionPerformed
        populaTabelas();
        atualizaSaldo();
    }//GEN-LAST:event_btnAddAtualizarActionPerformed

    private void itMnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnEditarActionPerformed

    }//GEN-LAST:event_itMnEditarActionPerformed

    private void btnAddVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVendaActionPerformed
        abreAdicionarVenda();
        fechaAtual();
    }//GEN-LAST:event_btnAddVendaActionPerformed

    private void btnAddCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCompraActionPerformed
        abreAdicionarCompra();
        fechaAtual();
    }//GEN-LAST:event_btnAddCompraActionPerformed

    private void btnAbreFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbreFuncionariosActionPerformed
        abreFuncionario();
        fechaAtual();
    }//GEN-LAST:event_btnAbreFuncionariosActionPerformed

    private void btnAbreTransportadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbreTransportadorasActionPerformed
        abreTransportadora();
        fechaAtual();
    }//GEN-LAST:event_btnAbreTransportadorasActionPerformed

    private void btnAbrePrevisoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrePrevisoesActionPerformed
        abreVendasProgramadas();
        fechaAtual();
    }//GEN-LAST:event_btnAbrePrevisoesActionPerformed

    private void btnAbreProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbreProdutosActionPerformed
        fechaAtual();
        abreProdutos();
    }//GEN-LAST:event_btnAbreProdutosActionPerformed

    private void populaTabelas(){
        populaTabelaCompra();
        populaTabelaVenda();
        populaTabelaLucrosMensais();
        populaTabelaLucrosAnuais();
    }

    private void populaTabelaCompra() {
        compras = farmaciaCtrl.listarCompras();
        DefaultTableModel model1 = (DefaultTableModel) tbCompras.getModel();
        model1.setRowCount(0);
        for (CompraListagemDTO compra : compras) {
            model1.addRow(new Object[] {
                compra.getIdCompra(),
                compra.getDataCompra(),
                compra.getNomeFuncionario(),
                compra.getQtdProdutos(),
                compra.getValorFinal()
            });
        } 
    }
    
    private void populaTabelaVenda() {
        vendas = farmaciaCtrl.listarVendas();
        DefaultTableModel model1 = (DefaultTableModel) tbVendas.getModel();
        model1.setRowCount(0);
        for (VendaListagemDTO venda : vendas) {
            model1.addRow(new Object[] {
                venda.getIdVenda(),
                venda.getDataVenda(),
                venda.getNomeFuncionario(),
                venda.getQtdProdutos(),
                venda.getValorFinal()
            });
        } 
    }
    
    private void populaTabelaLucrosMensais() {
        lucros = farmaciaCtrl.listarLucrosMensais(false);
        DefaultTableModel model1 = (DefaultTableModel) tbLucros.getModel();
        model1.setRowCount(0);
        for (LucroListagemDTO lucro : lucros) {
            model1.addRow(new Object[] {
                lucro.getData(),
                lucro.getSomatorioCompra(),
                lucro.getSomatorioVenda(),
                lucro.getLucro(),
            });
        } 
    }
    
    private void populaTabelaLucrosAnuais() {
        lucrosAnuais = farmaciaCtrl.listarLucrosAnuais(false);
        DefaultTableModel model1 = (DefaultTableModel) tbLucrosAnuais.getModel();
        model1.setRowCount(0);
        for (LucroListagemDTO lucro : lucrosAnuais) {
            model1.addRow(new Object[] {
                lucro.getData(),
                lucro.getSomatorioCompra(),
                lucro.getSomatorioVenda(),
                lucro.getLucro(),
            });
        } 
    }
    
    private void atualizaSaldo() {
        saldoAtual = farmaciaCtrl.buscaSaldo();
        for (LucroListagemDTO lucro : lucros) {
            saldoAtual += lucro.getLucro();
        } 
        labelValor.setText(String.format("R$ %.2f", saldoAtual));
    }
    
    public void fechaAtual(){
        this.dispose();
    }
    
    public void sair(){
        Sessao.limparSessao();
        LoginGUI login = new LoginGUI();
        login.setVisible(true); 
    }
    
    public void abreAdicionarCompra() {
        FuncionarioResponsavelGUI funcionarioResponsavel = new FuncionarioResponsavelGUI(1);
        funcionarioResponsavel.setVisible(true);
    }
    
    public void abreAdicionarVenda() {
        FuncionarioResponsavelGUI funcionarioResponsavel = new FuncionarioResponsavelGUI(2);
        funcionarioResponsavel.setVisible(true);
    }
    
    public void abreFuncionario() {
        FuncionariosGUI funcionarios = new FuncionariosGUI();
        funcionarios.setVisible(true); 
    }
    
    public void abreTransportadora() {
        TransportadorasGUI transportadoras = new TransportadorasGUI();
        transportadoras.setVisible(true); 
    }
    
    public void abreProdutos() {
        ProdutosGUI produtos = new ProdutosGUI();
        produtos.setVisible(true); 
    }
    
    public void abreVendasProgramadas() {
        VendasProgramadasGUI vendasProgramadas = new VendasProgramadasGUI();
        vendasProgramadas.setVisible(true); 
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFarmaciaGUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnOpcoes;
    private javax.swing.JScrollPane Numero;
    private javax.swing.JScrollPane Numero1;
    private javax.swing.JScrollPane Numero2;
    private javax.swing.JButton btnAbreFuncionarios;
    private javax.swing.JButton btnAbrePrevisoes;
    private javax.swing.JButton btnAbreProdutos;
    private javax.swing.JButton btnAbreTransportadoras;
    private javax.swing.JButton btnAddAtualizar;
    private javax.swing.JButton btnAddCompra;
    private javax.swing.JButton btnAddVenda;
    private javax.swing.JMenuItem itMnEditar;
    private javax.swing.JMenuItem itMnPerfil;
    private javax.swing.JMenuItem itMnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelValor;
    private javax.swing.JTable tbCompras;
    private javax.swing.JTable tbLucros;
    private javax.swing.JTable tbLucrosAnuais;
    private javax.swing.JTable tbVendas;
    private javax.swing.JScrollPane tbVendas2;
    // End of variables declaration//GEN-END:variables
}
