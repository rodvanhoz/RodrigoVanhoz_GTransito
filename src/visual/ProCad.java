package visual;

import javax.swing.*;
import modelo.*;
import java.sql.*;

public class ProCad extends javax.swing.JDialog {

    private MySQL ProSQL;
    private javax.swing.JFrame parentFrame;
    private Logradouros Logradouro = new Logradouros();

    public ProCad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ProCad(javax.swing.JFrame parentFrame, MySQL ProSQL) {
        
        initComponents();

        this.parentFrame = parentFrame;
        this.ProSQL      = ProSQL;
        this.getRootPane().setDefaultButton(jBTconfirma);

        jLcepencontrado.setVisible(false);
    }

    public void Logradouro2visual(){

      if (Logradouro.getcodlog() != -1) {
        jTFcodlog.setText  ( Logradouro.getcodlogstr() );
        jTFendereco.setText( Logradouro.getdescr()     );
        jTFbairro.setText  ( Logradouro.getbairro()    );
        jTFcep.setText     ( Logradouro.getcep()       );
        jTFcidade.setText  ( Logradouro.getcidade()    );
      }
    }

    private void KeyReleased(java.awt.event.KeyEvent evt){
        JTextField TF = (JTextField) evt.getComponent();
        if (evt.getKeyCode()!=32 & evt.getKeyCode()!=8 & evt.getKeyCode()!=37 & evt.getKeyCode()!=39)
            TF.setText(TF.getText().toUpperCase());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlNome = new javax.swing.JLabel();
        jTFnome = new javax.swing.JTextField();
        jBTconfirma = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jTFendereco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTFnumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTFtelefone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFemail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jTFbairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFcep = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFcidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jBTNprocuralog = new javax.swing.JButton();
        jTFcodlog = new javax.swing.JTextField();
        jTFidentidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLcepencontrado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jlNome.setText("Nome:");

        jTFnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFnomeKeyReleased(evt);
            }
        });

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

        jTFendereco.setEnabled(false);

        jLabel1.setText("Endereço:");

        jLabel2.setText("Número:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("E-mail:");

        jTFemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFemailKeyReleased(evt);
            }
        });

        jTFbairro.setEnabled(false);

        jLabel5.setText("Bairro:");

        jTFcep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFcepFocusLost(evt);
            }
        });

        jLabel6.setText("CEP:");

        jTFcidade.setEnabled(false);

        jLabel7.setText("Cidade:");

        jBTNprocuralog.setText("...");
        jBTNprocuralog.setFocusable(false);
        jBTNprocuralog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNprocuralogActionPerformed(evt);
            }
        });

        jTFcodlog.setEnabled(false);

        jLabel8.setText("Identidade:");

        jLcepencontrado.setText("não encontrado...");
        jLcepencontrado.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(366, Short.MAX_VALUE)
                .addComponent(jBTconfirma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTFemail, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel4)))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFidentidade, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(120, 120, 120))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTFtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFcodlog, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLcepencontrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTFcep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBTNprocuralog, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFnome, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                            .addComponent(jlNome))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTFbairro, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFendereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTFnumero)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLcepencontrado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTNprocuralog, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFcodlog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFidentidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFemail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBTconfirma)
                    .addComponent(btnCancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBTconfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTconfirmaActionPerformed

        try {

            ProSQL.abrebanco();
            String sql = "INSERT INTO proprietario (nome,identidade,codlog,numero,telefone,email) VALUES (?,?,?,?,?,?)";

            PreparedStatement stmt = ProSQL.connection.prepareStatement(sql);
            
            stmt.setString(1, jTFnome.getText()       );
            stmt.setString(2, jTFidentidade.getText() );
            stmt.setString(3, jTFcodlog.getText()     );
            stmt.setString(4, jTFnumero.getText()     );
            stmt.setString(5, jTFtelefone.getText()   );
            stmt.setString(6, jTFemail.getText()      );

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

    private void jTFcepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFcepFocusLost

        LogNaveg lognaveg = new LogNaveg( parentFrame );
        lognaveg.LogSQL.abrebanco();
        String SQL = "SELECT COUNT(*) as nro,codlog,descr,bairro,cep,cidade FROM LOGRADOURO where cep="+jTFcep.getText();
        ResultSet rs = lognaveg.LogSQL.consultar(SQL);
        try{
          rs.first();
          if ( rs.getInt("nro") != 0 ){

            jTFcodlog.setText   (Integer.toString(rs.getInt("codlog"))   );
            jTFendereco.setText (                 rs.getString("descr")  );
            jTFbairro.setText   (                 rs.getString("bairro") );
            jTFcidade.setText   (                 rs.getString("cidade") );

            jLcepencontrado.setVisible(false);
            jTFnumero.requestFocus();

          } else {

              jTFcep.requestFocus();
              jLcepencontrado.setVisible(true);
              
          }
            
        } catch (SQLException exception){

          exception.printStackTrace();
      }
    }//GEN-LAST:event_jTFcepFocusLost

    private void jBTNprocuralogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNprocuralogActionPerformed

        this.setVisible(false);

        LogNaveg lognaveg = new LogNaveg( this, Logradouro );
        parentFrame.getContentPane().add( lognaveg );
        parentFrame.repaint();
        lognaveg.moveToFront();
        jTFnumero.requestFocus();

    }//GEN-LAST:event_jBTNprocuralogActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        Logradouro2visual();
    }//GEN-LAST:event_formWindowActivated

    private void jTFnomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFnomeKeyReleased
        KeyReleased(evt);
    }//GEN-LAST:event_jTFnomeKeyReleased

    private void jTFemailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFemailKeyReleased
        KeyReleased(evt);
    }//GEN-LAST:event_jTFemailKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProCad dialog = new ProCad(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBTNprocuralog;
    private javax.swing.JButton jBTconfirma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLcepencontrado;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFbairro;
    private javax.swing.JTextField jTFcep;
    private javax.swing.JTextField jTFcidade;
    private javax.swing.JTextField jTFcodlog;
    private javax.swing.JTextField jTFemail;
    private javax.swing.JTextField jTFendereco;
    private javax.swing.JTextField jTFidentidade;
    private javax.swing.JTextField jTFnome;
    private javax.swing.JTextField jTFnumero;
    private javax.swing.JTextField jTFtelefone;
    private javax.swing.JLabel jlNome;
    // End of variables declaration//GEN-END:variables

}



