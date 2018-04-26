package main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
 
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
            
            
            String sql = "CREATE TABLE IF NOT EXISTS player (\n"
                    + " name text PRIMARY KEY,\n"
                    + " gender text NOT NULL,\n"
                    + " health integer NOT NULL,\n"
                    + " energy integer NOT NULL\n"
                    + ");";
            
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS map (\n"
                    + " name text PRIMARY KEY,\n"
                    + " size integer NOT NULL\n"
                    + ");";
            
            
            
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insert(String name, int size) {
        String sql = "INSERT INTO map(name,size) VALUES(?,?)";
 
        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, size);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewDatabase("test.db");
        createNewTable();
        insert("miramar", 2000);
        insert("errangel", 1999);
    }
}