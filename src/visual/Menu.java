package visual;

import java.awt.ComponentOrientation;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends javax.swing.JFrame {

    public ProNaveg pronaveg;
    public VeiNaveg veinaveg;
    public MulNaveg mulnaveg;
    
    private GestorNavegadores GN;
    private JDesktopPane desktop = new JDesktopPane();

    public Menu() {
        initComponents();

        setSize(800,600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(desktop);
        GN = new GestorNavegadores();
        addWindowListener( GN );                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmProNaveg = new javax.swing.JMenuItem();
        jmVeiNaveg = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor de Trânsito");
        setMinimumSize(new java.awt.Dimension(400, 300));

        jMenu1.setText("Cadastros");

        jmProNaveg.setText("Proprietário");
        jmProNaveg.setRequestFocusEnabled(false);
        jmProNaveg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProNavegActionPerformed(evt);
            }
        });
        jMenu1.add(jmProNaveg);

        jmVeiNaveg.setText("Veículos");
        jmVeiNaveg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmVeiNavegActionPerformed(evt);
            }
        });
        jMenu1.add(jmVeiNaveg);

        jMenuItem1.setText("Multa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jmSair.setText("Sair");
        jmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSairActionPerformed(evt);
            }
        });
        jMenu1.add(jmSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSairActionPerformed
      System.exit(0);
    }//GEN-LAST:event_jmSairActionPerformed

    private void jmProNavegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProNavegActionPerformed

        pronaveg = new ProNaveg(this);               
        desktop.add( pronaveg );
        desktop.setOpaque(false);
        
        pronaveg.moveToFront();
        repaint();

        GN.GestorPro( pronaveg );
    }//GEN-LAST:event_jmProNavegActionPerformed

    private void jmVeiNavegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmVeiNavegActionPerformed

        veinaveg = new VeiNaveg(this);        
        desktop.add( veinaveg );
        desktop.setOpaque(false);                        
        veinaveg.moveToFront();
        repaint();

        GN.GestorVei( veinaveg );
    }//GEN-LAST:event_jmVeiNavegActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        mulnaveg = new MulNaveg(this);
        desktop.add(mulnaveg);
        desktop.setOpaque(false);
        mulnaveg.moveToFront();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jmProNaveg;
    private javax.swing.JMenuItem jmSair;
    private javax.swing.JMenuItem jmVeiNaveg;
    // End of variables declaration//GEN-END:variables

}

class GestorNavegadores extends WindowAdapter {

  ProNaveg pronaveg;
  VeiNaveg veinaveg;

  public GestorNavegadores( ){
      
      this.pronaveg = null;
      this.veinaveg = null;
  }
  
  public void GestorPro(ProNaveg pronaveg) {

    this.pronaveg = pronaveg;    
    
  }

  public void GestorVei(VeiNaveg veinaveg) {

    this.veinaveg = veinaveg;
  }

  @Override
  public void windowActivated(WindowEvent e) {
    
    if (pronaveg != null)
        pronaveg.Atualiza();
    if (veinaveg != null)
        veinaveg.Atualiza();
    

  }
}
