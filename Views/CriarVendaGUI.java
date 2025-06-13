package Views;
import Controllers.VendasCtrl;
import Controllers.ProdutoCtrl;
import dto.ProdutosCompraListagemDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class CriarVendaGUI extends javax.swing.JFrame {
    private int idVenda;
    private double total = 0;
    private double totalFinal = 0;
    private double desconto = 0;
    private ArrayList<ProdutosCompraListagemDTO> produtos;
    
    public CriarVendaGUI(int idVenda) {
        initComponents();
        this.idVenda = idVenda;
        populaTabela();
        total();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAddVenda = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        btnAddProduto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cxDesconto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelTotalFinal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnDesconto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("CRIAR VENDA");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Produtos:");

        btnAddVenda.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddVenda.setText("Cadastrar Venda");
        btnAddVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVendaActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnVoltar.setText("Voltar");

        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbProdutos);

        btnAddProduto.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddProduto.setText("Adicionar Produto");
        btnAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdutoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel4.setText("Desconto:");

        cxDesconto.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("Total:");

        jLabelTotal.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        jLabelTotalFinal.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel6.setText("Valor final:");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel7.setText("Data:");

        btnDesconto.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnDesconto.setText("Aplicar Desconto");
        btnDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddVenda))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddProduto))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cxDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabelTotal))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTotalFinal)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnAddProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabelTotal)
                        .addComponent(jLabel7))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cxDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelTotalFinal))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddVenda)
                    .addComponent(btnVoltar)
                    .addComponent(btnDesconto))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVendaActionPerformed
        finalizarVenda();
    }//GEN-LAST:event_btnAddVendaActionPerformed

    private void btnAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdutoActionPerformed
        abreAdicionarProduto();
        fechaAtual();
    }//GEN-LAST:event_btnAddProdutoActionPerformed

    private void btnDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontoActionPerformed
        aplicarDesconto();
    }//GEN-LAST:event_btnDescontoActionPerformed

    public void fechaAtual(){
        this.dispose();
    }
    
    private void abreAdicionarProduto() {
        CriarAdicionarProdutoGUI telaProduto = new CriarAdicionarProdutoGUI(2, this.idVenda);
        telaProduto.setVisible(true);
    }
    
    private void populaTabela() {
        VendasCtrl vendasCtrl = new VendasCtrl();
        produtos = vendasCtrl.listarProdutosEmVenda(this.idVenda);
        DefaultTableModel model1 = (DefaultTableModel) tbProdutos.getModel();
        model1.setRowCount(0);
        for (ProdutosCompraListagemDTO produto : produtos) {
            model1.addRow(new Object[] {
                produto.getNomeProduto(),
                produto.getQtdProduto(),
                produto.getValorTotal(),
            });
        }
        
    }
    
    private void total() {
        total = 0;
        desconto = 0;
        for (ProdutosCompraListagemDTO produto : produtos) {
            total += produto.getValorTotal();
        }
        jLabelTotal.setText(String.format("R$ %.2f", total));
        jLabelTotalFinal.setText(String.format("R$ %.2f", total));
    }
    
    private void aplicarDesconto() {
        if (cxDesconto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o desconto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String textoDesconto = cxDesconto.getText();

        try {
            desconto = Double.parseDouble(textoDesconto);
            if (desconto<0 || desconto > 100) {
                JOptionPane.showMessageDialog(this, "Digite um desconto entre 0 e 100%.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            jLabelTotalFinal.setText(String.format("R$ %.2f", total * (1-(desconto/100))));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor numérico válido para o desconto.");
        }
       
    }
    
    private void finalizarVenda(){
        VendasCtrl vendasCtrl = new VendasCtrl();
        ProdutoCtrl produtoCtrl = new ProdutoCtrl();
        
        if(total==0){
            JOptionPane.showMessageDialog(this, "Nenhum produto adicionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Date dataSelecionada = jDateChooser1.getDate();

        if (dataSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma data.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            LocalDate dataConvertida = dataSelecionada.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        
        
            if(vendasCtrl.finalizarVenda(this.idVenda, total * (1-(desconto/100)), dataConvertida)){
                produtoCtrl.removerProdutos(produtos);
                JOptionPane.showMessageDialog(this, "Venda cadastrada.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                HomeFarmaciaGUI homeFarmacia = new HomeFarmaciaGUI();
                homeFarmacia.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Dados Invalidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarVendaGUI(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduto;
    private javax.swing.JButton btnAddVenda;
    private javax.swing.JButton btnDesconto;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField cxDesconto;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalFinal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProdutos;
    // End of variables declaration//GEN-END:variables

}
