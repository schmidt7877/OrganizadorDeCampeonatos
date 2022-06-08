/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.dao.PlayerDAO;
import Model.dao.TimeDAO;
import Models.Player;
import Models.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author cmate
 */
public class FrameCadastrarPlayer extends javax.swing.JFrame {

    /**
     * Creates new form FrameCadastrarPlayer
     */
    public FrameCadastrarPlayer() {
        initComponents();
        
        
        TimeDAO dao = new TimeDAO();
        
        for(Time t : dao.read(FrameVisualizarCampeonato.idcamp)){
            jcTimes.addItem(t);
            
        }
        
        
        
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
        lbTime = new javax.swing.JLabel();
        jcTimes = new javax.swing.JComboBox<>();
        tfNome = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        lbFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btCadastrar.setText("CADASTRAR PLAYER");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 150, 40));

        lbTime.setFont(new java.awt.Font("Segoe UI", 1, 29)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 255, 255));
        lbTime.setText("Time:");
        getContentPane().add(lbTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, -1, -1));

        getContentPane().add(jcTimes, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 180, 30));
        getContentPane().add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 220, 50));

        lbNome.setFont(new java.awt.Font("Segoe UI", 1, 29)); // NOI18N
        lbNome.setForeground(new java.awt.Color(255, 255, 255));
        lbNome.setText("Nome:");
        getContentPane().add(lbNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botao-voltar.png"))); // NOI18N
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CadastrarPlayer.png"))); // NOI18N
        getContentPane().add(lbFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        FrameMenuPrincipal tela = new FrameMenuPrincipal();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        cadastrar();
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
            java.util.logging.Logger.getLogger(FrameCadastrarPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCadastrarPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCadastrarPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCadastrarPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCadastrarPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<Object> jcTimes;
    private javax.swing.JLabel lbFundo;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTime;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

private void cadastrar(){
    Player player = new Player();
    PlayerDAO dao = new PlayerDAO();
    

    
    if (tfNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERRO! CAMPO NOME ESTÁ VAZI0");
    } else {
        
            Time time = (Time) jcTimes.getSelectedItem();
            player.setNome(tfNome.getText());
            player.setCampeonatoId(FrameVisualizarCampeonato.idcamp);
            player.setTimeId(time.getId());
            dao.create(player);
            
            FrameMenuPrincipal tela = new FrameMenuPrincipal();
            tela.setVisible(true);
            this.dispose();
        }
    
    
    
}


}
