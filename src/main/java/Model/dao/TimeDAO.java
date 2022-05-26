/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Models.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
}
