/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Models.Campeonato;
import Models.ItemPartida;
import Models.PartidaStatus;
import Models.Usuario;
import View.FrameLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cmate
 */
public class ItemPartidaDAO {

    public void create(ItemPartida itemPartida) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String query = "INSERT INTO item_partida (mapa_id,time_a_id, time_b_id, partida_id, "
                    + "campeonato_id, data_inicio, data_final, status)VALUES(?,?,?,?,?,?,?,?)";

            stmt = con.prepareStatement(query);
            stmt.setInt(1, itemPartida.getMapaId());
            stmt.setInt(2, itemPartida.getTimeAId());
            stmt.setInt(3, itemPartida.getTimeBId());
            stmt.setInt(4, itemPartida.getPartidaId());
            stmt.setInt(5, itemPartida.getCampeonatoId());
            stmt.setString(6, OffsetDateTime.now().toString());
            stmt.setString(7, OffsetDateTime.now().toString());
            stmt.setString(8, PartidaStatus.PENDENTE);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public List<ItemPartida> read(int idPartida) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ItemPartida> itens = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM item_partida WHERE partida_id = ? ");
            stmt.setInt(1, idPartida);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ItemPartida item = new ItemPartida();

                item.setId(rs.getInt("id"));
                item.setMapaId(rs.getInt("mapa_id"));
                item.setTimeAId(rs.getInt("time_a_id"));
                item.setTimeBId(rs.getInt("time_b_id"));
                item.setPartidaId(rs.getInt("partida_id"));
                item.setCampeonatoId(rs.getInt("campeonato_id"));
                //fazer dos times
                item.setStatus(rs.getString("status"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemPartidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return itens;
    }

    public ItemPartida getbyid(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM item_partida WHERE id = ? ");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();

            ItemPartida item = new ItemPartida();

            item.setId(rs.getInt("id"));
            item.setMapaId(rs.getInt("mapa_id"));
            item.setTimeAId(rs.getInt("time_a_id"));
            item.setTimeBId(rs.getInt("time_b_id"));
            item.setPartidaId(rs.getInt("partida_id"));
            item.setCampeonatoId(rs.getInt("campeonato_id"));
            //fazer dos times
            item.setStatus(rs.getString("status"));

            return item;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
            return null;
        }

    }

    public void delete(ItemPartida item) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM item_partida WHERE id = ? ");

            stmt.setInt(1, item.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }
}
