package main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class Create {
 
    static String url = "jdbc:sqlite:db/test.db";
    
    public static void createNewDatabase(String fileName) {
 


        
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
        
    }
    
    
    public static void createNewTable() {
                
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            
            String sql = "CREATE TABLE IF NOT EXISTS ammo (\n"          //AMMO
                    + " type text PRIMARY KEY,\n"
                    + " quantity integer NOT NULL\n"
                    + ");";
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS armor (\n"                //ARMOR
                    + " name text PRIMARY KEY,\n"
                    + " slot text NOT NULL,\n"
                    + " durability integer NOT NULL,\n"
                    + " rating integer NOT NULL,\n"
                    + " tier integer NOT NULL\n"
                    + ");";                                  
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS backpack (\n"             //BACKPACK
                    + " name text PRIMARY KEY,\n"
                    + " capacity integer NOT NULL\n"
                    + ");";                                  
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS booster (\n"             //BOOSTER
                    + " name text PRIMARY KEY,\n"
                    + " health integer NOT NULL,\n"
                    + " energy integer NOT NULL\n"
                    + ");";                                  
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS clothing (\n"             //CLOTHING
                    + " name text PRIMARY KEY,\n"
                    + " slot text NOT NULL\n"
                    + ");";                                  
            stmt.execute(sql);           
            
            sql = "CREATE TABLE IF NOT EXISTS map (\n"                  //MAP
                    + " name text PRIMARY KEY,\n"
                    + " size integer NOT NULL\n"
                    + ");";                                  
            stmt.execute(sql);
            
            
            sql = "CREATE TABLE IF NOT EXISTS player (\n"               //PLAYER
                    + " name text PRIMARY KEY,\n"
                    + " gender text NOT NULL,\n"
                    + " health integer NOT NULL,\n"
                    + " energy integer NOT NULL\n"
                    + ");";            
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS session (\n"             //SESSION
                    + " gameID text PRIMARY KEY,\n"
                    + " server text NOT NULL,\n"
                    + " gameType text NOT NULL,\n"
                    + " circilePos integer NOT NULL,\n"
                    + " numPlayers integer NOT NULL,\n"
                    + " time integer NOT NULL\n"
                    + ");";                                  
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS standard (\n"            //STANDARD
                    + " name text PRIMARY KEY,\n"
                    + " tier integer NOT NULL,\n"
                    + " quantity integer NOT NULL\n"
                    + ");";                                  
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS throwable (\n"            //THROWABLE
                    + " name text PRIMARY KEY,\n"
                    + " type text NOT NULL,\n"
                    + " damage integer NOT NULL,\n"
                    + " quantity integer NOT NULL\n"
                    + ");";                                  
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS vehicle (\n"            //VEHICLE
                    + " name text PRIMARY KEY,\n"
                    + " health integer NOT NULL,\n"
                    + " numSeats integer NOT NULL,\n"
                    + " topSpeed integer NOT NULL\n"
                    + ");";                                  
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS weapon (\n"            //WEAPON
                    + " name text PRIMARY KEY,\n"
                    + " type text NOT NULL,\n"
                    + " bulletSpeed integer NOT NULL,\n"
                    + " fireRate integer NOT NULL,\n"
                    + " damage integer NOT NULL,\n"
                    + " currentMagCapacity integer,\n"
                    + " maxMagCapacity integer\n"
                    + ");";                                  
            stmt.execute(sql);
            
            
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insert(JSONObject in) {
        String sql = "INSERT INTO map(name,size) VALUES(?,?)";
 
        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //pstmt.setString(1, name);
            //pstmt.setInt(2, size);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Create() {
        createNewDatabase("game.db");
        createNewTable();
        
    }
}