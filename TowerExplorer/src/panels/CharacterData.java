package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import libs.*;
import libs.Character;

public class CharacterData extends JPanel
{
    private Character Character;
    private GameCore GameCore;
    private GridBagLayout CharacterDataLayout;
    JLabel CharacterCurrentFloorLabel;
    public static int CharacterCurrentFloor;
    JLabel CharacterNameLabel;
    public String CharacterName;
    JLabel CharacterLvlLabel;
    public static int CharacterLvl;
    JLabel CharacterHealthLabel;
    public static int CharacterMaxHealth;
    public static int CharacterCurrentHealth;
    JLabel CharacterStrengthLabel;
    public static int CharacterStrength;
    JLabel CharacterEnduranceLabel;
    public static int CharacterEndurance;
    JLabel CharacterExpLabel;
    public static int CharacterCurrentExp;
    public static int CharacterNeededExp;
    public String Username;
    public int CharacterSelected;
    public boolean ready = false;
    String FloorText;
    String NameText;
    String LvlText;
    String HealthText;
    String StrengthText;
    String EnduranceText;
    String ExpText;
    
    public CharacterData()
    {
        CharacterDataLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(3,3,3,3);
        
        //Set up the Menu Bar panel.
        Dimension CharacterDataDimension = new Dimension(200, 200);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.lightGray));
        this.setVisible(true);
        this.setLayout(CharacterDataLayout);
        this.setBackground(Color.blue);
        this.setPreferredSize(CharacterDataDimension);

        
        //Creates the Label for the Character Name.
        CharacterCurrentFloorLabel = new JLabel();
        c.gridx = 0;
        c.gridy = 0;
        CharacterCurrentFloorLabel.setText("Current Floor: " + CharacterCurrentFloor);
        CharacterCurrentFloorLabel.setFont( new Font("Bookman Old Style", Font.PLAIN, 10));
        CharacterCurrentFloorLabel.setForeground(Color.YELLOW);
        this.add(CharacterCurrentFloorLabel, c);
        
        //Creates the Label for the Character Name.
        CharacterNameLabel = new JLabel();
        c.gridx = 0;
        c.gridy = 1;
        CharacterNameLabel.setText("Character Name: " + CharacterName);
        CharacterNameLabel.setFont( new Font("Bookman Old Style", Font.PLAIN, 10));
        CharacterNameLabel.setForeground(Color.YELLOW);
        this.add(CharacterNameLabel, c);
        
        //Creates the Label for the Character Level.
        CharacterLvlLabel = new JLabel();
        c.gridx = 0;
        c.gridy = 2;
        CharacterLvlLabel.setText("Character Level: " + CharacterLvl);
        CharacterLvlLabel.setFont( new Font("Bookman Old Style", Font.PLAIN, 10));
        CharacterLvlLabel.setForeground(Color.YELLOW);
        this.add(CharacterLvlLabel, c);
        
        //Creates the Label for the Character's Max Health and Current Health.
        CharacterHealthLabel = new JLabel();
        c.gridx = 0;
        c.gridy = 3;
        CharacterHealthLabel.setText("Character Health: " + CharacterCurrentHealth + " / " + CharacterMaxHealth );
        CharacterHealthLabel.setFont( new Font("Bookman Old Style", Font.PLAIN, 10));
        CharacterHealthLabel.setForeground(Color.YELLOW);
        this.add(CharacterHealthLabel, c);
        
        //Creates the Label for the Character Strength.
        CharacterStrengthLabel = new JLabel();
        c.gridx = 0;
        c.gridy = 4;
        CharacterStrengthLabel.setText("Character Strength: " + CharacterStrength);
        CharacterStrengthLabel.setFont( new Font("Bookman Old Style", Font.PLAIN, 10));
        CharacterStrengthLabel.setForeground(Color.YELLOW);
        this.add(CharacterStrengthLabel, c);
        
        //Creates the Label for the Character Endurance.
        CharacterEnduranceLabel = new JLabel();
        c.gridx = 0;
        c.gridy = 5;
        CharacterEnduranceLabel.setText("Character Endurance: " + CharacterEndurance);
        CharacterEnduranceLabel.setFont( new Font("Bookman Old Style", Font.PLAIN, 10));
        CharacterEnduranceLabel.setForeground(Color.YELLOW);
        this.add(CharacterEnduranceLabel, c);
        
        //Creates the Label for the Character Name.
        CharacterExpLabel = new JLabel();
        c.gridx = 0;
        c.gridy = 6;
        CharacterExpLabel.setText("Character Experience: " + CharacterCurrentExp + " / " + CharacterNeededExp);
        CharacterExpLabel.setFont( new Font("Bookman Old Style", Font.PLAIN, 10));
        CharacterExpLabel.setForeground(Color.YELLOW);
        this.add(CharacterExpLabel, c);
   
    }
    
    public void CharacterInformation(String NewUsername, int NewCharacterSelected){
        
        Username = NewUsername;
        CharacterSelected = NewCharacterSelected;
        
        CharacterCurrentFloor = DatabaseInfo.getCharacterCurrentFloor(Username,CharacterSelected);
        CharacterName = DatabaseInfo.getCharacterName(Username,CharacterSelected);
        CharacterLvl = DatabaseInfo.getCharacterLevel(Username,CharacterSelected);
        CharacterMaxHealth = DatabaseInfo.getCharacterHealth(Username,CharacterSelected);
        CharacterCurrentHealth = CharacterMaxHealth;
        CharacterStrength = DatabaseInfo.getCharacterStrength(Username,CharacterSelected);
        CharacterEndurance = DatabaseInfo.getCharacterEndurance(Username,CharacterSelected);
        CharacterCurrentExp = DatabaseInfo.getCharacterCurrentExp(Username,CharacterSelected);
        CharacterNeededExp = DatabaseInfo.getCharacterNeededExp(Username,CharacterSelected);
        
        FloorText = "Current Floor: " + CharacterCurrentFloor;
        CharacterCurrentFloorLabel.setText(FloorText);

        NameText = "Character Name: " + CharacterName;
        CharacterNameLabel.setText(NameText);

        LvlText = "Character Level: " + CharacterLvl;
        CharacterLvlLabel.setText(LvlText);

        HealthText = "Character Health: " + CharacterCurrentHealth + " / " + CharacterMaxHealth;
        CharacterHealthLabel.setText(HealthText);

        StrengthText = "Character Strength: " + CharacterStrength;
        CharacterStrengthLabel.setText(StrengthText);

        EnduranceText = "Character Endurance: " + CharacterEndurance;
        CharacterEnduranceLabel.setText(EnduranceText);

        ExpText = "Character Experience: " + CharacterCurrentExp + " / " + CharacterNeededExp;
        CharacterExpLabel.setText(ExpText);

        ready = true;
        
        this.validate();
        
        return;
    }
    
    public void UpdateFloorLvl(int FloorLvl){
        
        FloorText = "Current Floor: " + (CharacterCurrentFloor = FloorLvl);
        CharacterCurrentFloorLabel.setText(FloorText);
        
        this.validate();
        
        return;
    }
    
    public void UpdateHealth(int NewCurrentHealth){
        
        HealthText = "Character Health: " + (CharacterCurrentHealth = NewCurrentHealth) + " / " + CharacterMaxHealth;
        CharacterHealthLabel.setText(HealthText);
        
        this.validate();
        
        return;
    }
    
    public class UpdateStats extends TimerTask{
        
        @Override
        public void run()
        {
            if (ready)
            {
                FloorText = "Current Floor: " + Character.FloorLvl;
                CharacterCurrentFloorLabel.setText(FloorText);

                NameText = "Character Name: " + Character.Name;
                CharacterNameLabel.setText(NameText);

                LvlText = "Character Level: " + Character.Level;
                CharacterLvlLabel.setText(LvlText);

                HealthText = "Character Health: " + Character.CurrentHealth + " / " + Character.Health;
                CharacterHealthLabel.setText(HealthText);

                StrengthText = "Character Strength: " + Character.Strength;
                CharacterStrengthLabel.setText(StrengthText);

                EnduranceText = "Character Endurance: " + Character.Endurance;
                CharacterEnduranceLabel.setText(EnduranceText);

                ExpText = "Character Experience: " + Character.CurrentExp + " / " + Character.NeededExp;
                CharacterExpLabel.setText(ExpText);
            }
        }
    }
}