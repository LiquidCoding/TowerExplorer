package libs;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Tile extends JLabel{
    
    public ImageIcon icon;
    public ImageIcon MainIcon;
    public ImageIcon SecondIcon;
    public String Name;
    public int Xpos;
    public int Ypos;
    
    
    public void setIcon(){
        
            icon = createImageIcon("src/images/"+Name+".jpg", Name);
        
        return;
    }
    
    //Returns an ImageIcon, or null if the path was invalid.
    public static ImageIcon createImageIcon(String path,
                                               String description) {
        java.net.URL imgURL = Tile.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
