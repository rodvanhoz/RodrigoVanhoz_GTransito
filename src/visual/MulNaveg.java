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
public class MulNaveg extends javax.swing.JInternalFrame {

    /**
     * Creates new form MulNagev
     */
    private MySQL SQL = new MySQL("MULTA");
    private ResultSet RS;
    private DefaultTableModel MODEL;
    private javax.swing.JFrame parentFrame;
    private javax.swing.JDialog parentDialog;
    private Proprietarios Proprietario;
    
    public MulNaveg() {
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

    public MulNaveg(javax.swing.JFrame parentFrame) {
        initComponents();
        this.parentFrame = parentFrame;
        
        setSize(800,600);
        setVisible(true);
        setLocation((parentFrame.getWidth() - this.getWidth())/2,
                    (parentFrame.getHeight()- this.getHeight())/2);

        SQL.abrebanco();

        Navegador();
        Atualiza();
        
    }

    private void Navegador() {
      MODEL = new DefaultTableModel(new String[]{ "Id Multa","Id Prop.", "Nome Proprietário","Id Veiculo","Veículo","Data","Pontuação","Grau Infração" },SQL.tamanho()) {
           public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
      };
      jtNavegador.setModel(MODEL);
      jtNavegador.setShowGrid(false);

      jtNavegador.getColumnModel().getColumn(0).setMaxWidth(90);  // código
      jtNavegador.getColumnModel().getColumn(1).setMaxWidth(90);  // código Prop
      jtNavegador.getColumnModel().getColumn(2).setMaxWidth(400); // nome prop.
      jtNavegador.getColumnModel().getColumn(3).setMaxWidth(90);  // código veiculo
      jtNavegador.getColumnModel().getColumn(4).setMaxWidth(400); // desc. vei.
      jtNavegador.getColumnModel().getColumn(5).setMaxWidth(180); // data
      jtNavegador.getColumnModel().getColumn(6).setMaxWidth(120); // pontuação
      jtNavegador.getColumnModel().getColumn(7).setMaxWidth(180); // grau inf.
      
    }

    public void Atualiza(){

      int tam = SQL.tamanho();
      
      if (tam != 0) {

        LimpaNavegador();
        
        String strsql;
        strsql =           "SELECT pro.nome as nome, pro.codigo as codigo,";
        strsql = strsql +  "vei.descr as descr, vei.codpro as codpro,";
        strsql = strsql +  "mul.data as data, mul.pontuacao as pontuacao, mul.tipo as tipo,";
        strsql = strsql +  "mul.codvei as codvei, mul.codpro as codpro, mul.codigo as codmul ";
        strsql = strsql +  "FROM MULTA mul, PROPRIETARIO pro, VEICULO vei ";
        strsql = strsql +  "WHERE pro.codigo = mul.codpro AND vei.codigo = mul.codvei";

        RS = SQL.consultar( strsql );
        try {
          int i = 0;
          RS.first();
          do {            
            MODEL.insertRow(i,new Object[] {
              RS.getInt("codmul"),
              RS.getInt("codpro"),
              RS.getString("nome"),
              RS.getInt("codvei"),
              RS.getString("descr"),
              RS.getDate("data"),
              RS.getInt("pontuacao"),
              RS.getString("tipo")
            });
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirActionPerformed
        try {
            String sql = "DELETE FROM MULTA WHERE CODIGO=?";
            PreparedStatement stmt = SQL.connection.prepareStatement(sql);
            stmt.setInt(1, (Integer)jtNavegador.getModel().getValueAt(jtNavegador.getSelectedRow(),0));
            int result = stmt.executeUpdate();
            String mens;
            if (result != 1) {
                mens = "Multa não cadastrado!";
                JOptionPane.showMessageDialog(null, mens);
            } else ((DefaultTableModel)jtNavegador.getModel()).removeRow(jtNavegador.getSelectedRow());
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }//GEN-LAST:event_jbtnExcluirActionPerformed

    private void jtNavegadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtNavegadorMouseClicked
        if ( evt.getClickCount() == 2 ) {
            this.dispose();
        }
    }//GEN-LAST:event_jtNavegadorMouseClicked

    private void jbtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIncluirActionPerformed
        visual.MulCad mul_gui = new MulCad(parentFrame, true);
        mul_gui.setTitle("Cadastro de Multas");
        mul_gui.setAlwaysOnTop(true);
        mul_gui.pack();
        mul_gui.show(true);
        Atualiza();
    }//GEN-LAST:event_jbtnIncluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnExcluir;
    private javax.swing.JButton jbtnIncluir;
    private javax.swing.JTable jtNavegador;
    // End of variables declaration//GEN-END:variables
}
