/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.dao.UsuarioDAO;
import Models.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cmate
 */
public class FrameLogin extends javax.swing.JFrame {

    public static int iduser;

    /**
     * Creates new form FrameLogin
     */
    public FrameLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCadastrar = new javax.swing.JButton();
        btEntrar = new javax.swing.JButton();
        tfSenha = new javax.swing.JPasswordField();
        tfLogin = new javax.swing.JTextField();
        lbSenha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbLogin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btCadastrar.setText("CADASTRE-SE");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, 160, 40));

        btEntrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btEntrar.setText("ENTRAR");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 160, 40));

        tfSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(tfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 280, 40));

        tfLogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfLogin.setToolTipText("");
        tfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoginActionPerformed(evt);
            }
        });
        getContentPane().add(tfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 280, 40));

        lbSenha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbSenha.setForeground(new java.awt.Color(255, 255, 255));
        lbSenha.setText("Senha");
        getContentPane().add(lbSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Entrar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        lbLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbLogin.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin.setText("Login");
        getContentPane().add(lbLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 540, 30, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/login.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoginActionPerformed

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        logar();

    }//GEN-LAST:event_btEntrarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed

        FrameCadastroUsuario tela = new FrameCadastroUsuario();
        tela.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrameLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables

    private void logar() {

        try {

            String login = tfLogin.getText().trim();
            String senha = tfSenha.getText().trim();

            if (login.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERRO! CAMPO LOGIN EST?? VAZI0");
            } else if (senha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERRO! CAMPO SENHA EST?? VAZI0");
            } else {

                Usuario usuario = new Usuario();
                UsuarioDAO dao = new UsuarioDAO();

                usuario.setLogin(tfLogin.getText());
                usuario.setSenha(new String(tfSenha.getPassword()));
                ResultSet rs = dao.autenticarusuario(usuario);

                if (rs.next()) {
                    FrameLogin.iduser = rs.getInt("id");
                    FrameCampeonatos tela = new FrameCampeonatos();
                    tela.setVisible(true);
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "USUARIO OU SENHA INVALIDA");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "FRMLOGIN ERRO" + ex);
        }

    }

}
