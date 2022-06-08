/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Models.Campeonato;
import Models.ItemPartida;
import Models.Partida;
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
public class PartidaDAO {

    public void create(Partida partida) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String query = "INSERT INTO partida (data, vencedor, perdedor, campeonato_id) VALUES (?,?,?,?)";

            
            stmt = con.prepareStatement(query);
            stmt.setString(1, OffsetDateTime.now().toString());
            stmt.setString(2, partida.getVencedor());
            stmt.setString(3, partida.getPerdedor());
            stmt.setInt(4, partida.getCampeonatoId());
            
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public List<Partida> read(int idCampeonato) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Partida> partidas = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM partida WHERE campeonato_id = ? ");
            stmt.setInt(1, idCampeonato);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Partida partida = new Partida();

                partida.setId(rs.getInt("id"));
                //partida.setData();
                partida.setVencedor(rs.getString("vencedor"));
                partida.setPerdedor(rs.getString("perdedor"));
                partida.setCampeonatoId(rs.getInt("campeonato_id"));

                partidas.add(partida);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PartidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return partidas;
    }

    public Partida getbyid(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM partida WHERE id = ? ");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();

            Partida partida = new Partida();

            partida.setId(rs.getInt("id"));
            //partida.setData();
            partida.setVencedor(rs.getString("vencedor"));
            partida.setVencedor(rs.getString("perdedor"));
            partida.setCampeonatoId(rs.getInt("campeonato_id"));

            return partida;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
            return null;
        }

    }

    public void delete(Partida partida) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM partida WHERE id = ? ");

            stmt.setInt(1, partida.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }

    }
}
