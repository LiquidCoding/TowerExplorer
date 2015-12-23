package libs;

import javax.swing.JOptionPane;

public class Character{
    
    public String Username;
    public int CharacterID;
    public int FloorLvl;
    public String Name;
    public int Level;
    public int Strength;
    public int Endurance;
    public int CurrentHealth;
    public int Health;
    public int CurrentExp;
    public int NeededExp;
    public int Xpos;
    public int Ypos;
    public boolean Alive;

    
    //Takes the damage done by the player and subtracts the monster's health
    //by that amount.
    public boolean Damaged(int Damage){
        
        CurrentHealth -= Damage;
        
        if (CurrentHealth<=0){
            Alive = false;
        }
        else{
        JOptionPane.showMessageDialog(null, "You have taken "+Damage+" damage! "
                + "You currently have "+CurrentHealth+" Hitpoints remaining.");
        }
        
        return Alive;
    }
    
    public void getAction(){
        
        return;
    }
    
    public int attackSimulator()
    {
        
        /* Use characterStrength to find total
         * damage dealt this round
         */
        
        int dTwenty = RandomNumGen.d20(1);
        int attackDamage = dTwenty + Strength;
        return attackDamage;
    }
    
    public int defenseSimulator()
    {
        // This uses the twentyDieRoll and character to see if
        // defence is broken

        int dTwenty = RandomNumGen.d20(1);
        int defenceRoll = dTwenty + Endurance;
        return defenceRoll;
    }
    
    //Causes Character to level up.
    public void LevelUp()
    {
        /* Use playerLevel to find out how much xp is needed
         * to reach a level up
         */
        NeededExp = ((Level-1)*10) + (Level * 100);
        
        DatabaseCUD.Update(Username, Level, Strength, Endurance, Health, 
                CurrentExp, NeededExp, CurrentExp, CharacterID);
        
        return;
    }
    
}