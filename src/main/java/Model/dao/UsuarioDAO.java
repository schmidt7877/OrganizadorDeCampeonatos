/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Models.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
            stmt = con.prepareStatement("INSERT INTO usuario (login,senha)VALUES(?,?)");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, encriptografar(usuario.getSenha()));

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
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
            stmt.setString(2, encriptografar(usuario.getSenha()));

            ResultSet rs = stmt.executeQuery();

            return rs;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario ou Senha INVALIDOS " + ex);
            return null;
        }

    }

    public static String encriptografar(String senha) {
        String retorno = "";
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            retorno = hash.toString(16);
        } catch (Exception e) {
        }
        return retorno;
    }

    public Usuario getById(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE id = ? ");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();

            Usuario usuario = new Usuario();
            
            usuario.setId(rs.getInt("id"));
            usuario.setLogin(rs.getString("login"));
            
            return usuario;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
            return null;
        }

    }
}
