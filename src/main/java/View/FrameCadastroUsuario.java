/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.dao.UsuarioDAO;
import Models.Usuario;

/**
 *
 * @author cmate
 */
public class FrameCadastroUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FrameCadastroUsuario
     */
    public FrameCadastroUsuario() {
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

        tfLogin = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();
        btCadastrar = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfLogin.setToolTipText("");
        tfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoginActionPerformed(evt);
            }
        });
        getContentPane().add(tfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 270, 40));
        getContentPane().add(tfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 270, 40));

        btCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btCadastrar.setText("CADASTRAR");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 160, 40));

        lbLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbLogin.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin.setText("Login");
        getContentPane().add(lbLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        lbSenha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbSenha.setForeground(new java.awt.Color(255, 255, 255));
        lbSenha.setText("Senha");
        getContentPane().add(lbSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cadastrar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/login.png"))); // NOI18N
        getContentPane().add(lbFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoginActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        usuario.setLogin(tfLogin.getText());
        usuario.setSenha(new String(tfSenha.getPassword()));
        dao.create(usuario);
        
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
            java.util.logging.Logger.getLogger(FrameCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbFundo;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables
}
