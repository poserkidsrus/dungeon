import java.util.Random;
import java.util.ArrayList;
import java.lang.Class;

/**
 * Write a description of class Encounter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Encounter
{
    // instance variables - replace the example below with your own
    
    private String stats;
    private String name;
    /**
     * Constructor for objects of class Encounter
     */

    public Encounter(String name)
    {
        // initialise instance variables
        

        this.name = name;
    }
    public void setStats(String temp)
    {
        this.stats = temp;
    }
    
    public String getStats()
    {
        return this.stats;
    }
    
    public String toString()
    {
        return getName();
    }
    public String getName()
    {
        return this.name;
    }
    
    // public void statPrint()
    // {
        // System.out.println(goblin.getStats());
    // }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}
