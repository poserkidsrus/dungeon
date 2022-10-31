import java.util.ArrayList;

/**
 * Write a description of class TrafficControl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TrafficControl
{
    // instance variables - replace the example below with your own
    
    private ArrayList<Encounter> Interactions;
    /**
     * Constructor for objects of class TrafficControl
     */
    public TrafficControl()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void initializeEncounterArray()
    {
        // put your code here
        Interactions = new ArrayList<Encounter>();
        Interactions.add(new Enemy(Goblin));
        
    }
}
