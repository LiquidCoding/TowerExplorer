package panels;

import libs.Monster;
import libs.Character;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import libs.DatabaseInfo;
import libs.GameCore;
import libs.Tile;
import seniorgame.TowerExplorer;

public class GameWindow extends JPanel
{
    private GridBagLayout GameBoardLayout;
    public TowerExplorer TowerExplorer;
    public int FloorLvl;
    public GameCore GameCore;
    public Character Character;
    public boolean First = true;
    //An array that will hold every the information of every monster on the floor.
    public Monster[] Monsters;
    //A 10x10 array that will hold the labels for each space on the floor.
    public Tile[][] Tile = new Tile[9][9];
    
    GridBagConstraints c = new GridBagConstraints();
    
    public GameWindow(){
        
        GameBoardLayout = new GridBagLayout();
        
        //Set up the Game panel.
        Dimension GameDimension = new Dimension(400, 500);
        this.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.lightGray));
        this.setVisible(true);
        this.setPreferredSize(GameDimension);
        this.setLayout(GameBoardLayout);
        this.setOpaque(false);
        
        GameCore = new GameCore();
        GameCore.initCharacter();
        
    }
    
    public void PopulateFloor(int Floor){
        
        //Constructs each Monster for this floor.
        for (int i=0; i>10-(Floor-1);i++){
            
            GameCore.MonsterCreator(i, Floor);
                        
        }   
        
        for (int i=0; i>99; i++){
            
            if (i>GameCore.Monsters.length){
                if(First){
                Tile[i][0] = new Tile();
                }
                Tile[i][0].Name = GameCore.Monsters[i].Name;
                Tile[i][0].Xpos = GameCore.Monsters[i].Xpos;
                Tile[i][0].Ypos = GameCore.Monsters[i].Ypos;
                Tile[i][0].setIcon();
                c.gridx = Tile[i][0].Xpos;
                c.gridy = Tile[i][0].Ypos;
                this.add(Tile[i][0], c);
            }
            else{
                if(First){
                Tile[5][9] = new Tile();
                }
                Tile[5][9].Xpos = Character.Xpos = 5;
                Tile[5][9].Ypos = Character.Ypos = 9;
                Tile[5][9].setIcon();
            }
            if(First){
            First = !First;
            }
        }
    }
    
    public void PopulateCharacter(String Username, int CharacterSelected){
        
        GameCore.Character.Username = Username;
        GameCore.Character.CharacterID = CharacterSelected;
        GameCore.Character.FloorLvl = DatabaseInfo.getCharacterCurrentFloor(Username, CharacterSelected);
        GameCore.Character.Level = DatabaseInfo.getCharacterLevel(Username,CharacterSelected);
        GameCore.Character.CurrentHealth = GameCore.Character.Health = DatabaseInfo.getCharacterHealth(Username,CharacterSelected);
        GameCore.Character.Strength = DatabaseInfo.getCharacterStrength(Username,CharacterSelected);
        GameCore.Character.Endurance = DatabaseInfo.getCharacterEndurance(Username,CharacterSelected);
        GameCore.Character.CurrentExp = DatabaseInfo.getCharacterCurrentExp(Username,CharacterSelected);
        GameCore.Character.NeededExp = DatabaseInfo.getCharacterNeededExp(Username, CharacterSelected);
        GameCore.Character.Alive = true;
        
        FloorLvl = DatabaseInfo.getCharacterCurrentFloor(Username,CharacterSelected);
        
        GameCore.GameArea();
    }
}