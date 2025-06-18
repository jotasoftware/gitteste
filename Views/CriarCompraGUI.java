package Views;

import Controllers.ComprasCtrl;
import Controllers.ProdutoCtrl;
import dto.ProdutosCompraListagemDTO;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CriarCompraGUI extends javax.swing.JFrame {
    private int idCompra;
    private double total = 0;
    private ArrayList<ProdutosCompraListagemDTO> produtos;
    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    
    public CriarCompraGUI(int idCompra) {
        initComponents();
        this.idCompra = idCompra;
        populaTabela();
        total();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAddComprar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        btnAddCompra = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("CRIAR COMPRA");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Produtos:");

        btnAddComprar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddComprar.setText("Cadastrar Compra");
        btnAddComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddComprarActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

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
        tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProdutos);

        btnAddCompra.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddCompra.setText("Adicionar Produto");
        btnAddCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCompraActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("Total:");

        jLabelTotal.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnAddCompra)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(83, 83, 83)
                                .addComponent(jLabelTotal))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnVoltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddComprar)))))
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
                    .addComponent(btnAddCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabelTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddComprar)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddComprarActionPerformed
        finalizarCompra();
    }//GEN-LAST:event_btnAddComprarActionPerformed

    private void btnAddCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCompraActionPerformed
        abreAdicionarProduto();
        fechaAtual();
    }//GEN-LAST:event_btnAddCompraActionPerformed

    private void tbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMouseClicked
        int linhaSelecionada = tbProdutos.getSelectedRow();
        
        if (linhaSelecionada != -1) {
            ProdutosCompraListagemDTO produto = produtos.get(linhaSelecionada);
            ComprasCtrl compraCtrl = new ComprasCtrl();
            String mensagem = String.format(
                "Deseja retirar este produto?\n"
            );
            int resposta = JOptionPane.showConfirmDialog(
                this,
                mensagem,
                "Confirmação de Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {
                if(compraCtrl.apagar(idCompra, produto.getIdProduto())){
                    JOptionPane.showMessageDialog(this, "Produto retirado com sucesso!");
                    populaTabela();
                    total();
                }
            }
        }
            
    }//GEN-LAST:event_tbProdutosMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        HomeFarmaciaGUI homeFarmacia = new HomeFarmaciaGUI();
        homeFarmacia.setVisible(true);
        fechaAtual();
    }//GEN-LAST:event_btnVoltarActionPerformed

    public void fechaAtual(){
        this.dispose();
    }
    
    private void abreAdicionarProduto() {
        CriarAdicionarProdutoGUI telaProduto = new CriarAdicionarProdutoGUI(1, this.idCompra);
        telaProduto.setVisible(true);
    }
    
    private void populaTabela() {
        ComprasCtrl compraCtrl = new ComprasCtrl();
        produtos = compraCtrl.listarProdutosEmCompra(this.idCompra);
        DefaultTableModel model1 = (DefaultTableModel) tbProdutos.getModel();
        model1.setRowCount(0);
        for (ProdutosCompraListagemDTO produto : produtos) {
            model1.addRow(new Object[] {
                produto.getNomeProduto(),
                produto.getQtdProduto(),
                nf.format(produto.getValorTotal())
            });
        }
        
    }
    
    private void total() {
        total = 0;
        for (ProdutosCompraListagemDTO produto : produtos) {
            System.out.println(produto.getValorTotal());
            total += produto.getValorTotal();
        }
        jLabelTotal.setText(nf.format(total));
    }
    
    private void finalizarCompra(){
        ComprasCtrl compraCtrl = new ComprasCtrl();
        ProdutoCtrl produtoCtrl = new ProdutoCtrl();
        
        if(total==0){
            JOptionPane.showMessageDialog(this, "Nenhum produto adicionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(compraCtrl.finalizarCompra(this.idCompra, total)){
            produtoCtrl.adicionarProdutos(produtos);
            JOptionPane.showMessageDialog(this, "Compra cadastrada.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            HomeFarmaciaGUI homeFarmacia = new HomeFarmaciaGUI();
            homeFarmacia.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Dados Invalidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarCompraGUI(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCompra;
    private javax.swing.JButton btnAddComprar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProdutos;
    // End of variables declaration//GEN-END:variables

}
