import java.util.ArrayList;

/**
 * Write a description of class SpookyDungeon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SpookyDungeon
{
    public static void main(String[] args)
    {
        KBLinkedList<Encounter> test = new KBLinkedList();
        test.requestDungeonSize();
        test.createDungeon();
        ArrayList<Encounter> game = test.getEncounters();
        
        for (Encounter room : game)
        {
            test.addRoom(room);
        }
        test.printDungeon();
        

    }
}
