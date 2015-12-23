package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Title extends JPanel
{
    
    private JLabel Title;
    
    public Title(){
        
        //Set Varying Stats panel.
        Dimension TitleDimension = new Dimension(600, 100);
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.lightGray));
        this.setVisible(true);
        this.setBackground(Color.black);
        this.setPreferredSize(TitleDimension);
        
        //Sets the Title to this Panel.
        Title = new JLabel();
        Title.setText("Tower Explorer");
        Title.setFont( new Font("Bookman Old Style", Font.PLAIN, 50));
        Title.setForeground(Color.YELLOW);
        this.add(Title);
        
    }
}