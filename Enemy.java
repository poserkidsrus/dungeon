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
    private int lifeTotal;
    private int attackPower;
    private int speed;
    private int defenseLevel;
    
    private ArrayList<String> stats;
    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(String name)
    {
        // initialise instance variables 
        super(name);
        this.stats = new ArrayList<>();

        Random rand = new Random();
        int atkBounds = 50;
        attackPower = rand.nextInt(atkBounds)+30;
        this.attackPower = attackPower;
        int dfnsBounds = 30;
        defenseLevel = rand.nextInt(dfnsBounds)+0;
        this.defenseLevel = defenseLevel;
        int spdBounds = 50;
        speed = rand.nextInt(dfnsBounds)+20;
        this.speed = speed;
        int lifeBounds = 20;
        lifeTotal = rand.nextInt(lifeBounds)+3;
        this.lifeTotal = lifeTotal;
        
        
        
    }
    
    public void populateStats(String temp)
    {
        temp = "Enemy: " + getName() + "\n Attack Power: " + attackPower +
            " \n Defense Level: " + defenseLevel + "\n Life Total: " +lifeTotal;
        stats.add(temp);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod(int y)
    {
        // put your code here
        
    }
}
