package libs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordHashing {
   
    public static String PasswordHashing(String PasswordToHash){
        
        String GeneratedPassword = null;
        
        try{
            //Create MessageDigest instance for SHA-1.
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            //Add password bytes to digest.
            md.update(PasswordToHash.getBytes());
            //Get the hash's bytes.
            //This bytes[] has bytes in decimal format.
            byte[] bytes = md.digest();
            //Convert it to hexadecimal format.
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<bytes.length;i++){
                
                sb.append(Integer.toString((bytes[i] & 0xff)+ 0x100, 16).substring(1));
                
            }
            GeneratedPassword = sb.toString();
        }
        catch(NoSuchAlgorithmException e){
            
            e.printStackTrace();
                    
        }
        
        return GeneratedPassword;
    }
    
}
