import java.lang.Class;
import java.util.Random;
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Item extends Encounter
{
    // instance variables - replace the example below with your own
    private int defense;
    private int health;
    private int attack;
    private int speed;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name)
    {
        // initialise instance variables
        super(name);
        Random rand = new Random();
        int atkBounds = 10;
        attack = rand.nextInt(atkBounds)+10;
        this.attack = attack;
        int dfnsBounds = 20;
        defense = rand.nextInt(dfnsBounds)+0;
        this.defense = defense;
        int spdBounds = 20;
        speed = rand.nextInt(dfnsBounds)+0;
        this.speed = speed;
        int lifeBounds = 20;
        health = rand.nextInt(lifeBounds)+3;
        this.health = health;
    }
    public int getAttack()
    {
        return this.attack;
    }
    public int getDefense()
    {
        return this.defense;
    }
    public int getSpeed()
    {
        return this.speed;
    }
    public int getHealth()
    {
        return this.health;
    }
}