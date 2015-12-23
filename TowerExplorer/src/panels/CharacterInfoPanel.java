package panels;

import java.awt.*;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CharacterInfoPanel extends JPanel
{
    private CharacterData CharacterData;
    private Options Options;
    
    public CharacterInfoPanel() throws URISyntaxException{
        
        //Set up the Character Information panel.
        Dimension CharacterInfoDimension = new Dimension(200, 500);
        this.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.lightGray));
        this.setVisible(true);
        this.setBackground(Color.green);
        this.setPreferredSize(CharacterInfoDimension);
        
        /*Changes the default layout of jpanels from FlowLayout to BorderLayout.
          Without this the Options panel will not set right.*/
        this.setLayout(new BorderLayout());
        
        
    }
}