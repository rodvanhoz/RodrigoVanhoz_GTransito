package visual;

import java.awt.Frame;
import javax.swing.*;
import modelo.*;
import java.sql.*;

public class VeiCad extends javax.swing.JDialog {

    private MySQL VeiSQL;
    private javax.swing.JFrame parentFrame;
    private Proprietarios Proprietario = new Proprietarios();
    
    public VeiCad(JFrame frame,boolean modal) {
        super(frame,modal);
    }

    public VeiCad(MySQL VeiSQL) {
        initComponents();
        this.VeiSQL = VeiSQL;
    }

    public VeiCad(JFrame parent, MySQL VeiSQL) {
        this(VeiSQL);
        this.parentFrame = parent;
    }
    
    public void propInlcui( ) {
        if ( Proprietario.getCodigo() != -1 ) {
            jlCodigo.setText(String.valueOf(Proprietario.getCodigo()));
            jtfProp.setText(Proprietario.getNome());
            jlEmail.setText(Proprietario.getEmail());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jlNome = new javax.swing.JLabel();
        jtfDescr = new javax.swing.JTextField();
        jBTconfirma = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jlChassi = new javax.swing.JLabel();
        jtfChassi = new javax.swing.JTextField();
        jtfProp = new javax.swing.JTextField();
        jlProp = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jlEmail = new javax.swing.JLabel();
        jlCodigo = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jlNome.setText("Descrição");

        jBTconfirma.setText("Confirmar");
        jBTconfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTconfirmaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jlChassi.setText("Chassi");

        jtfProp.setEditable(false);

        jlProp.setText("Proprietário ID:");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBTconfirma)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlNome)
                                .addComponent(jtfDescr, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(jlChassi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfChassi)
                                .addComponent(jtfProp))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jlProp)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDescr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlChassi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlProp)
                    .addComponent(jlCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jlEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBTconfirma)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBTconfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTconfirmaActionPerformed

        try {

            VeiSQL.abrebanco();
            String sql = "INSERT INTO veiculo (descr,chassi,codpro) VALUES (?,?,?)";

            PreparedStatement stmt = VeiSQL.connection.prepareStatement(sql);
            
            stmt.setString(1, jtfDescr.getText()            );
            stmt.setDouble(2, Double.parseDouble(jlChassi.getText()) );
            stmt.setInt   (3, Integer.parseInt(jlCodigo.getText())             );

            int result = stmt.executeUpdate();
            String mens;
            if (result != 1) {
                mens = "Proprietario não cadastrado!";
                JOptionPane.showMessageDialog(null, mens);
            }

        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            this.dispose();
        }
}//GEN-LAST:event_jBTconfirmaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        this.setVisible(false);
        
        ProNaveg proNaveg = new ProNaveg(this, Proprietario);
        parentFrame.getContentPane().add( proNaveg );
        parentFrame.repaint();
        proNaveg.moveToFront();
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        propInlcui();
    }//GEN-LAST:event_formWindowActivated

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VeiCad dialog = new VeiCad(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton jBTconfirma;
    private javax.swing.JButton jButton1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel jlChassi;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlProp;
    private javax.swing.JTextField jtfChassi;
    private javax.swing.JTextField jtfDescr;
    private javax.swing.JTextField jtfProp;
    // End of variables declaration//GEN-END:variables

}
