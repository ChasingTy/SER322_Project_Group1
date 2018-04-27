package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import entities.Ammo;
import entityLists.*;

public class InsertDB {
    
    static String url = "jdbc:sqlite:db/test.db";
    
    public static void insertAmmo(AmmoList in) {                                                            //AMMO
        String sql = "INSERT INTO ammo(name,type,quantity) VALUES(?,?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setString(2, in.getList().get(i).getType());
                pstmt.setInt(3, in.getList().get(i).getQuantity());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    public static void insertArmor(ArmorList in) {                                                         //ARMOR
        String sql = "INSERT INTO armor(name,slot,durability,rating,tier) VALUES(?,?,?,?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setString(2, in.getList().get(i).getSlot());
                pstmt.setInt(3, in.getList().get(i).getDurability());
                pstmt.setInt(4, in.getList().get(i).getRating());
                pstmt.setInt(5, in.getList().get(i).getTier());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    public static void insertBackpack(BackpackList in) {                                                   //BACKPACK
        String sql = "INSERT INTO backpack(name,capacity) VALUES(?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setInt(2, in.getList().get(i).getCapacity());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    public static void insertBooster(BoosterList in) {                                                  //BOOSTER
        String sql = "INSERT INTO booster(name,health,energy) VALUES(?,?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setInt(2, in.getList().get(i).getHealth());
                pstmt.setInt(3, in.getList().get(i).getEnergy());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    public static void insertClothing(ClothingList in) {                                                  //CLOTHING
        String sql = "INSERT INTO clothing(name,slot) VALUES(?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setString(2, in.getList().get(i).getSlot());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    public static void insertMap(MapList in) {                                                  //MAP
        String sql = "INSERT INTO map(name,size) VALUES(?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setInt(2, in.getList().get(i).getSize());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    public static void insertPlayer(PlayerList in) {                                                  //Player
        String sql = "INSERT INTO player(name,gender,health,energy) VALUES(?,?,?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setString(2, in.getList().get(i).getGender());
                pstmt.setInt(3, in.getList().get(i).getHealth());
                pstmt.setInt(4, in.getList().get(i).getEnergy());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    public static void insertSession(SessionList in) {                                                  //Session
        String sql = "INSERT INTO session(gameID,server,circlePos,numPlayers,time) VALUES(?,?,?,?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getGameID());
                pstmt.setString(2, in.getList().get(i).getServer());
                pstmt.setInt(3, in.getList().get(i).getCirclePos());
                pstmt.setInt(4, in.getList().get(i).getNumPlayers());
                pstmt.setInt(5, in.getList().get(i).getTime());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    public static void insertStandard(StandardList in) {                                                  //STANDARD
        String sql = "INSERT INTO standard(name,tier,quantity) VALUES(?,?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setInt(2, in.getList().get(i).getTier());
                pstmt.setInt(3, in.getList().get(i).getQuantity());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    public static void insertThrowable(ThrowAbleList in) {                                                  //THROWABLE
        String sql = "INSERT INTO throwable(name,type,damage,quantity) VALUES(?,?,?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setString(2, in.getList().get(i).getType());
                pstmt.setInt(3, in.getList().get(i).getDamage());
                pstmt.setInt(4, in.getList().get(i).getQuantity());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    public static void insertVehicle(VehicleList in) {                                                  //VEHICLE
        String sql = "INSERT INTO vehicle(name,health,numSeats,topSpeed) VALUES(?,?,?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setInt(2, in.getList().get(i).getHealth());
                pstmt.setInt(3, in.getList().get(i).getNumSeats());
                pstmt.setInt(4, in.getList().get(i).getTopSpeed());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    public static void insertWeapon(WeaponList in) {                                                  //WEAPON
        String sql = "INSERT INTO weapon(name,type,bulletSpeed,fireRate,damage,currentMagCapacity,MaxMagCapacity) VALUES(?,?,?,?,?,?,?)";
        
        for(int i = 0; i < in.getList().size(); i++) {
 
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, in.getList().get(i).getName());
                pstmt.setString(2, in.getList().get(i).getType());
                pstmt.setInt(3, in.getList().get(i).getBulletSpeed());
                pstmt.setInt(4, in.getList().get(i).getFireRate());
                pstmt.setInt(5, in.getList().get(i).getDamage());
                pstmt.setInt(6, in.getList().get(i).getCurrentMagCapacity());
                pstmt.setInt(7, in.getList().get(i).getMaxMagCapacity());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }
    
    
    
    
    
    
    
    
    
    

}
