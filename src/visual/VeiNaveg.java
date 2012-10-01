package visual;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import modelo.*;

public class VeiNaveg extends javax.swing.JInternalFrame {

    private ResultSet RS;
    private DefaultTableModel MODEL;
    private Veiculos vei = new Veiculos();
    JFrame  parentFrame;
    JDialog parentDialog;

    public MySQL VeiSQL = new MySQL("VEICULO");

    public VeiNaveg(javax.swing.JFrame parentFrame) {

        initComponents();
        setSize(800,600);
        setVisible(true);
        setLocation( (parentFrame.getWidth() - this.getWidth()  )/2,
                     (parentFrame.getHeight()- this.getHeight() )/2 );

        VeiSQL.abrebanco();
        
        this.parentFrame = parentFrame;

        Navegador();
        Atualiza();
    }

    public VeiNaveg(Veiculos vei, JFrame parentFrame) {
        initComponents();
        setSize(800,600);
        setVisible(true);
        setLocation( (parentFrame.getWidth() - this.getWidth()  )/2,
                     (parentFrame.getHeight()- this.getHeight() )/2 );

        VeiSQL.abrebanco();
        
        this.parentFrame = parentFrame;
        this.vei = vei;

        Navegador();
        Atualiza();
    }
    
    public VeiNaveg(Veiculos vei, JDialog parentDialog) {
        initComponents();
        setSize(800,600);
        setVisible(true);

        VeiSQL.abrebanco();
        
        this.parentDialog = parentDialog;
        this.vei = vei;

        Navegador();
        Atualiza();
    }
    

    private void Navegador(){

      RS    = VeiSQL.consultar();

      MODEL = new DefaultTableModel(new String[]{ "Código", "Descrição", "Chassi", "Proprietario" },VeiSQL.tamanho()) {
           public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
           }
      };

      jtNavegador.setModel(MODEL);
      jtNavegador.setShowGrid(false);
      jtNavegador.getColumnModel().getColumn(0).setMaxWidth(60);
    }

    private void LimpaNavegador(){

      int tam = MODEL.getRowCount();      
      for (int j=0; j<tam;j++) MODEL.removeRow(0);
    }

    public void Atualiza(){

      if (VeiSQL.tamanho() != 0) {

        String linhaSQL = "SELECT pro.nome as nome, pro.codigo as codpro," +
                          "vei.descr as descr, vei.codpro as codpro," +
                          "vei.chassi as chassi, vei.codigo as codvei " +
                          "FROM PROPRIETARIO pro, VEICULO vei " +
                          "WHERE pro.codigo = vei.codpro";
        
        RS = VeiSQL.consultar(linhaSQL);
        try {

          LimpaNavegador();

          int i = 0;

          RS.first();
          do {
            MODEL.insertRow(i,new Object[] {
              Integer.toString(RS.getInt   ("codvei")),
                               RS.getString("descr"  ),
              Double.toString (RS.getDouble("Chassi")),
                               RS.getString("nome")});
            i+=1;
          } while ( RS.next() );        
        }
        catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnIncluir = new javax.swing.JButton();
        jbtnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtNavegador = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Veículos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jbtnIncluir.setText("Incluir");
        jbtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIncluirActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jbtnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExcluir)
                .addContainerGap(264, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnIncluir)
                    .addComponent(jbtnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIncluirActionPerformed
        VeiCad veicad = new VeiCad(parentFrame, VeiSQL);
        veicad.setTitle("Cadastro de Veículos");
        veicad.setAlwaysOnTop(true);
        veicad.pack();
        veicad.show(true);
        Atualiza();
}//GEN-LAST:event_jbtnIncluirActionPerformed

    private void jbtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirActionPerformed

        try {
            String sql = "DELETE FROM VEICULO WHERE CODIGO=?";
            PreparedStatement stmt = VeiSQL.connection.prepareStatement(sql);
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
        if ( evt.getClickCount() == 2 ) {
            String criaRow = ( (String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(), 0));
            
            vei.setCodigo(Integer.parseInt(criaRow));
            vei.setDescr   ((String) jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(), 1));
            
            criaRow = ((String) jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(), 2) );
            vei.setChassi  (Double.parseDouble(criaRow));
            
            vei.setNomeProp((String) jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(), 3));
            
            this.dispose();
        }
    }//GEN-LAST:event_jtNavegadorMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       parentDialog.setVisible(true);
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnExcluir;
    private javax.swing.JButton jbtnIncluir;
    private javax.swing.JTable jtNavegador;
    // End of variables declaration//GEN-END:variables

}
