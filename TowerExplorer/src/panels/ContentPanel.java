package panels;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ContentPanel extends JPanel {
    
    BufferedImage TiledImage;
    private CardLayout ContentLayout;
    
    public ContentPanel() throws IOException{
        
        ContentLayout = new CardLayout();
        
        BufferedImage image = ImageIO.read(new File("src/images/Wall.jpg"));  
        new TiledImage(image);
        
        //BorderLayout() will allow other panels to be added to this one.
        this.setLayout(ContentLayout);
    } 

    @Override
    protected void paintComponent(Graphics g) {  
        int width = getWidth();  
        int height = getHeight();  
        for (int x = 0; x < width; x += TiledImage.getWidth()) {  
            for (int y = 0; y < height; y += TiledImage.getHeight()) {  
                g.drawImage(TiledImage, x, y, this);  
            }  
        }  
    }     

public class TiledImage {

        public TiledImage(BufferedImage image) {
            TiledImage = image;
        }
    }
}