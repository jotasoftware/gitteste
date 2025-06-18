package Views;
import Controllers.FarmaciaCtrl;
import Controllers.Sessao;
import dto.LucroListagemDTO;
import dto.VendaListagemDTO;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendasProgramadasGUI extends javax.swing.JFrame {
    private ArrayList<VendaListagemDTO> vendas;
    private ArrayList<VendaListagemDTO> vendasFuturas;
    private ArrayList<LucroListagemDTO> lucrosMensais;
    private ArrayList<LucroListagemDTO> lucrosAnuais;
    
     NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    
    public VendasProgramadasGUI() {
        initComponents();
        populaTabelas();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        Numero2 = new javax.swing.JScrollPane();
        tbLucros1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVendas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAddSetor2 = new javax.swing.JButton();
        Numero1 = new javax.swing.JScrollPane();
        tbLucros = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Numero3 = new javax.swing.JScrollPane();
        tbLucros2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MnOpcoes = new javax.swing.JMenu();
        itMnSair = new javax.swing.JMenuItem();

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel6.setText("Lucros mensais previstos");

        tbLucros1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mês", "Lucro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Numero2.setViewportView(tbLucros1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Data", "Funcionário", "Quantidade", "Valor Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbVendas);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("Previsões");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        btnAddSetor2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddSetor2.setText("Voltar");
        btnAddSetor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSetor2ActionPerformed(evt);
            }
        });

        tbLucros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mês", "Lucro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Numero1.setViewportView(tbLucros);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("Lucros mensais previstos");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel7.setText("Lucros anuais previstos");

        tbLucros2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ano", "Lucro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Numero3.setViewportView(tbLucros2);

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel8.setText("Vendas programadas");

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Numero1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(96, 96, 96))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Numero3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddSetor2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Numero1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Numero3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddSetor2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSetor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSetor2ActionPerformed
        abreHomeFarmacia();
        fechaAtual();
    }//GEN-LAST:event_btnAddSetor2ActionPerformed

    private void itMnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itMnSairActionPerformed
        fechaAtual();
        sair();
    }//GEN-LAST:event_itMnSairActionPerformed

    private void populaTabelas() {
        populaTabelaVendas();
        populaTabelaLucrosMensais();
        populaTabelaLucrosAnuais();
    }

    private void populaTabelaVendas() {
        FarmaciaCtrl farmaciaCtrl = new FarmaciaCtrl();
        vendas = farmaciaCtrl.listarVendas();
        vendasFuturas = new ArrayList<>();
        LocalDate hoje = LocalDate.now();

        for (VendaListagemDTO venda : vendas) {
            if (venda.getDataVenda().isAfter(hoje)) {
                vendasFuturas.add(venda);
            }
        }

        
        DefaultTableModel model1 = (DefaultTableModel) tbVendas.getModel();
        model1.setRowCount(0);
        for (VendaListagemDTO venda : vendasFuturas) {
            model1.addRow(new Object[] {
                venda.getIdVenda(),
                venda.getDataVenda(),
                venda.getNomeFuncionario(),
                venda.getQtdProdutos(),
                nf.format(venda.getValorFinal()),
            });
        } 
    }
    
    private void populaTabelaLucrosMensais() {
        FarmaciaCtrl farmaciaCtrl = new FarmaciaCtrl();
        lucrosMensais = farmaciaCtrl.listarLucrosMensais(true);
        DefaultTableModel model1 = (DefaultTableModel) tbLucros.getModel();
        model1.setRowCount(0);
        for (LucroListagemDTO lucro : lucrosMensais) {
            model1.addRow(new Object[] {
                lucro.getData(),
                nf.format(lucro.getLucro())
            });
        } 
    }
    
    private void populaTabelaLucrosAnuais() {
        FarmaciaCtrl farmaciaCtrl = new FarmaciaCtrl();
        lucrosAnuais = farmaciaCtrl.listarLucrosAnuais(true);
        DefaultTableModel model1 = (DefaultTableModel) tbLucros2.getModel();
        model1.setRowCount(0);
        for (LucroListagemDTO lucro : lucrosAnuais) {
            model1.addRow(new Object[] {
                lucro.getData(),
                nf.format(lucro.getLucro())
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
    
    public void abreHomeFarmacia() {
        HomeFarmaciaGUI homeFarmacia = new HomeFarmaciaGUI();
        homeFarmacia.setVisible(true); 
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendasProgramadasGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnOpcoes;
    private javax.swing.JScrollPane Numero1;
    private javax.swing.JScrollPane Numero2;
    private javax.swing.JScrollPane Numero3;
    private javax.swing.JButton btnAddSetor2;
    private javax.swing.JMenuItem itMnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLucros;
    private javax.swing.JTable tbLucros1;
    private javax.swing.JTable tbLucros2;
    private javax.swing.JTable tbVendas;
    // End of variables declaration//GEN-END:variables
}
