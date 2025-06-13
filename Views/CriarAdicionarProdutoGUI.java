package Views;
import Controllers.ComprasCtrl;
import Controllers.FarmaciaCtrl;
import Controllers.FuncionarioCtrl;
import Controllers.VendasCtrl;
import Models.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CriarAdicionarProdutoGUI extends javax.swing.JFrame {
    List<Produto> produtos = new ArrayList<>();
    List<Produto> produtosVenda = new ArrayList<>();
    private int id;
    private int tipo;
    private Produto produtoSelecionado;
    int idProduto;
    int quantidadeProduto;

    public CriarAdicionarProdutoGUI(int tipo, int id) {
        initComponents();
        this.id = id;
        this.tipo = tipo;
        if(tipo ==1){
            populaComboBoxCompra();
        }else{
            populaComboBoxVenda();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAddProduto = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        comboBoxProdutos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextQuantidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("PRODUTO");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Produto:");

        btnAddProduto.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAddProduto.setText("Adicionar Produto");
        btnAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdutoActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        comboBoxProdutos.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        comboBoxProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProdutosActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel4.setText("Quantidade:");

        jTextQuantidade.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxProdutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 257, Short.MAX_VALUE)
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddProduto)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(205, 205, 205))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduto)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdutoActionPerformed
        adicionarProduto(); //trabalhar nisso 
    }//GEN-LAST:event_btnAddProdutoActionPerformed

    private void comboBoxProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProdutosActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        fechaAtual();
        if(tipo ==1){
            CriarCompraGUI criarCompra = new CriarCompraGUI(id);
            criarCompra.setVisible(true);
        }else{
            CriarVendaGUI criarVenda = new CriarVendaGUI(id);
            criarVenda.setVisible(true);
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    public void fechaAtual(){
        this.dispose();
    }
    
    public void populaComboBoxCompra(){
        FarmaciaCtrl farmaciaCtrl = new FarmaciaCtrl();
        produtos = farmaciaCtrl.listarProdutos();

        for (Produto produto : produtos) {
            comboBoxProdutos.addItem(produto.getNomeProduto() + " - " + produto.getQtdProduto() + " unidades");
        }
    }
    
    public void populaComboBoxVenda(){
        FarmaciaCtrl farmaciaCtrl = new FarmaciaCtrl();
        produtos = farmaciaCtrl.listarProdutos();

        for (Produto produto : produtos) {
            if(produto.getQtdProduto() > 0){
                produtosVenda.add(produto); 
            }
        }
        
        for (Produto produto : produtosVenda) {
            comboBoxProdutos.addItem(produto.getNomeProduto() + " - " + produto.getQtdProduto()+ " unidades");

        }
    }
    
    public void adicionarProduto(){
        
        if (jTextQuantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Quantidade é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int quantidadeInt = Integer.parseInt(jTextQuantidade.getText());
            if (quantidadeInt < 1) {
                JOptionPane.showMessageDialog(this, "A quantidade tem que ser maior que 0.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int indexSelecionado = comboBoxProdutos.getSelectedIndex();
            if (indexSelecionado >= 0) {
            
                switch(tipo){
                    case 1:
                        produtoSelecionado = produtos.get(indexSelecionado);
                        idProduto = produtoSelecionado.getIdProduto();
                 
                        ComprasCtrl comprasCtrl = new ComprasCtrl();
                        if(comprasCtrl.adicionarProdutoEmCompra(this.id, idProduto, quantidadeInt)){
                            this.dispose();
                            CriarCompraGUI criarCompra = new CriarCompraGUI(id);
                            criarCompra.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(this, "Dados Invalidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                        produtoSelecionado = produtosVenda.get(indexSelecionado);
                        idProduto = produtoSelecionado.getIdProduto();
                        quantidadeProduto = produtoSelecionado.getQtdProduto();
                        VendasCtrl vendasCtrl = new VendasCtrl();
                        if (quantidadeInt > quantidadeProduto) {
                            JOptionPane.showMessageDialog(this, "Você não tem estoque suficiente.", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if(vendasCtrl.adicionarProdutoEmVenda(this.id, idProduto, quantidadeInt)){
                            this.dispose();
                            CriarVendaGUI criarVenda = new CriarVendaGUI(id);
                            criarVenda.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(this, "Dados Invalidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Erro.", "Erro", JOptionPane.ERROR_MESSAGE);

                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dados invalidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
       
    }
   
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarAdicionarProdutoGUI(1, 1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduto;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> comboBoxProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextQuantidade;
    // End of variables declaration//GEN-END:variables

}
