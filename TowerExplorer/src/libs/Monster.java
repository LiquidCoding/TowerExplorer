package libs;


public class Monster {
    
    public String Name;
    public int Strength;
    public int Endurance;
    public int CurrentHealth;
    public int Exp;
    public int Xpos;
    public int Ypos;
    public boolean alive;

    
    //Takes the damage done by the player and subtracts the monster's health
    //by that amount.
    public boolean Damaged(int Damage){
        
        CurrentHealth -= Damage;
        
        if (CurrentHealth<=0){
            alive = false;
        }
        
        return alive;
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
}
