/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.MySQL;
import modelo.Proprietarios;

/**
 *
 * @author Rodrigo Vanhoz
 */
public class MulNavegve extends javax.swing.JFrame {

    /**
     * Creates new form MulNaveg
     */
    private MySQL SQL;
    private ResultSet RS;
    private DefaultTableModel MODEL;
    private javax.swing.JFrame parentFrame;
    private javax.swing.JDialog parentDialog;
    private Proprietarios Proprietario;
    
    public MulNavegve() {
        initComponents();
        this.parentFrame = null;
        
        setSize(800,600);
        setVisible(true);
        setLocation((parentFrame.getWidth() - this.getWidth())/2,
                    (parentFrame.getHeight()- this.getHeight())/2);

        SQL.abrebanco();

        Navegador();
        Atualiza();
        
    }

    public MulNavegve(javax.swing.JFrame parentFrame) {
        initComponents();
        //this.parentFrame = parentFrame;
        
        setSize(800,600);
        setVisible(true);
        setLocation((parentFrame.getWidth() - this.getWidth())/2,
                    (parentFrame.getHeight()- this.getHeight())/2);

        SQL.abrebanco();

        Navegador();
        Atualiza();
        
    }
    
    private void Navegador() {
      MODEL = new DefaultTableModel(new String[]{ "Código", "Nome Proprietário","Desc. Veículo","Data","Pontuação","Grau Infração" },SQL.tamanho()) {
           public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
      };
      jtNavegador.setModel(MODEL);
      jtNavegador.setShowGrid(false);

      jtNavegador.getColumnModel().getColumn(0).setMaxWidth(90);  // código
      jtNavegador.getColumnModel().getColumn(1).setMaxWidth(400); // nome prop.
      jtNavegador.getColumnModel().getColumn(2).setMaxWidth(400); // desc. vei.
      jtNavegador.getColumnModel().getColumn(3).setMaxWidth(180); // data
      jtNavegador.getColumnModel().getColumn(4).setMaxWidth(120); // pontuação
      jtNavegador.getColumnModel().getColumn(5).setMaxWidth(180); // grau inf.
      
    }

    public void Atualiza(){

      if (SQL.tamanho() != 0) {

        RS = SQL.consultar();
        try {

          LimpaNavegador();

          int i = 0;

          RS.first();
          do {
            MODEL.insertRow(i,new Object[] {
              Integer.toString(RS.getInt   ("codigo")),
                               RS.getString("descr"  ),
              Double.toString( RS.getDouble("Chassi"))});
            i+=1;
          } while ( RS.next() );        
        }
        catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }
    
    private void LimpaNavegador(){
      
      int tam = MODEL.getRowCount();
      for (int j=0; j<tam;j++) MODEL.removeRow(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtNavegador = new javax.swing.JTable();
        jbtnIncluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtnExcluir.setText("Excluir");
        jbtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExcluirActionPerformed(evt);
            }
        });

        jtNavegador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtNavegador.setFillsViewportHeight(true);
        jtNavegador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtNavegadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtNavegador);

        jbtnIncluir.setText("Incluir");
        jbtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIncluirActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jbtnIncluir)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jbtnExcluir)
                .addContainerGap(270, Short.MAX_VALUE))
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnIncluir)
                    .add(jbtnExcluir))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirActionPerformed
        try {
            String sql = "DELETE FROM MULTA WHERE CODIGO=?";
            PreparedStatement stmt = SQL.connection.prepareStatement(sql);
            String strcod = ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),0));
            stmt.setString(1, strcod);
            int result = stmt.executeUpdate();
            String mens;
            if (result != 1) {
                mens = "Proprietario não cadastrado!";
                JOptionPane.showMessageDialog(null, mens);
            } else ((DefaultTableModel)jtNavegador.getModel()).removeRow(jtNavegador.getSelectedRow());
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }//GEN-LAST:event_jbtnExcluirActionPerformed

    private void jtNavegadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtNavegadorMouseClicked
         this.dispose();
    }//GEN-LAST:event_jtNavegadorMouseClicked

    private void jbtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIncluirActionPerformed
        visual.MulCad mul_gui = new MulCad(parentFrame, true);
        mul_gui.setTitle("Cadastro de Multas");
        mul_gui.setAlwaysOnTop(true);
        mul_gui.pack();
        mul_gui.show();
        Atualiza();
    }//GEN-LAST:event_jbtnIncluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MulNavegve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MulNavegve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MulNavegve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MulNavegve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MulNavegve().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnExcluir;
    private javax.swing.JButton jbtnIncluir;
    private javax.swing.JTable jtNavegador;
    // End of variables declaration//GEN-END:variables
}
