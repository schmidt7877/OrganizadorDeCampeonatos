/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Models.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cmate
 */
public class UsuarioDAO {

    public void create(Usuario usuario) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messagedigest [] = md.digest(usuario.getSenha().getBytes("UTF-8"));
            
            StringBuilder sb = new StringBuilder();
            
            for(byte b : messagedigest){
                sb.append(String.format("%02X", 0xFF & b));
                
         
            }
            
            String senhaHex = sb.toString();

            stmt = con.prepareStatement("INSERT INTO usuario (login,senha)VALUES(?,?)");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, senhaHex);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public ResultSet autenticarusuario(Usuario usuario) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ? ");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();
            return rs;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario ou Senha INVALIDOS " + ex);
            return null;
        }

    }

}
