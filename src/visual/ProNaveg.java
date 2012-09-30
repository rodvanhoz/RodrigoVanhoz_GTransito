package visual;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import modelo.*;

public class ProNaveg extends javax.swing.JInternalFrame {

    private ResultSet RS;
    private DefaultTableModel MODEL;
    private javax.swing.JFrame parentFrame;
    private javax.swing.JDialog parentDialog;
    private Proprietarios Proprietario;

    public MySQL ProSQL = new MySQL("PROPRIETARIO");

    public ProNaveg(javax.swing.JFrame parentFrame) {

        initComponents();

        this.parentFrame = parentFrame;
        
        setSize(800,600);
        setVisible(true);
        setLocation((parentFrame.getWidth() - this.getWidth())/2,
                    (parentFrame.getHeight()- this.getHeight())/2);

        ProSQL.abrebanco();

        Navegador();
        Atualiza();
    }

    public ProNaveg(javax.swing.JDialog parentDialog, Proprietarios Proprietario ) {

        initComponents();

        this.parentDialog = parentDialog;
        this.Proprietario   = Proprietario;
        this.setSize(800,600);
        this.setVisible(true);

        ProSQL.abrebanco();

        Navegador();
        Atualiza();

    }


    private void Navegador(){

      MODEL = new DefaultTableModel(new String[]{ "Código", "Nome","Identidade","Endereço","Número","CEP","Bairro","Cidade","Telefone","Email" },ProSQL.tamanho()) {
           public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
      };
      jtNavegador.setModel(MODEL);
      jtNavegador.setShowGrid(false);

      jtNavegador.getColumnModel().getColumn(0).setMaxWidth(90);  //codigo
      jtNavegador.getColumnModel().getColumn(1).setMaxWidth(400); //nome
      jtNavegador.getColumnModel().getColumn(2).setMaxWidth(100); //identidade
      jtNavegador.getColumnModel().getColumn(3).setMaxWidth(300); //endereco
      jtNavegador.getColumnModel().getColumn(4).setMaxWidth(60); //numero
      jtNavegador.getColumnModel().getColumn(5).setMaxWidth(80); //cep
      jtNavegador.getColumnModel().getColumn(6).setMaxWidth(100); //bairro
      jtNavegador.getColumnModel().getColumn(7).setMaxWidth(150); //cidade
      jtNavegador.getColumnModel().getColumn(8).setMaxWidth(80); //telefone
      jtNavegador.getColumnModel().getColumn(9).setMaxWidth(300); //email
      
      jtNavegador.getColumnModel().getColumn(0).setWidth(90);  //0 codigo
      jtNavegador.getColumnModel().getColumn(1).setWidth(400); //1 nome
      jtNavegador.getColumnModel().getColumn(2).setWidth(100); //2 identidade
      jtNavegador.getColumnModel().getColumn(3).setWidth(300); //3 endereco
      jtNavegador.getColumnModel().getColumn(4).setWidth(60); //4 numero
      jtNavegador.getColumnModel().getColumn(5).setWidth(80); //5 cep
      jtNavegador.getColumnModel().getColumn(6).setWidth(100); //6 bairro
      jtNavegador.getColumnModel().getColumn(7).setWidth(150); //7 cidade
      jtNavegador.getColumnModel().getColumn(8).setWidth(80); //8 telefone
      jtNavegador.getColumnModel().getColumn(9).setWidth(300); //9 email
    }

    private void limpaNavegador(){
      
      int tam = MODEL.getRowCount();
      for (int j=0; j<tam;j++) MODEL.removeRow(0);
    }

    public void Atualiza(){

      int tam = ProSQL.tamanho();
      
      if (tam != 0) {

        limpaNavegador();
        
        String strsql;
        strsql =           "SELECT pro.codigo as codigo, pro.nome as nome, pro.identidade as identidade,        ";
        strsql = strsql +  "logr.descr as endereco,pro.numero as numero, logr.cep as cep, logr.bairro as bairro,";
        strsql = strsql +  "logr.cidade as cidade, pro.telefone as telefone, pro.email as email                 ";
        strsql = strsql +  "FROM PROPRIETARIO pro, LOGRADOURO logr WHERE pro.codlog = logr.codlog               ";

        RS = ProSQL.consultar( strsql );
        try {
          int i = 0;
          RS.first();
          do {            
            MODEL.insertRow(i,new Object[] {
              Integer.toString(RS.getInt   ("codigo")),
                               RS.getString("nome"),
                               RS.getString("identidade"),
                               RS.getString("endereco"),
                               RS.getString("numero"),
                               RS.getString("cep"),
                               RS.getString("bairro"),
                               RS.getString("cidade"),
                               RS.getString("telefone"),
                               RS.getString("email"),


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
        setTitle("Proprietários");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
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
                .addContainerGap(429, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnIncluir)
                    .addComponent(jbtnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirActionPerformed
        try {
            String sql = "DELETE FROM PROPRIETARIO WHERE CODIGO=?";
            PreparedStatement stmt = ProSQL.connection.prepareStatement(sql);
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

    private void jbtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIncluirActionPerformed
        visual.ProCad pro_gui = new ProCad(parentFrame,ProSQL);
        pro_gui.setTitle("Cadastro de Proprietários");
        pro_gui.setAlwaysOnTop(true);
        pro_gui.pack();
        pro_gui.show();
        Atualiza();
    }//GEN-LAST:event_jbtnIncluirActionPerformed

    private void jtNavegadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtNavegadorMouseClicked
      if (evt.getClickCount() == 2) {

          String strcod = ( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),0)) );
          Proprietario.setCodigo( Integer.parseInt(strcod) );
          Proprietario.setNome( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),1)) );
          Proprietario.setIdentidade( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),2)) );
          Proprietario.setEndereco( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),3)) );
          Proprietario.setNumero( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),4)) );
          Proprietario.setCep( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),5)) );
          Proprietario.setBairro( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),6)) );
          Proprietario.setCidade( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),7)) );
          Proprietario.setTelefone( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),8)) );
          Proprietario.setEmail( ((String)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),9)) );

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