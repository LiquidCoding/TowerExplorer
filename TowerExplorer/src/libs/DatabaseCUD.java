package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 * This will Create new Characters, Update character information, and 
 *      Delete existing characters.
 */
public class DatabaseCUD {
          
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.sqlite.JDBC";  
    static final String DB_URL = "jdbc:sqlite:Game.db";
    
    public static boolean CreateCharacter(String Username, boolean Character1Found, 
            boolean Character2Found, boolean Character3Found, boolean Character4Found){
    
        boolean Success;
        String sql;
        
        Connection conn = null;
        Statement stmt = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            
            if(!Character1Found){
                stmt = conn.createStatement();
                String CharacterName = JOptionPane.showInputDialog("Please enter character name. "
                        + "Or leave blank for a default name.");
                if (CharacterName==null || "".equals(CharacterName)){
                    CharacterName = "Steve";
                }
                sql = "UPDATE "+Username+" set Level = 1, NAME = '"+CharacterName+"', "
                        + "Strength = 10, Endurance = 10, Health = 100, "
                        + "CurrentExp = 0, NeededExp = 100, CurrentFloor = 1 "
                        + "WHERE CharacterID = 1;";
                stmt.executeUpdate(sql);
            }
            else if(!Character2Found){
                stmt = conn.createStatement();
                String CharacterName = JOptionPane.showInputDialog("Please enter character name. "
                        + "Or leave blank for a default name.");
                if (CharacterName==null || "".equals(CharacterName)){
                    CharacterName = "Billy";
                }
                sql = "UPDATE "+Username+" set Level = 1, NAME = '"+CharacterName+"', "
                        + "Strength = 10, Endurance = 10, Health = 100, "
                        + "CurrentExp = 0, NeededExp = 100, CurrentFloor = 1 "
                        + "WHERE CharacterID = 2;";
                stmt.executeUpdate(sql);
            }
            else if(!Character3Found){
                stmt = conn.createStatement();
                String CharacterName = JOptionPane.showInputDialog("Please enter character name. "
                        + "Or leave blank for a default name.", null);
                if (CharacterName==null || "".equals(CharacterName)){
                    CharacterName = "Mandy";
                }
                sql = "UPDATE "+Username+" set Level = 1, NAME = '"+CharacterName+"', "
                        + "Strength = 10, Endurance = 10, Health = 100, "
                        + "CurrentExp = 0, NeededExp = 100, CurrentFloor = 1 "
                        + "WHERE CharacterID = 3;";
                stmt.executeUpdate(sql);
            }
            else if(!Character4Found){
                stmt = conn.createStatement();
                String CharacterName = JOptionPane.showInputDialog("Please enter character name. "
                        + "Or leave blank for a default name.");
                if (CharacterName==null || "".equals(CharacterName)){
                    CharacterName = "Popcorn";
                }
                sql = "UPDATE "+Username+" set Level = 1, NAME = '"+CharacterName+"', "
                        + "Strength = 10, Endurance = 10, Health = 100, "
                        + "CurrentExp = 0, NeededExp = 100, CurrentFloor = 1 "
                        + "WHERE CharacterID = 4;";
                stmt.executeUpdate(sql);
            }

            //STEP 5: Clean-up environment.
            stmt.close();
            conn.close();
            Success = true;
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        Success = false;
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
        Success = false;
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                stmt.close();
                }
            catch(SQLException se2){}
            // nothing we can do
                try{
                    if(conn!=null)
                    conn.close();
                    }
                catch(SQLException se){
                se.printStackTrace();
                }//end finally try
        }//end try
        
        return Success;
    }
    
    public static boolean CreateUser(String Username, String Password){
        
        boolean Success;
        String HashedPassword = PasswordHashing.PasswordHashing(Password);
        
        Connection conn = null;
        Statement stmt = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: Insert the Login information.
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO PlayerTable VALUES("+ "'"+Username+"'" +","+ "'"
                    +HashedPassword+"'" + ");";
            stmt.executeUpdate(sql);
            
            //STEP 4.5: Create the Table for the players characters.
            sql = "CREATE TABLE "+Username +
                    "(CharacterID INTEGER NOT NULL PRIMARY KEY, " +
                    " Level INTEGER, " +
                    " Name VARCHAR(12), " + 
                    " Strength INTEGER, " + 
                    " Endurance INTEGER, " +
                    " Health INTEGER, " +
                    " CurrentExp INTEGER, " +
                    " NeededExp INTEGER, " +
                    " CurrentFloor INTEGER);";
            stmt.executeUpdate(sql);
            
            //STEP 5: Set up the rows for the characters.
            sql = "INSERT INTO " +Username +" (CharacterID) VALUES(1)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO " +Username +" (CharacterID) VALUES(2)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO " +Username +" (CharacterID) VALUES(3)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO " +Username +" (CharacterID) VALUES(4)";
            stmt.executeUpdate(sql);
            
            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
            Success = true;
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        Success = false;
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
        Success = false;
        }
        finally{
        //finally block used to close resources
            try{
                if(stmt!=null)
                stmt.close();
                }
            // nothing we can do
            catch(SQLException se2){}
            try{
                if(conn!=null)
                conn.close();
                }
            catch(SQLException se){
            se.printStackTrace();
            }//end finally try
        }//end try
        
        return Success;
    }
    
    public static boolean Update(String Username, int Level, int Strength, int Endurance,
            int Health, int CurrentExp, int NeededExp, int CurrentFloor, int CharacterID){
        
        boolean Success;
        String sql;
        
        Connection conn = null;
        Statement stmt = null;
            
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            
            stmt = conn.createStatement();
            sql = "UPDATE "+Username+" set Level = "+Level+", Strength = "+Strength+", "
                + "Endurance = "+Endurance+", Health = "+Health+", CurrentExp = "+CurrentExp+","
                + "NeededExp = "+NeededExp+", CurrentFloor = "+CurrentFloor+ 
                " WHERE CharacterID = "+CharacterID+";";
                stmt.executeUpdate(sql);
            

            //STEP 5: Clean-up environment.
            stmt.close();
            conn.close();
            Success = true;
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        Success = false;
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
        Success = false;
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                stmt.close();
                }
            catch(SQLException se2){}
            // nothing we can do
                try{
                    if(conn!=null)
                    conn.close();
                    }
                catch(SQLException se){
                se.printStackTrace();
                }//end finally try
        }//end try
        
        return Success;
    }
    
    public static boolean Delete(String Username, int CharacterID, String Name){
        
        boolean Success;
        String sql;
        
        Connection conn = null;
        Statement stmt = null;
        
        int Selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "
                +Name+"?", "Character Deletion", 0);
            
        if(Selection == JOptionPane.OK_OPTION){
           
            try{
                //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 3: Open a connection

                conn = DriverManager.getConnection(DB_URL);

                //STEP 4: Reset the Character back to null.
                stmt = conn.createStatement();
                
                //This deletes the Character's row.
                sql = "DELETE FROM "+Username+" WHERE CharacterID = "+CharacterID+" "
                        + "AND Name = '"+Name+"' ;";
                stmt.executeUpdate(sql);
                
                //This re-inserts the Character into the table.
                sql = "INSERT INTO " +Username +" (CharacterID) VALUES("+CharacterID+")";
                stmt.executeUpdate(sql);

                //STEP 5: Clean-up environment.
                stmt.close();
                conn.close();
                Success = true;
            }
            catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
                Success = false;
            }
            catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
                Success = false;
            }
            finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                    stmt.close();
                }
                catch(SQLException se2){}
                    // nothing we can do
                    try{
                        if(conn!=null)
                        conn.close();
                    }
                    catch(SQLException se){
                        se.printStackTrace();
                    }//end finally try
            }//end try
        }
        else{
            Success = false;
        }
        return Success;
    }
}