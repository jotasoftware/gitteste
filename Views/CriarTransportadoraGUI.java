package Views;
import Controllers.SindicoCtrl;

public class CriarTransportadoraGUI extends javax.swing.JFrame {

    public CriarTransportadoraGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cxCPF = new javax.swing.JTextField();
        btnCriarTransportadora = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("CRIAR TRANSPORTADORA");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Nome:");

        cxCPF.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        cxCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxCPFActionPerformed(evt);
            }
        });

        btnCriarTransportadora.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnCriarTransportadora.setText("Criar Transportadora");
        btnCriarTransportadora.setToolTipText("");
        btnCriarTransportadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarTransportadoraActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnVoltar.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCriarTransportadora))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 85, Short.MAX_VALUE))
                            .addComponent(cxCPF))))
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
                    .addComponent(cxCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarTransportadora)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cxCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxCPFActionPerformed

    private void btnCriarTransportadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarTransportadoraActionPerformed
        if(criarFuncionario()){
            fechaAtual();
            abreHomeSindico();
        }
    }//GEN-LAST:event_btnCriarTransportadoraActionPerformed

    public void fechaAtual(){
        this.dispose();
    }
    
    public void abreHomeSindico(){
        HomeSindicoGUI abreHomeSindico = new HomeSindicoGUI();
        abreHomeSindico.setVisible(true); 
    }
    
    public boolean criarFuncionario(){
        String turno = (String) cxGenero.getSelectedItem();
        SindicoCtrl sindicoCtrl = new SindicoCtrl();
        return sindicoCtrl.criarFuncionario(cxCPF.getText(), cxFuncao.getText(), turno);
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarTransportadoraGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarTransportadora;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cxCPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
