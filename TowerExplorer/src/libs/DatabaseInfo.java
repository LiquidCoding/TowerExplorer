package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This will pull the needed information from the database.
 *
 */

public class DatabaseInfo {
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.sqlite.JDBC";  
    static final String DB_URL = "jdbc:sqlite:Game.db";
    
    //Checks the login credentials.
    public static boolean checkLogin (String Username, String Password){
        
        boolean GoodLogin;
        String HashedPassword = PasswordHashing.PasswordHashing(Password);
        String PassCheck;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

             //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT PlayerPassword From PlayerTable WHERE "
                    + "PlayerUsername = '"+Username+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            PassCheck = rs.getString("PlayerPassword");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            
            if(PassCheck.equals(HashedPassword)){
                GoodLogin = true;
            }
            else{
                GoodLogin = false;
            }
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        GoodLogin = false;
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
        GoodLogin = false;
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
            
        return GoodLogin;
    }
    
    //Gets the Character's Level from the appropriate table and row using the
    //Username as a variable to determine which table to access.
    public static int getCharacterLevel(String Username, int CharacterID){
        
        int CharacterLevel = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Level From "+Username+" WHERE "
                    + "CharacterID = "+CharacterID+";";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            CharacterLevel = rs.getInt("Level");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return CharacterLevel;
    }
    
    //Gets the Character's Name from the appropriate table and row using the
    //Username as a variable to determine which table to access.
    public static String getCharacterName (String Username, int CharacterID){
        
        String CharacterName = null;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Name From "+Username+" WHERE "
                    + "CharacterID = "+CharacterID+";";
            rs = stmt.executeQuery(sql);          
            
            //STEP 4.5: .
            CharacterName = rs.getString("Name");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return CharacterName;
    }
    
    //Gets the Character's Strength from the appropriate table and row using the
    //Username as a variable to determine which table to access.
    public static int getCharacterStrength (String Username, int CharacterID){
        
        int CharacterStrength = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Strength FROM "+Username+" WHERE "
                    + "CharacterID = '"+CharacterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            CharacterStrength = rs.getInt("Strength");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return CharacterStrength;
    }
    
    //Gets the Character's Endurance from the appropriate table and row using the
    //Username as a variable to determine which table to access.
    public static int getCharacterEndurance (String Username, int CharacterID){
        
        int CharacterEndurance = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Endurance FROM "+Username+" WHERE "
                    + "CharacterID = '"+CharacterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            CharacterEndurance = rs.getInt("Endurance");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return CharacterEndurance;
    }
    
    //Gets the Character's Health from the appropriate table and row using the
    //Username as a variable to determine which table to access.
    public static int getCharacterHealth (String Username, int CharacterID){
        
        int CharacterHealth = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Health FROM "+Username+" WHERE "
                    + "CharacterID = '"+CharacterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            CharacterHealth = rs.getInt("Health");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return CharacterHealth;
    }
    
    //Gets the Character's Current Exp from the appropriate table and row using the
    //Username as a variable to determine which table to access.
    public static int getCharacterCurrentExp (String Username, int CharacterID){
        
        int CharacterCurrentExp = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT CurrentExp FROM "+Username+" WHERE "
                    + "CharacterID = '"+CharacterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            CharacterCurrentExp = rs.getInt("CurrentExp");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return CharacterCurrentExp;
    }
    
    //Gets the Character's Needed Exp for next level from the appropriate table
    //and row using the Username as a variable to determine which table to access.
    public static int getCharacterNeededExp (String Username, int CharacterID){
        
        int CharacterNeededExp = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT NeededExp FROM "+Username+" WHERE "
                    + "CharacterID = '"+CharacterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            CharacterNeededExp = rs.getInt("NeededExp");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return CharacterNeededExp;
    }
    
    //Gets the Character's Current Floor from the appropriate table and row using the
    //Username as a variable to determine which table to access.
    public static int getCharacterCurrentFloor (String Username, int CharacterID){
        
        int CharacterCurrentFloor = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT CurrentFloor FROM "+Username+" WHERE "
                    + "CharacterID = '"+CharacterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            CharacterCurrentFloor = rs.getInt("CurrentFloor");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return CharacterCurrentFloor;
    }
    
    //Uses the Floor as the MonsterID and finds the correct Name for the Monster.
    public static String getMonsterName (int MonsterID){
        
        String MonsterName = null;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT MonsterName FROM EnemiesTable WHERE "
                    + "MonsterID = '"+MonsterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            MonsterName = rs.getString("MonsterName");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return MonsterName;
    }
    
    //Uses the Floor as the MonsterID and finds the correct Strength for the Monster.
    public static int getMonsterStrength (int MonsterID){
        
        int MonsterStrength = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT MonsterStrength FROM EnemiesTable WHERE "
                    + "MonsterID = '"+MonsterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            MonsterStrength = rs.getInt("MonsterStrength");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return MonsterStrength;
    }
    
    //Uses the Floor as the MonsterID and finds the correct Endurance for the Monster.
    public static int getMonsterEndurance (int MonsterID){
        
        int MonsterEndurance = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT MonsterEndurance FROM EnemiesTable WHERE "
                    + "MonsterID = '"+MonsterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            MonsterEndurance = rs.getInt("MonsterEndurance");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return MonsterEndurance;
    }
    
    //Uses the Floor as the MonsterID and finds the correct Health for the Monster.
    public static int getMonsterHealth (int MonsterID){
        
        int MonsterHealth = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT MonsterHealth FROM EnemiesTable WHERE "
                    + "MonsterID = '"+MonsterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            MonsterHealth = rs.getInt("MonsterHealth");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return MonsterHealth;
    }
    
    //Uses the Floor as the MonsterID and finds the correct Exp for the Monster.
    public static int getMonsterExp (int MonsterID){
        
        int MonsterExp = 0;
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: This pulls the information for PlayerUsername from the 
            //database.
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT MonsterExp FROM EnemiesTable WHERE "
                    + "MonsterID = '"+MonsterID+"';";
            rs = stmt.executeQuery(sql);
            
            //STEP 4.5: .
            MonsterExp = rs.getInt("MonsterExp");

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
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
        
        return MonsterExp;
    }
}