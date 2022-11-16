import java.util.Random;
import java.util.ArrayList;
import java.lang.Class;
/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Encounter
{
    // instance variables - replace the example below with your own
    private int health;
    private int attack;
    private int speed;
    private int defense;
    private String stats;
    
    
    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(String name)
    {
        // initialise instance variables 
        super(name);
        

        Random rand = new Random();
        int atkBounds = 50;
        attack = rand.nextInt(atkBounds)+30;
        this.attack = attack;
        int dfnsBounds = 30;
        defense = rand.nextInt(dfnsBounds)+0;
        this.defense = defense;
        int spdBounds = 50;
        speed = rand.nextInt(dfnsBounds)+20;
        this.speed = speed;
        int lifeBounds = 20;
        health = rand.nextInt(lifeBounds)+3;
        this.health = health;
        
        
        
    }
    
    public String getStats()
    {
        return this.stats = String.join(System.getProperty("line.separator"),
        "Health: " + health + "",
        "Speed: " + speed +"",
        "Defense: " + defense+ "",
        "Attack: " +attack+ "");
    }
    public void takeDamage(int dmg)
    {
        this.health -= dmg;
    }
    public int getAttack()
    {
        return attack;
    }
    public int getDefense()
    {
        return defense;
    }
    public int getSpeed()
    {
        return speed;
    }
    public int getHealth()
    {
        return health;
    }
}
