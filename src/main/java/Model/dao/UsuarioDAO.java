/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cmate
 */
public class UsuarioDAO {
    
    public void create(Usuario usuario){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuario (login,senha)VALUES(?,?)");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
           
            stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
        
    }
    
}
