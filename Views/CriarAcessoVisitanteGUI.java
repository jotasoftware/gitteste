package Views;
import Models.*;
import java.time.*;
import Controllers.Sessao;
import Controllers.VisitanteCtrl;
import javax.swing.JOptionPane;

public class CriarAcessoVisitanteGUI extends javax.swing.JFrame {

    public CriarAcessoVisitanteGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cxApto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnCriarAcessoVisitante = new javax.swing.JButton();
        calendarAcesso = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("SOLICITAR ACESSO");

        jLabel3.setText("Apartamento:");

        cxApto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxAptoActionPerformed(evt);
            }
        });

        jLabel6.setText("Data:");

        btnCriarAcessoVisitante.setText("Solicitar Acesso");
        btnCriarAcessoVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarAcessoVisitanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(130, 130, 130))
                        .addComponent(calendarAcesso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCriarAcessoVisitante, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cxApto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cxApto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendarAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriarAcessoVisitante)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cxAptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxAptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxAptoActionPerformed

    private void btnCriarAcessoVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarAcessoVisitanteActionPerformed
        
        java.util.Date utilDataAcesso = calendarAcesso.getDate();
        LocalDate dataAcesso = utilDataAcesso.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        VisitanteCtrl visitanteCtrl = new VisitanteCtrl();

        visitanteCtrl.solicitarAcesso(Sessao.getCpfUsuarioLogado(), cxApto.getText(), dataAcesso);

        Visitante visitante = new Visitante();
        visitante.setData(dataAcesso);
        visitante.setCpf(Sessao.getCpfUsuarioLogado());
        
        fechaAtual();
    }//GEN-LAST:event_btnCriarAcessoVisitanteActionPerformed

    public void fechaAtual(){
        this.dispose();
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarAcessoVisitanteGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarAcessoVisitante;
    private com.toedter.calendar.JCalendar calendarAcesso;
    private javax.swing.JTextField cxApto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

}
