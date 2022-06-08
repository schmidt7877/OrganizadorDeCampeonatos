/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Models.Mapa;
import Models.Player;
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
public class PlayerDAO {

    public void create(Player player) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO player (nome, time_id, campeonato_id)VALUES(?,?,?)");
            stmt.setString(1, player.getNome());
            stmt.setInt(2, player.getTimeId());
            stmt.setInt(3, player.getCampeonatoId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public List<Player> readByCampeonatoId(int campeonatoId) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Player> players = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM player WHERE campeonato_id = ? ");
            stmt.setInt(1, campeonatoId);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Player player = new Player();

                player.setId(rs.getInt("id"));
                player.setNome(rs.getString("nome"));
                player.setTimeId(rs.getInt("time_id"));
                player.setCampeonatoId(rs.getInt("campeonato_id"));
                players.add(player);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return players;
    }

    public List<Player> readByTimeId(int timeId) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Player> players = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM player WHERE time_id = ? ");
            stmt.setInt(1, timeId);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Player player = new Player();

                player.setId(rs.getInt("id"));
                player.setNome(rs.getString("nome"));
                player.setTimeId(rs.getInt("time_id"));
                player.setCampeonatoId(rs.getInt("campeonato_id"));
                players.add(player);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return players;
    }

    public Player getbyid(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM player WHERE id = ? ");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();

            Player player = new Player();

            player.setId(rs.getInt("id"));
            player.setNome(rs.getString("nome"));
            player.setTimeId(rs.getInt("time_id"));
            player.setCampeonatoId(rs.getInt("campeonato_id"));

            return player;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
            return null;
        }

    }

    public void delete(Mapa mapa) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM mapa WHERE id = ? ");

            stmt.setInt(1, mapa.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }
}
