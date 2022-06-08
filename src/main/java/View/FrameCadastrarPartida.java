/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.dao.PartidaDAO;
import Model.dao.TimeDAO;
import Models.Partida;
import Models.Time;
import java.time.OffsetDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author cmate
 */
public class FrameCadastrarPartida extends javax.swing.JFrame {

    /**
     * Creates new form FrameCadastrarPartida
     */
    public FrameCadastrarPartida() {
        initComponents();

        TimeDAO dao = new TimeDAO();

        for (Time t : dao.read(FrameVisualizarCampeonato.idcamp)) {
            jComboEquipeA.addItem(t);
            jComboEquipeB.addItem(t);

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboEquipeB = new javax.swing.JComboBox<>();
        jComboEquipeA = new javax.swing.JComboBox<>();
        btCadastrarPartida = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelIconeVoltar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboEquipeB.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipe B"));
        jComboEquipeB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboEquipeBItemStateChanged(evt);
            }
        });
        jComboEquipeB.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jComboEquipeBComponentHidden(evt);
            }
        });
        jComboEquipeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEquipeBActionPerformed(evt);
            }
        });
        getContentPane().add(jComboEquipeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 140, 60));

        jComboEquipeA.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipe A"));
        jComboEquipeA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboEquipeAItemStateChanged(evt);
            }
        });
        jComboEquipeA.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jComboEquipeACaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        getContentPane().add(jComboEquipeA, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 140, 60));

        btCadastrarPartida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btCadastrarPartida.setText("Cadastrar Partida");
        btCadastrarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarPartidaActionPerformed(evt);
            }
        });
        getContentPane().add(btCadastrarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 170, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MATCH INFO");
        jLabel2.setMaximumSize(new java.awt.Dimension(500, 250));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1000, 50));

        labelIconeVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconeVoltarMouseClicked(evt);
            }
        });
        getContentPane().add(labelIconeVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 540, 20, 10));

        jLabel8.setText("Perdedor:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, -1, -1));

        jLabel9.setText("Vencedor:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, -1));

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botao-voltar.png"))); // NOI18N
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboEquipeBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboEquipeBItemStateChanged


    }//GEN-LAST:event_jComboEquipeBItemStateChanged

    private void jComboEquipeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEquipeBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEquipeBActionPerformed

    private void jComboEquipeAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboEquipeAItemStateChanged


    }//GEN-LAST:event_jComboEquipeAItemStateChanged

    private void jComboEquipeACaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboEquipeACaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEquipeACaretPositionChanged

    private void btCadastrarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarPartidaActionPerformed
        cadastrar();
    }//GEN-LAST:event_btCadastrarPartidaActionPerformed

    private void labelIconeVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconeVoltarMouseClicked
        FrameMenuPrincipal menu = new FrameMenuPrincipal();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelIconeVoltarMouseClicked

    private void jComboEquipeBComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jComboEquipeBComponentHidden

    }//GEN-LAST:event_jComboEquipeBComponentHidden

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        FrameMenuPrincipal tela = new FrameMenuPrincipal();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(FrameCadastrarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCadastrarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCadastrarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCadastrarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCadastrarPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrarPartida;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Time> jComboEquipeA;
    private javax.swing.JComboBox<Time> jComboEquipeB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelIconeVoltar;
    // End of variables declaration//GEN-END:variables

    private void cadastrar() {
        Partida partida = new Partida();
        PartidaDAO dao = new PartidaDAO();
        
        Time time = ((Time) jComboEquipeA.getSelectedItem());
        Time time2 = ((Time) jComboEquipeB.getSelectedItem());
        
        partida.setData(OffsetDateTime.now());
        partida.setVencedor(time.getNome());
        partida.setPerdedor(time2.getNome());
        partida.setCampeonatoId(FrameVisualizarCampeonato.idcamp);
        

        dao.create(partida);

        FrameMenuPrincipal tela = new FrameMenuPrincipal();
        tela.setVisible(true);
        this.dispose();

    }

}
