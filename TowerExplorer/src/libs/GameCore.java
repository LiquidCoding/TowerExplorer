package libs;

import javax.swing.JOptionPane;
import seniorgame.TowerExplorer;

public class GameCore extends TowerExplorer{
    
    public static Monster[] Monsters;
    public int MonstersAlive;
    public Character Character;
    public Object[] StatOptions = {"Strength", "Endurance", "Health"};
    public Object[] UpOrDown = {"Go up a floor", "Go down a floor"};
    boolean alive;
    
    public void initCharacter(){
      Character = new Character();
    }

    public void GameArea()
    {
        // This has the paladin character game
        int playerAttack = 0;
        int playerDefence = 0;
        int enemyAttack = 0;
        int enemyDefence = 0; 
        int i = 0;

        
        while (Character.Alive)
        {
            //GameWindow.PopulateFloor(Character.FloorLvl);
            
            while (MonstersAlive > 0)
            {
                
                //Attack area  
                playerAttack = Character.attackSimulator();
                playerDefence = Character.defenseSimulator();
                        
                enemyAttack = Monsters[i].attackSimulator();
                enemyDefence = Monsters[i].defenseSimulator();

                if (playerAttack > enemyDefence)
                {
                    Monsters[i].Damaged(playerAttack - enemyDefence);
                }
                        
                if (enemyDefence >= playerAttack)
                {
                    JOptionPane.showMessageDialog(null,"Player attack was Blocked!");
                }
                        
                if (playerDefence >= enemyAttack)
                {
                    JOptionPane.showMessageDialog(null,"Enemy attack was Blocked!");
                }
                        
                if (enemyAttack > playerDefence)
                {
                    Character.Damaged(enemyAttack - playerDefence);
                }
                
                //WIN OR LOSE AREA
                if (!Monsters[i].alive)
                {
                    Character.CurrentExp += Monsters[i].Exp;
                }
                
                while (Character.NeededExp <= Character.CurrentExp)
                {
                    //System.out.println("LEVEL UP!");
                    Character.Level++;
                    Object Choice = JOptionPane.showInputDialog(null, "Which stat do you wish to raise?", 
                        "You are now level "+Character.Level+"!", 3, null, StatOptions, StatOptions[0]);
                
                    //This should increase the Strength stat.
                    if (Choice.equals(StatOptions[0]))
                    {
                        Character.Strength++;
                        Character.CurrentHealth = Character.Health;
                        Character.LevelUp();
                            
                    }
                    else if (Choice.equals(StatOptions[1]))
                    {
                        Character.Endurance++;
                        Character.CurrentHealth = Character.Health;
                        Character.LevelUp();
                    }
                    else if (Choice.equals(StatOptions[2]))
                    {
                        Character.Health += 10;
                        Character.CurrentHealth = Character.Health;
                        Character.LevelUp();
                    }
                }
                //This is for Current Character Health
                if (!Character.Alive)
                {
                MonstersAlive = 0;
                }
            }
            
            Object FloorChoice = JOptionPane.showInputDialog(null, "Which way do you want to go?", 
                "Congratulations!", 3, null, UpOrDown, UpOrDown[0]);
            
            if (FloorChoice.equals(UpOrDown[0]))
            {
                Character.FloorLvl++;
            }
            else
            {
                Character.FloorLvl--;
            }
        }
            
        JOptionPane.showMessageDialog(null, "You Lose!");
                
        super.PanelSwitch(1); 
    }
    
    public void MonsterCreator(int i, int FloorLvl){
        
        Monsters[i] = new Monster();
        Monsters[i].Name = DatabaseInfo.getMonsterName(FloorLvl);
        Monsters[i].Strength = DatabaseInfo.getMonsterStrength(FloorLvl);
        Monsters[i].Endurance = DatabaseInfo.getMonsterEndurance(FloorLvl);
        Monsters[i].CurrentHealth = DatabaseInfo.getMonsterHealth(FloorLvl);
        Monsters[i].Exp = DatabaseInfo.getMonsterExp(FloorLvl);
        Monsters[i].Xpos = i;
        Monsters[i].Ypos = i-i;
        Monsters[i].alive = true;
        
        MonstersAlive++;
        
        return;
    }       
}