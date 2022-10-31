import java.util.Random;
import java.util.ArrayList;

/**
 * Write a description of class Encounter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Encounter
{
    // instance variables - replace the example below with your own
    private Enemy goblin;
    private Enemy golem;
    private Enemy skeleton;
    private Enemy witch;
    private Item sword;
    private Item potion;
    private Exit exit;
    private Player player1;
    private ArrayList<Enemy> enemies;
    private String name;
    /**
     * Constructor for objects of class Encounter
     */

    public Encounter(String name)
    {
        // initialise instance variables
        enemies = new ArrayList<>();

        this.name = name;
    }
    public void makeEnemies()
    {
        goblin = new Enemy("Goblin");
        golem = new Enemy("Stone Golem");
        skeleton = new Enemy("Spooky skeleton");
        witch = new Enemy("Witch");
        sword = new Item("Sharp sword");
        potion = new Item("Health potion");
        exit = new Exit("You have found the exit!");
        player1 = new Player("Player1");
        
    }
    public String toString()
    {
        return getName();
    }
    public String getName()
    {
        return name;
    }
    public void getEnemies()
    {
        enemies.add(new Enemy("Goblin"));
    }
    public void statPrint()
    {
        System.out.println(goblin.getStats());
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}
