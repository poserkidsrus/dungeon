
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
    private int health;
    private int classLevel;
    private int attack;
    private int speed;
    private int defense;
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
        this.health = 30;
        this.attack = 15;
        this.speed = 50;
        this.defense = 30;
        this.maxLife = 150;
        this.exp = 1;

        
        
    }

    public void gainExp(int expAdd)
    {
        this.exp += expAdd;
    }

    public void setAttack(int atk)
    {
        this.attack += atk;
    }
    public int getAttack()
    {
        return attack;
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
        this.defense += dfn;
    }

    public int getSpeed()
    {
        return speed;
    }
    public void setHealth(int hlth)
    {
        this.health = hlth;
    }
    public int getHealth()
    {
        return health;
    }
    public int getDefense()
    {
        return defense;
    }
    public void takeDamage(int dmg)
    {
        this.health -= dmg;
        if (health == 0)
        {
            System.out.print("\nYOU DIED.\n");
            System.exit(0);
        }
    }
    public void gainLife(int lifeGain)
    {
        // put your code here
        this.health += lifeGain;
        
        if (health >= maxLife)
        {
            this.health = maxLife;
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
        return this.stats = String.join(System.getProperty("line.separator"),
        "Your Stats are: ",
        "Level: " + classLevel + "",
        "Health: " + health + "",
        "Speed: " + speed +"",
        "Defense: " + defense+ "",
        "Attack: " +attack+ "",
        "Experience: " +exp+ "");
    }

}
