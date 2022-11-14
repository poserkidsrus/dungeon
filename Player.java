
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
    private String stats;
    

    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        // initialise instance variables
        super(name);
        
        
        this.classLevel = 1;
        this.lifeTotal = 30;
        this.attackPower = 15;
        this.speed = 50;
        this.defenseLevel = 30;
        this.maxLife = 150;
        this.exp = 1;
        this.stats = String.join(System.getProperty("line.separator"),
        "Your Stats are: ",
        "Level: " + this.classLevel + "",
        "Health: " + this.lifeTotal + "",
        "Speed: " + this.speed +"",
        "Defense: " + this.defenseLevel+ "",
        "Attack: " +this.attackPower+ "",
        "Experience: " +this.exp+ "");
        
    }

    public void gainExp(int expAdd)
    {
        this.exp += expAdd;
    }

    public void setAttack(int atk)
    {
        this.attackPower += atk;
    }

    public void setLevel(int level)
    {
        this.classLevel += level;
    }

    public void setSpeed(int spd)
    {
        this.speed += spd;
    }

    public void setDefense(int dfn)
    {
        this.defenseLevel += dfn;
    }

    public int getLifeTotal()
    {
        return this.lifeTotal;
    }

    public void gainLife(int lifeGain)
    {
        // put your code here
        this.lifeTotal += lifeGain;
        
        if (lifeTotal >= maxLife)
        {
            this.lifeTotal = maxLife;
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

    public void setStats(int atk, int spd, int dfn, int hlth)
    {
        setAttack(atk);
        setSpeed(spd);
        setDefense(dfn);
        gainLife(hlth);
    }

    public String getStats()
    {
        return stats;
    }

}
