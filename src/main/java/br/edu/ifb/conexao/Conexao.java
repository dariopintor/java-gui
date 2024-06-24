package br.edu.ifb.conexao;


import br.edu.ifb.DAO.ContatoDAO;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    
   private static final String URL = "jdbc:sqlite:bancoAgenda.db";
    public static Connection getConnection() {
        
       try {
           return DriverManager.getConnection(URL);
       } catch (SQLException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }
    
    public static void closeConnection(Connection con){
       try {
           con.close();
       } catch (SQLException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
       closeConnection(con);
        try {  
           
           stmt.close();
       } catch (SQLException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
       try {
           rs.close();
       } catch (SQLException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
    
    public static void main(String[] args) {
        ContatoDAO ver = new ContatoDAO();
        ver.lerBanco();
    }
}
