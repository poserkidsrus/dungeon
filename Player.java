
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Encounter
{
    // instance variables - replace the example below with your own
    private int lifeTotal;
    private int classLevel;
    private int attackPower;
    private int speed;
    private int defenseLevel;
    private int maxLife;
    private int exp;
    

    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        // initialise instance variables
        super(name);
        lifeTotal = 30;
        classLevel = 1;
        attackPower = 15;
        speed = 50;
        defenseLevel = 30;
        maxLife = 150;
        exp = 0;
    }

    public void setLife(int lifeTotal)
    {
        this.lifeTotal = lifeTotal;
    }
    public int getLifeTotal()
    {
        return lifeTotal;
    }
    public void gainLife(int lifeGain)
    {
        // put your code here
        lifeTotal += lifeGain;
        
        if (lifeTotal >= maxLife)
        {
            lifeTotal = maxLife;
        }
        
    }
    public void gainLevel(int exp, int levelup)
    {
        if (exp == 100)
        {
            levelup = 1;
            classLevel += levelup;
        }
        
    }
    public int levelStat(int stat)
    {
        return classLevel;
    }
}
