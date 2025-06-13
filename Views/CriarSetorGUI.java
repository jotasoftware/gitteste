package Views;
import Controllers.SetorCtrl;
import javax.swing.JOptionPane;

public class CriarSetorGUI extends javax.swing.JFrame {

    public CriarSetorGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cxNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cxValeAlimentacao = new javax.swing.JTextField();
        btnCriarSetor = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        cxValeRefeicao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cxPlanoDeSaude = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cxValeTransporte = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cxPlanoOdontologico = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("CRIAR SETOR");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Nome:");

        cxNome.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        cxNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxNomeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel6.setText("Vale alimentação:");

        cxValeAlimentacao.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        btnCriarSetor.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnCriarSetor.setText("Criar Setor");
        btnCriarSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarSetorActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnVoltar.setText("Voltar");

        cxValeRefeicao.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel9.setText("Vale refeição:");

        cxPlanoDeSaude.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        cxPlanoDeSaude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxPlanoDeSaudeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel10.setText("Plano de Saude:");

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel11.setText("Vale transporte:");

        cxValeTransporte.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel12.setText("Plano de Odontologico:");

        cxPlanoOdontologico.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        cxPlanoOdontologico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxPlanoOdontologicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVoltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCriarSetor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cxNome))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cxValeTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cxPlanoDeSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cxValeAlimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cxValeRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 174, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cxPlanoOdontologico, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxValeAlimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxValeRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxValeTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxPlanoDeSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxPlanoOdontologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarSetor)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cxNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxNomeActionPerformed

    private void btnCriarSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarSetorActionPerformed
        criarProduto();
    }//GEN-LAST:event_btnCriarSetorActionPerformed

    private void cxPlanoDeSaudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxPlanoDeSaudeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxPlanoDeSaudeActionPerformed

    private void cxPlanoOdontologicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxPlanoOdontologicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxPlanoOdontologicoActionPerformed

    public void fechaAtual(){
        this.dispose();
    }
        
    public void criarProduto(){
        SetorCtrl setorCtrl = new SetorCtrl();
        
        String nome = cxNome.getText();
        String valeTransporte = cxValeTransporte.getText().trim();
        String valeRefeicao = cxValeRefeicao.getText().trim();
        String valeAlimentacao = cxValeAlimentacao.getText().trim();
        String planoDeSaude = cxPlanoDeSaude.getText().trim();
        String planoOdontologico = cxPlanoOdontologico.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Nome é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (valeTransporte.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Vale Transporte é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (valeRefeicao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Vale Refeição é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (valeAlimentacao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Vale Alimentação é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (planoDeSaude.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Plano de Saúde é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (planoOdontologico.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Plano Odontologico é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(setorCtrl.cadastrarSetor(nome, valeTransporte, valeRefeicao, valeAlimentacao, planoDeSaude, planoOdontologico)){
            JOptionPane.showMessageDialog(this, "Setor cadastrado.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            FuncionariosGUI funcionarios = new FuncionariosGUI();
            funcionarios.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Dados Invalidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarSetorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarSetor;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxPlanoDeSaude;
    private javax.swing.JTextField cxPlanoOdontologico;
    private javax.swing.JTextField cxValeAlimentacao;
    private javax.swing.JTextField cxValeRefeicao;
    private javax.swing.JTextField cxValeTransporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}
