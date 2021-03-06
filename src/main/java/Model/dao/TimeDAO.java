/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Models.Mapa;
import Models.Time;
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
public class TimeDAO {
    
    public void create(Time time) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO time (nome,campeonato_id)VALUES(?,?)");
            stmt.setString(1, time.getNome());
            stmt.setInt(2, time.getCampeonatoId());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro do time efetuado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }
    
    public List<Time> read(int campeonatoId) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Time> times = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM time WHERE campeonato_id = ? ");
            stmt.setInt(1, campeonatoId);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Time time = new Time();

                time.setId(rs.getInt("id"));
                time.setNome(rs.getString("nome"));
                time.setCampeonatoId(rs.getInt("campeonato_id"));
                times.add(time);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return times;
    }

    public Time getbyid(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM time WHERE id = ? ");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();

            Time time = new Time();

            time.setId(rs.getInt("id"));
            time.setNome(rs.getString("nome"));
            time.setCampeonatoId(rs.getInt("campeonato_id"));

            return time;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
            return null;
        }

    }

    public void delete(Time time) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM time WHERE id = ? ");

            stmt.setInt(1, time.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }
    
}
