/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Models.Campeonato;
import Models.Usuario;
import View.FrameLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cmate
 */
public class CampeonatoDAO {

    public void create(Campeonato campeonato) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO campeonato (nome,usuario_id,data)VALUES(?,?,?)");
            stmt.setString(1, campeonato.getNome());
            stmt.setInt(2, campeonato.getUsuarioId());
            stmt.setObject(3, campeonato.getData());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public List<Campeonato> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Campeonato> campeonatos = new ArrayList<>();

        try {

            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.getById(FrameLogin.iduser);

            stmt = con.prepareStatement("SELECT * FROM campeonato WHERE usuario_id = ? ");
            stmt.setInt(1, usuario.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {

                Campeonato campeonato = new Campeonato();

                campeonato.setId(rs.getInt("id"));
                campeonato.setNome(rs.getString("nome"));
                campeonato.setUsuarioId(rs.getInt("usuario_id"));
                campeonatos.add(campeonato);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CampeonatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return campeonatos;
    }

    public ResultSet autenticarcamp(Campeonato campeonato) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM campeonato WHERE id = ? and nome = ? ");
            stmt.setInt(1, campeonato.getId());
            stmt.setString(2, campeonato.getNome());

            ResultSet rs = stmt.executeQuery();

            return rs;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CAMPEONATO INVÁLIDO " + ex);
            return null;
        }

    }

    public Campeonato getbyid(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM campeonato WHERE id = ? ");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();

            Campeonato campeonato = new Campeonato();

            campeonato.setId(rs.getInt("id"));
            campeonato.setNome(rs.getString("nome"));

            return campeonato;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
            return null;
        }

    }

    public void delete(Campeonato campeonato) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM campeonato WHERE id = ? ");

            stmt.setInt(1, campeonato.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }
}
