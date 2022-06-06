/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Models.Campeonato;
import Models.Mapa;
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
public class MapaDAO {

    public void create(Mapa mapa) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO mapa (nome,campeonato_id)VALUES(?,?)");
            stmt.setString(1, mapa.getNome());
            stmt.setInt(2, mapa.getCampeonatoId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public List<Mapa> read(int campeonatoId) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Mapa> mapas = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM mapa WHERE campeonato_id = ? ");
            stmt.setInt(1, campeonatoId);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Mapa mapa = new Mapa();

                mapa.setId(rs.getInt("id"));
                mapa.setNome(rs.getString("nome"));
                mapa.setCampeonatoId(rs.getInt("campeonato_id"));
                mapas.add(mapa);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return mapas;
    }

    public Mapa getbyid(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM mapa WHERE id = ? ");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();

            Mapa mapa = new Mapa();

            mapa.setId(rs.getInt("id"));
            mapa.setNome(rs.getString("nome"));
            mapa.setCampeonatoId(rs.getInt("campeonato_id"));

            return mapa;

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
