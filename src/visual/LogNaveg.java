package visual;

import javax.swing.table.*;
import java.sql.*;
import modelo.*;

public class LogNaveg extends javax.swing.JInternalFrame {

    public MySQL LogSQL = new MySQL("LOGRADOURO");

    private ResultSet RS;
    private DefaultTableModel MODEL;
    private javax.swing.JDialog parentDialog;
    private Logradouros Logradouro;

    public LogNaveg(javax.swing.JFrame parentFrame) {

        initComponents();

        setSize(800,600);
        setVisible(true);
        setLocation((parentFrame.getWidth() - this.getWidth())/2,
                    (parentFrame.getHeight()- this.getHeight())/2);

        LogSQL.abrebanco();

        Navegador();
        Atualiza();
    }

        public LogNaveg(javax.swing.JDialog parentDialog, Logradouros Logradouro) {

        initComponents();

        this.parentDialog = parentDialog;
        this.Logradouro   = Logradouro;
        this.setSize(800,600);
        this.setVisible(true);

        LogSQL.abrebanco();

        Navegador();
        Atualiza();

    }

   private void Navegador(){

      RS    = LogSQL.consultar();
      MODEL = new DefaultTableModel(new String[]{ "Código", "Endereço","Bairro","CEP","Cidade" },LogSQL.tamanho()){
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

      jtNavegador.setModel(MODEL);
      jtNavegador.setShowGrid(false);
      //jtNavegador.setAutoResizeMode(0);

      jtNavegador.getColumnModel().getColumn(0).setMaxWidth(90);  //codigo
      jtNavegador.getColumnModel().getColumn(1).setMaxWidth(400); //Endereço
      jtNavegador.getColumnModel().getColumn(2).setMaxWidth(300); //Bairro
      jtNavegador.getColumnModel().getColumn(3).setMaxWidth(60);  //CEP
      jtNavegador.getColumnModel().getColumn(4).setMaxWidth(200); //Cidade

      jtNavegador.getColumnModel().getColumn(0).setWidth(90);  //Código
      jtNavegador.getColumnModel().getColumn(1).setWidth(400); //Endereço
      jtNavegador.getColumnModel().getColumn(2).setWidth(300); //Bairro
      jtNavegador.getColumnModel().getColumn(3).setWidth(60);  //CEP
      jtNavegador.getColumnModel().getColumn(4).setWidth(200); //Cidade
    }

    private void limpaNavegador(){

      int tam = MODEL.getRowCount();
      for (int j=0; j<tam;j++) MODEL.removeRow(0);
    }

    public void Atualiza(){

      int tam = LogSQL.tamanho();

      if (tam != 0) {

        limpaNavegador();

        RS = LogSQL.consultar();
        try {
          int i = 0;
          RS.first();
          do {
            MODEL.insertRow(i,new Object[] {
              Integer.toString(RS.getInt   ("codlog")),
                               RS.getString("descr"),
                               RS.getString("bairro"),
                               RS.getString("cep"),
                               RS.getString("cidade"),


            });
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
        setTitle("Cadastro de Logradouros");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                logNavegClosed(evt);
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
            .addGap(0, 394, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jbtnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExcluir)
                .addContainerGap(264, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnIncluir)
                    .addComponent(jbtnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIncluirActionPerformed
}//GEN-LAST:event_jbtnIncluirActionPerformed

    private void jbtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirActionPerformed
}//GEN-LAST:event_jbtnExcluirActionPerformed

    private void logNavegClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_logNavegClosed
      parentDialog.setVisible(true);      
    }//GEN-LAST:event_logNavegClosed

    private void jtNavegadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtNavegadorMouseClicked
      if (evt.getClickCount() == 2) {

          String strcod = ( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),0)) );
          Logradouro.setcodlog( Integer.parseInt(strcod) );
          Logradouro.setdescr ( ((String) jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),1)) );
          Logradouro.setbairro( ((String) jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),2)) );
          Logradouro.setcep   ( ((String) jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),3)) );
          Logradouro.setcidade( ((String) jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),4)) );

          this.dispose();

          
      }

    }//GEN-LAST:event_jtNavegadorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnExcluir;
    private javax.swing.JButton jbtnIncluir;
    private javax.swing.JTable jtNavegador;
    // End of variables declaration//GEN-END:variables

}
