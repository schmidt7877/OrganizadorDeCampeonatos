/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cmate
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://69.49.241.116:3306/cur03724_teste1?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "cur03724_teste1";
    private static final String PASS = "XeDkqNd4a3n6W7B";
    
    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);          
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException(" ERRO NA CONEXÃO ", ex);
        }
    }
    
    public static void closeConnection(Connection con){
        try {
        if(con!=null){
           con.close();
        }        
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        closeConnection(con);
        
        try {
            
            if(stmt!=null){
                stmt.close();
                
            }
               
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con, stmt);
        
        try {
            
            if(rs!=null){
                rs.close();
                
            }
               
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    
    
    }
    
    
    
    



