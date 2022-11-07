
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.lang.Class;
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
        exp = 1;
        setStats("stats");
    }
    public void gainExp(int expAdd)
    {
        this.exp += expAdd;
    }
    public void setLife()
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
    public void gainLevel()
    {
        if (exp == 100)
        {
            int levelup = 1;
            this.classLevel += levelup;
        }
        
    }
    public int levelStat()
    {
        return classLevel;
    }
    public void setStats(String temp)
    {
        temp = "User:" + this.getName() + "\n Attack Power: " + this.attackPower +
            " \n Defense Level: " + this.defenseLevel + "\n Life Total: " +this.lifeTotal;
    }
 
    public void printStats()
    {
        this.setStats("stats");
        System.out.print(getStats());
    }
}
