package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import libs.DatabaseInfo;

public class CharacterSelect extends JPanel 
{
    private GridBagLayout SelectLayout;
    public String Username;
    JLabel Title;
    public JButton DeleteCharacter;
    JButton ExitGame;
    public JButton Character1;
    public JButton Character2;
    public JButton Character3;
    public JButton Character4;
    public JButton Character1Create;
    public JButton Character2Create;
    public JButton Character3Create;
    public JButton Character4Create;
    public boolean Character1Found;
    public boolean Character2Found;
    public boolean Character3Found;
    public boolean Character4Found;
    String Character1Info;
    String Character2Info;
    String Character3Info;
    String Character4Info;
    String CreateCharacter;
    int Character1Lvl;
    String Character1Name;
    int Character1FloorLvl;
    int Character2Lvl;
    String Character2Name;
    int Character2FloorLvl;
    int Character3Lvl;
    String Character3Name;
    int Character3FloorLvl;
    int Character4Lvl;
    String Character4Name;
    int Character4FloorLvl;
    
    public CharacterSelect(){
        
        SelectLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        //Set Character Select panel.
        Dimension CharacterSelectDimension = new Dimension(600,600);
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.lightGray));
        this.setVisible(true);
        this.setPreferredSize(CharacterSelectDimension);
        this.setLayout(SelectLayout);
        this.setOpaque(false);
        
        ActionListener listener = new ButtonListener();
                
        CreateCharacter = "Create Character";
        
        Title = new JLabel();
        Title.setText("Character Select");
        c.gridx = 2;
        c.gridy = 0;
        Title.setFont( new Font("Bookman Old Style", Font.PLAIN, 40));
        c.insets = new Insets(3,3,175,3);
        Title.setForeground(Color.YELLOW);
        this.add(Title, c);

        Character1 = new JButton();
        Character1.setActionCommand("Character1");

        Character1Create = new JButton(CreateCharacter);
        Character1Create.setActionCommand("Create Character");
        
        Character2 = new JButton();
        Character2.setActionCommand("Character2"); 
        
        Character2Create = new JButton(CreateCharacter);
        Character2.setActionCommand("Create Character");

        Character3 = new JButton();
        Character3.setActionCommand("Character3");     

        Character3Create = new JButton(CreateCharacter);
        Character3.setActionCommand("Create Character");

        Character4 = new JButton();
        Character4.setActionCommand("Character4");

        Character4Create = new JButton(CreateCharacter);
        Character4.setActionCommand("Create Character");
        
        //This allows the player to reset a character to all nulls.
        DeleteCharacter = new JButton("Delete");
        DeleteCharacter.setActionCommand("Delete");
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(30,3,3,3);
        this.add(DeleteCharacter, c);
        
        //This button exits the game.
        ExitGame = new JButton("Exit");
        ExitGame.setActionCommand("Exit");
        ExitGame.setMnemonic(KeyEvent.VK_X);
        ExitGame.addActionListener(listener);
        c.gridx = 3;
        c.gridy = 5;
        c.insets = new Insets(30,3,3,3);
        this.add(ExitGame, c);
    }
    
    //Gets the Username needed to pull the appropriate character information.
    public void AccountSelected(String AccountSelected){
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,20,3);
        
        Username = AccountSelected;
        for(int i=1; i<5; i++){
            if (i==1){
                Character1Name = DatabaseInfo.getCharacterName(Username, 1);
                Character1Lvl = DatabaseInfo.getCharacterLevel(Username, 1);
                Character1Name = DatabaseInfo.getCharacterName(Username, 1);
                Character1FloorLvl = DatabaseInfo.getCharacterCurrentFloor(Username, 1);
                if (Character1Name==null){
                    Character1Found = false;
                    this.remove(Character1);
                    this.validate();
                    c.gridx = 2;
                    c.gridy = 1;
                    this.add(Character1Create,c);
                }
                else {
                    Character1Found = true;
                    Character1Info = "Level: " + Character1Lvl + "  Character Name: " +
                    Character1Name + "   Floor Level: " + Character1FloorLvl;
                    this.remove(Character1Create);
                    this.validate();
                    c.gridx = 2;
                    c.gridy = 1;
                    Character1.setText(Character1Info);
                    this.add(Character1,c);
                }
            }
            else if (i==2){
                Character2Name = DatabaseInfo.getCharacterName(Username, 2);
                Character2Lvl = DatabaseInfo.getCharacterLevel(Username, 2);
                Character2Name = DatabaseInfo.getCharacterName(Username, 2);
                Character2FloorLvl = DatabaseInfo.getCharacterCurrentFloor(Username, 2);
                if (Character2Name==null){
                    Character2Found = false;
                    this.remove(Character2);
                    this.validate();
                    c.gridx = 2;
                    c.gridy = 2;
                    this.add(Character2Create,c);
                }
                else {
                    Character2Found = true;
                    Character2Info = "Level: " + Character2Lvl + "  Character Name: " +
                    Character2Name + "   Floor Level: " + Character2FloorLvl;
                    this.remove(Character2Create);
                    this.validate();
                    c.gridx = 2;
                    c.gridy = 2;
                    Character2.setText(Character2Info);
                    this.add(Character2,c);
                }
            }
            else if (i==3){
                Character3Name = DatabaseInfo.getCharacterName(Username, 3);
                Character3Lvl = DatabaseInfo.getCharacterLevel(Username, 3);
                Character3Name = DatabaseInfo.getCharacterName(Username, 3);
                Character3FloorLvl = DatabaseInfo.getCharacterCurrentFloor(Username, 3);
                if (Character3Name==null){
                    Character3Found = false;
                    this.remove(Character3);
                    this.validate();
                    c.gridx = 2;
                    c.gridy = 3;
                    this.add(Character3Create,c);
                }
                else {
                    Character3Found = true;
                    Character3Info = "Level: " + Character3Lvl + "  Character Name: " +
                    Character3Name + "   Floor Level: " + Character3FloorLvl;
                    this.remove(Character3Create);
                    this.validate();
                    c.gridx = 2;
                    c.gridy = 3;
                    Character3.setText(Character3Info);
                    this.add(Character3,c);
                }
            }
            else if (i==4){
                Character4Name = DatabaseInfo.getCharacterName(Username, 4);
                Character4Lvl = DatabaseInfo.getCharacterLevel(Username, 4);
                Character4Name = DatabaseInfo.getCharacterName(Username, 4);
                Character4FloorLvl = DatabaseInfo.getCharacterCurrentFloor(Username, 4);
                if (Character4Name==null){
                    Character4Found = false;
                    this.remove(Character4);
                    this.validate();
                    c.gridx = 2;
                    c.gridy = 4;
                    this.add(Character4Create,c);
                }
                else {
                    Character4Found = true;
                    Character4Info = "Level: " + Character4Lvl + "  Character Name: " +
                    Character4Name + "   Floor Level: " + Character4FloorLvl;
                    this.remove(Character4Create);
                    this.validate();
                    c.gridx = 2;
                    c.gridy = 4;
                    Character4.setText(Character4Info);
                    this.add(Character4,c);
                }
            }
         }

        this.validate();
        
        return;
    }
    
    private class ButtonListener implements ActionListener{
     
        @Override
        public void actionPerformed(ActionEvent e) {
        
            
            if ("Exit".equals(e.getActionCommand())) {
                System.exit(0);
            }        
        }
    }
}