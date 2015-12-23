package panels;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Options extends JPanel{
    
    final URI uri = new URI("http://www.liquidcoding.biz/midnightoilinc.html");
    JLabel Thanks;
    JButton LinkToWebsite;
    private GridBagLayout OptionsLayout;
    GridBagConstraints c = new GridBagConstraints();
    
    public Options() throws URISyntaxException{
        
        OptionsLayout = new GridBagLayout();
        
        //Set up the Menu Bar panel.
        Dimension OptionsDimension = new Dimension(200, 300);
        this.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.lightGray));
        this.setVisible(true);
        this.setBackground(Color.yellow);
        this.setLayout(OptionsLayout);
        this.setPreferredSize(OptionsDimension);
        
        c.insets = new Insets(3,3,3,3);
        
        //Creates a Label displaying a thank you message to the player.
        Thanks = new JLabel();
        Thanks.setText("Thank you for playing Tower Explorer.");
        c.gridx = 5;
        c.gridy = 5;
        //Sets the Font,style, and size.
        Thanks.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
        //Sets the color of the text.
        Thanks.setForeground(Color.BLACK);
        this.add(Thanks, c);
        
        //Creates a Button that will act as a link to the game's website.
        LinkToWebsite = new JButton();
        LinkToWebsite.setText("<HTML>Click the <FONT color=\"#000099\"><U>link"
                + "</U></FONT>" + " to go to the game website.<HTML>");
        //Makes the normal button outlines go away.
        LinkToWebsite.setBorderPainted(false);
        //Makes the normal background of a button to be seethrough.
        LinkToWebsite.setOpaque(false);
        //Makes it so that when you hover over the button you will see the uri.
        LinkToWebsite.setToolTipText(uri.toString());
        LinkToWebsite.addActionListener(new OpenUrlAction());
        c.gridx = 5;
        c.gridy = 7;
        c.insets = new Insets(3,3,3,3);
        //Sets the Font,style, and size.
        LinkToWebsite.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));        
        this.add(LinkToWebsite, c);
    }
    
    private class OpenUrlAction implements ActionListener{
        
        @Override 
        public void actionPerformed(ActionEvent e){
            open(uri);
        }
    }
    
    private static void open(URI uri){
        if (Desktop.isDesktopSupported()){
            try{
                Desktop.getDesktop().browse(uri);
            }
            catch (IOException e){}
        }
    }
}