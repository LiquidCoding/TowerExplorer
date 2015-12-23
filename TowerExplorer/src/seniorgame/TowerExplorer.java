package seniorgame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import libs.DatabaseCUD;
import libs.DatabaseInfo;
import panels.*;

/*Brent Wood, Jay Morgan
 *2.24.2014
 * 
 */

public class TowerExplorer extends JFrame
{

    private ContentPanel ContentPanel;
    private Login Login;
    private CharacterSelect CharacterSelect;
    private Title Title;
    public GameWindow GameWindow;
    public CharacterInfoPanel CharacterInfoPanel;
    public CharacterData CharacterData;
    private Options Options;
    int width = 600;
    int height = 600;
    public String Username;
    String Password;
    String VerifyPassword;
    boolean GoodLogin;
    
    /*Create the text that will be used to call the correct panel to be shown
        * from the ContentPanel.*/
    final String LOGINPANEL = "Login Screen";
    final String CHARACTERSELECT = "Character Selection";
    final String GAME = "Game";
    
    public void TowerExplorer() throws IOException, URISyntaxException{
        
        this.setTitle("Tower Explorer");
        this.setSize(width, height);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //Brings up the Splash Screen.
        SplashScreen();
        
        //Create the panel that contains the other panels.
        ContentPanel = new ContentPanel();
 
        //Create a Panel to hold the Game Components.
        JPanel GameContainer = new JPanel();
        GameContainer.setLayout(new BorderLayout());
        GameContainer.setOpaque(false);
        
        //Sets the MainMenu class as a panel. The MainMenu class extends panel.
        Login = new Login();
        
        //Set Character Select panel.
        CharacterSelect = new CharacterSelect();
        
        //Set up the Game panel.
        GameWindow = new GameWindow();
        
        //Set the Title bar for the game.
        Title = new Title();

        //Set up the Character Information panel.
        CharacterInfoPanel = new CharacterInfoPanel();
        
        
        //Set up the Menu Bar panel.
        Options = new Options();
        
        //Set up the Character Data panel.
        CharacterData = new CharacterData();
        
        //This is adding panels to other panels
        ContentPanel.add(Login, LOGINPANEL);
        ContentPanel.add(CharacterSelect, CHARACTERSELECT);
        ContentPanel.add(GameContainer, GAME);   
        
        CharacterInfoPanel.add(CharacterData, BorderLayout.NORTH);
        CharacterInfoPanel.add(Options, BorderLayout.SOUTH);
        
        GameContainer.add(GameWindow, BorderLayout.LINE_START);
        GameContainer.add(Title, BorderLayout.NORTH);
        GameContainer.add(CharacterInfoPanel, BorderLayout.LINE_END);
        
        this.add(ContentPanel);
       
        //Creates a way to listen for the buttons to change the panels.
        ActionListener listener = new ButtonListener(); 
        
        Login.Login.addActionListener(listener);
        
        Login.CreateAccount.addActionListener(listener);
        
        CharacterSelect.Character1.addActionListener(listener);
        CharacterSelect.Character2.addActionListener(listener);
        CharacterSelect.Character3.addActionListener(listener);
        CharacterSelect.Character4.addActionListener(listener);
        
        CharacterSelect.DeleteCharacter.addActionListener(listener);
        
        CharacterSelect.Character1Create.addActionListener(listener);
        CharacterSelect.Character2Create.addActionListener(listener);
        CharacterSelect.Character3Create.addActionListener(listener);
        CharacterSelect.Character4Create.addActionListener(listener);
        
        PanelSwitch(1);
        
    }
    
    private class ButtonListener implements ActionListener{
     
        @Override
        public void actionPerformed(ActionEvent e) {         
            
            if("Login Screen".equals(e.getActionCommand())){
                PanelSwitch(1);
            }
            else if ("Login".equals(e.getActionCommand())){
                Username = Login.UsernameInput.getText();
                Password = Login.PasswordInput.getText();
                GoodLogin = DatabaseInfo.checkLogin(Username, Password);
                
                if (GoodLogin){
                    PanelSwitch(2);
                    CharacterSelect.AccountSelected(Username);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Username" +
                            " or Password.");
                    Login.UsernameInput.setText(null);
                    Login.PasswordInput.setText(null);
                }
            }
            else if ("Character1".equals(e.getActionCommand())){
                PanelSwitch(3);
                CharacterData.CharacterInformation(Username, 1);
                GameWindow.PopulateCharacter(Username, 1);
            }
            else if ("Character2".equals(e.getActionCommand())){
                PanelSwitch(3);
                CharacterData.CharacterInformation(Username, 2);
                GameWindow.PopulateCharacter(Username, 2);
            }
            else if ("Character3".equals(e.getActionCommand())){
                PanelSwitch(3);
                CharacterData.CharacterInformation(Username, 3);
                GameWindow.PopulateCharacter(Username, 3);
            }
            else if ("Character4".equals(e.getActionCommand())){
                PanelSwitch(3);
                CharacterData.CharacterInformation(Username, 4);
                GameWindow.PopulateCharacter(Username, 4);
            }
            else if ("Create Character".equals(e.getActionCommand())){
                boolean Success = DatabaseCUD.CreateCharacter(CharacterSelect.Username, 
                        CharacterSelect.Character1Found, CharacterSelect.Character2Found, 
                        CharacterSelect.Character3Found, CharacterSelect.Character4Found);
                
                if (Success){
                    CharacterSelect.AccountSelected(Username);
                    JOptionPane.showMessageDialog(null, Username+" your character "
                            + "has been created.");}
                else{
                    JOptionPane.showMessageDialog(null, Username+" all characters "
                            + "already exist.");
                }
            }
            else if ("Delete".equals(e.getActionCommand())){
                
                String Character1 = DatabaseInfo.getCharacterName(Username, 1);
                String Character2 = DatabaseInfo.getCharacterName(Username, 2);
                String Character3 = DatabaseInfo.getCharacterName(Username, 3);
                String Character4 = DatabaseInfo.getCharacterName(Username, 4);
                
                Object[] CharacterDeletion = { "Character 1 " + Character1, "Character 2 " +
                Character2, "Character 3 " + Character3, "Character 4 " +
                Character4};
                
                Object Choice = JOptionPane.showInputDialog(null, "Which character would you like "
                        + "to delete?","Character Delection.", 3, null, CharacterDeletion, CharacterDeletion[0]);
                
                if (Choice.equals(CharacterDeletion[0])){
                    String Name = DatabaseInfo.getCharacterName(Username, 1);
                    boolean Success = DatabaseCUD.Delete(Username, 1, Name);
                
                    if(Success){
                        CharacterSelect.AccountSelected(Username);
                        JOptionPane.showMessageDialog(null, "Character 1 has been deleted.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Character was not deleted.");
                    }
                }
                else if (Choice.equals(CharacterDeletion[1])){
                    String Name = DatabaseInfo.getCharacterName(Username, 2);
                    boolean Success = DatabaseCUD.Delete(Username, 2, Name);
                
                    if(Success){
                        CharacterSelect.AccountSelected(Username);
                        JOptionPane.showMessageDialog(null, "Character 2 has been deleted.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Character was not deleted.");
                    }
                }
                else if (Choice.equals(CharacterDeletion[3])){
                    String Name = DatabaseInfo.getCharacterName(Username, 3);
                    boolean Success = DatabaseCUD.Delete(Username, 3, Name);
                
                    if(Success){
                        CharacterSelect.AccountSelected(Username);
                        JOptionPane.showMessageDialog(null, "Character 3 has been deleted.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Character was not deleted.");
                    }
                }
                else if (Choice.equals(CharacterDeletion[4])){
                    String Name = DatabaseInfo.getCharacterName(Username, 4);
                    boolean Success = DatabaseCUD.Delete(Username, 4, Name);
                
                    if(Success){
                        CharacterSelect.AccountSelected(Username);
                        JOptionPane.showMessageDialog(null, "Character 4 has been deleted.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Character was not deleted.");
                    }
                }
            }
            else if ("Create Account".equals(e.getActionCommand())){
                Username = Login.UsernameInput.getText();
                Password = Login.PasswordInput.getText();
                VerifyPassword = Login.VerifyPasswordInput.getText();
                
                if (Password.equals(VerifyPassword)){
                    boolean Success = DatabaseCUD.CreateUser(Username,Password);
                    
                    if (Success){
                        JOptionPane.showMessageDialog(null, "Account created. "
                                + "Please login to begin playing.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Account already exits. "
                                + "Please either sign-in or created a different account");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Password and Verifying"+ 
                            " Password do not match.");
                    Login.PasswordInput.setText(null);
                    Login.VerifyPasswordInput.setText(null);
                }
            } 
        }
    }
    
    public void PanelSwitch(int PanelNum){
        
        CardLayout ContentLayout = (CardLayout)(ContentPanel.getLayout());
        
        switch(PanelNum){
               case 1:
                   ContentLayout.first(ContentPanel);
                   break;
               case 2:
                   ContentLayout.show(ContentPanel, CHARACTERSELECT);
                   break;
               case 3:
                   ContentLayout.show(ContentPanel, GAME);
                   break;
               default:
                   ContentLayout.first(ContentPanel);
                   break;
        }
    }
 
    public void SplashScreen() throws IOException{
        
        JWindow window = new JWindow();

        BufferedImage image = ImageIO.read(new File("src/images/MehSplashImage.jpg"));
        
        window.getContentPane().add(
                
            new JLabel("", new ImageIcon(image), SwingConstants.CENTER));
            window.setBounds((this.getX() - 25), (this.getY() - 25), 650, 650);
        
        window.setVisible(true);

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        window.setVisible(false);

        window.dispose();
    }
    
    public static void main(String[] args) throws IOException, URISyntaxException{
        
        seniorgame.TowerExplorer StartGame = new TowerExplorer();
        StartGame.TowerExplorer();
    }
}