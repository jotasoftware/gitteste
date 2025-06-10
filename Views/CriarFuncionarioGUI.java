package Views;
import Controllers.FarmaciaCtrl;
import Controllers.FuncionarioCtrl;
import Controllers.SindicoCtrl;

public class CriarFuncionarioGUI extends javax.swing.JFrame {

    public CriarFuncionarioGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cxNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cxIdade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cxGenero = new javax.swing.JComboBox<>();
        btnCriarFuncionario = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cxSalario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSetores = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cxSetor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("CRIAR FUNCIONÁRIO");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Nome:");

        cxNome.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        cxNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxNomeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel6.setText("Idade:");

        cxIdade.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel7.setText("Salário:");

        cxGenero.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        cxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros" }));
        cxGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxGeneroActionPerformed(evt);
            }
        });

        btnCriarFuncionario.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnCriarFuncionario.setText("Criar Funcionário");
        btnCriarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarFuncionarioActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel8.setText("Gênero:");

        cxSalario.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        cxSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxSalarioActionPerformed(evt);
            }
        });

        tbSetores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Setor", "Funcionarios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbSetores);

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel9.setText("Id Setor:");

        cxSetor.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        cxSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxSetorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCriarFuncionario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxIdade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cxNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 30, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(85, 85, 85))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cxSalario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cxSetor)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cxIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cxSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarFuncionario)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cxNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxNomeActionPerformed

    private void cxGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxGeneroActionPerformed
        
    }//GEN-LAST:event_cxGeneroActionPerformed

    private void btnCriarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarFuncionarioActionPerformed
        criarFarmacia();
    }//GEN-LAST:event_btnCriarFuncionarioActionPerformed

    private void cxSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxSalarioActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        fechaAtual();
        FuncionariosGUI funcionarios = new FuncionariosGUI();
        funcionarios.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cxSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxSetorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxSetorActionPerformed

    public void fechaAtual(){
        this.dispose();
    }
    
    public void criarFarmacia(){
        String generoSelecionado = (String) cxGenero.getSelectedItem();
        FuncionarioCtrl funcionarioCtrl = new FuncionarioCtrl();
        
        if(funcionarioCtrl.cadastrar(cxNome.getText(), cxIdade.getText(), generoSelecionado, cxSalario.getText(), cxSetor.getText())){
            System.out.println("Funcionario cadastrado");
            this.dispose();
        }
    }
   
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarFuncionarioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarFuncionario;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cxGenero;
    private javax.swing.JTextField cxIdade;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxSalario;
    private javax.swing.JTextField cxSetor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSetores;
    // End of variables declaration//GEN-END:variables

}
