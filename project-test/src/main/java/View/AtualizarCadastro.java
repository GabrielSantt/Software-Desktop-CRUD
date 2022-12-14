/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UsuarioController;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Usuario;

/**
 *
 * @author GabrielSantos
 */
public class AtualizarCadastro extends javax.swing.JFrame {

    private UsuarioController controller = null;
    private Integer id;

    /**
     * Creates new form CadastroUsuarioo
     * @param valueAt
     */
    public AtualizarCadastro(Integer valueAt) {
        initComponents();
        controller = new UsuarioController(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        buscarCadastro(valueAt);
        id= valueAt;
    }

    AtualizarCadastro() {
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtAtualizaNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAtualizaIdade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAtualizaProfissao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAtualiza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Idade");

        jLabel3.setText("Profissão");

        jLabel4.setText("Atualzar Cadastro");

        btnAtualiza.setText("Salvar");
        btnAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtAtualizaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAtualizaIdade)
                            .addComponent(txtAtualizaProfissao)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnAtualiza)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAtualizaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAtualizaIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAtualizaProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnAtualiza)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void buscarCadastro(Integer id) {
        Usuario user = controller.buscarPorId(id);

        txtAtualizaNome.setText(user.getNome());
        txtAtualizaIdade.setText(user.getIdade().toString());
        txtAtualizaProfissao.setText(user.getProfissao());

    }
    private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaActionPerformed
        // TODO add your handling code here:
            
        Usuario user= controller.buscarPorId(id);
        
        user.setNome(txtAtualizaNome.getText());
        user.setIdade(Integer.parseInt(txtAtualizaIdade.getText() ) );
        user.setProfissao( txtAtualizaProfissao.getText());
        
        controller.atualizar(user);
        JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
        new TelaPrincipal().preencheTabela();
        
    }//GEN-LAST:event_btnAtualizaActionPerformed

    public JTextField getTxtAtualizaIdade() {
        return txtAtualizaIdade;
    }

    public void setTxtAtualizaIdade(JTextField txtAtualizaIdade) {
        this.txtAtualizaIdade = txtAtualizaIdade;
    }

    public JTextField getTxtAtualizaNome() {
        return txtAtualizaNome;
    }

    public void setTxtAtualizaNome(JTextField txtAtualizaNome) {
        this.txtAtualizaNome = txtAtualizaNome;
    }

    public JTextField getTxtAtualizaProfissao() {
        return txtAtualizaProfissao;
    }

    public void setTxtAtualizaProfissao(JTextField txtAtualizaProfissao) {
        this.txtAtualizaProfissao = txtAtualizaProfissao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualiza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtAtualizaIdade;
    private javax.swing.JTextField txtAtualizaNome;
    private javax.swing.JTextField txtAtualizaProfissao;
    // End of variables declaration//GEN-END:variables
}
