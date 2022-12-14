/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UsuarioController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

/**
 *
 * @author GabrielSantos
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private UsuarioController controller = new UsuarioController();
    private Object valueAt;
    private Boolean acionaPreencheTabela=false;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        controller = new UsuarioController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNovoCadastro = new javax.swing.JButton();
        btnListarTodos = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sistema Teste");

        btnNovoCadastro.setText("Novo Cadastro");
        btnNovoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCadastroActionPerformed(evt);
            }
        });

        btnListarTodos.setText("Listar Todos");
        btnListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosActionPerformed(evt);
            }
        });

        btnDelete.setText("Deletar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Idade", "Profiss??o"
            }
        ));
        jScrollPane.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovoCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarTodos)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(280, 280, 280))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarTodos)
                    .addComponent(btnNovoCadastro)
                    .addComponent(btnDelete)
                    .addComponent(btnAtualizar))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCadastroActionPerformed
        // TODO add your handling code here:
        new CadastroUsuario().setVisible(true);


    }//GEN-LAST:event_btnNovoCadastroActionPerformed

    private void btnListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosActionPerformed

        preencheTabela();

    }//GEN-LAST:event_btnListarTodosActionPerformed


    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel dtmDelete = (DefaultTableModel) jTable.getModel();

        if (jTable.getSelectedRow() > -1) {
            int linha = jTable.getSelectedRow();
            Object valueAt = jTable.getValueAt(linha, 0);
            int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja excluir a linha " + valueAt + " ?");
            if (dialogResult == JOptionPane.YES_OPTION) {
                System.out.println("Confirmou a exclu??o");
                controller.deleteUser((Integer) valueAt);
                preencheTabela();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por Favor, selecione uma linha!");
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (jTable.getSelectedRow() > -1) {
            int linha = jTable.getSelectedRow();
            valueAt = jTable.getValueAt(linha, 0);
            new AtualizarCadastro((Integer) valueAt).setVisible(true);
            

        } else {
            JOptionPane.showMessageDialog(rootPane, "?? necess??rio selecionar uma linha para atualizar os dados!");
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed
    public void preencheTabela() {
        while (jTable.getModel().getRowCount() > 0) { //Remove linhas ap??s novo click; 
            ((DefaultTableModel) jTable.getModel()).removeRow(0);
        }
        DefaultTableModel dtmUser = (DefaultTableModel) jTable.getModel();
        List<Usuario> users = controller.buscarTodos();
        for (Usuario u : users) {
            dtmUser.addRow(new Object[]{
                u.getId(), u.getNome(), u.getIdade(), u.getProfissao()
            });
        }
    }
    
   

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    public JTable getjTable() {
        return jTable;
    }
    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public Object getValueAt() {
        return valueAt;
    }

    public void setValueAt(Object valueAt) {
        this.valueAt = valueAt;
    }

    public Boolean getAcionaPreencheTabela() {
        return acionaPreencheTabela;
    }

    public void setAcionaPreencheTabela(Boolean acionaPreencheTabela) {
        this.acionaPreencheTabela = acionaPreencheTabela;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JButton btnNovoCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
