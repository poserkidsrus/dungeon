
/**
 * Write a description of class Background here.
 *
 * @Keil Barracliffe
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;
import java.lang.Class;
public class Background
{
    // instance variables - replace the example below with your own
    private KBLinkedList dungeon;
    private ArrayList<Encounter> encounters;
    private int playerLocation;
    private int levelNumber;
    private char z;
    private Player player;
    Scanner scanner;

    /**
     * Constructor for objects of class Background
     */
    public Background()
    {
        // initialise instance variables
        this.scanner = new Scanner(System.in);
        Player player = new Player("Player1");
    }
    //create initial dungeon
    public void introduction()
    {

        String first = "Hello traveler!\n" +
            "You are about to create a dangerous magical dungeon\n" +
            "How many rooms are you prepared to endure?\n";
        String second = "Please enter the size of your dungeon: ";

        System.out.println(first);
        System.out.println(second);
        int input = scanner.nextInt();


        String third = "Beware! You are about to traverse " +
            input + " rooms! You will face many enemies!";
        System.out.println(third);
        createDungeon(input);
    }

    public void createDungeon(int input)
    {
        this.levelNumber++;
        
        KBLinkedList<Encounter> dungeon = new KBLinkedList<>();
        this.encounters = new ArrayList<>();
        encounters.add(new Player("Player1"));
        encounters.add(new Exit("Exit Door"));
        String[] possibleMonsters = {"Goblin", "Stone Golem", "Spooky Skeleton", "Witch","Potion", "Sword", "Armor"};
        Random rand = new Random();

        while(encounters.size() < input)
        {
            int i = rand.nextInt(possibleMonsters.length);
            if(i < 4)
            {
                encounters.add(new Enemy(possibleMonsters[i]));
            }
            else
            {  
                encounters.add(new Item(possibleMonsters[i]));
            }
            Collections.shuffle(encounters);
        }
        
        this.dungeon = dungeon;
        ArrayList<Encounter> game = this.getEncounters();
        for (Encounter room : game)
        {
            dungeon.fillDungeon(room);
        }
    }
    
    public void gameMenu()
    {
        while (true)
        {
            System.out.println();
            System.out.println("\t Menu \t");
            System.out.println("A - Show location");
            System.out.println("B - Show inventory");
            System.out.println("C - Show stats");
            System.out.println("D - Move");
            System.out.println("E - Show Exit");
            System.out.println("X - End Game");

            this.z = this.scanner.next().charAt(0);
            
            this.getEncounters();
            this.menuInput(z);
        }
        
    }
    public char menuInput(char z)
    {
        if(Character.toLowerCase(z) == 'a')
        {
            dungeon.printDungeon();
        }
         else if (Character.toLowerCase(z) == 'b')
         {
             this.printInventory();
        }
        else if(Character.toLowerCase(z) == 'c')
        {
            this.printStats();
        }
        else if(Character.toLowerCase(z) == 'd')
        {
            this.movePlayer();
        }
        else if(Character.toLowerCase(z) == 'e')
        {
            this.showExit();
        }
        else if (Character.toLowerCase(z) == 'x')
        {
                this.rollCredits();
        }
        else
        {
            System.out.println("Invalid Selection");
        }
        return this.z;
    }
    public void showExit()
    {

    }
    public void printInventory()
    {

    }
    public void printStats()
    {

    }
    public void movePlayer()
    {
        System.out.print("Please enter L or R to move left or right.");
        this.z = this.scanner.next().charAt(0);
        if(Character.toLowerCase(z) == 'l')
        {
            this.dungeon.movePlayerLeft();
        }
        else if(Character.toLowerCase(z) == 'r')
        {
            this.dungeon.movePlayerRight();
        }
        else
        {
            System.out.println("Invalid input");
        }
    }
    public void rollCredits()
    {
        System.out.print("\nGAME OVER\n");
        System.exit(0);
    }
    //returns location of exit
    public int exitLocation()
    {
        int location = -1;
        boolean flag = false;

        for (int i = 0; i < this.encounters.size(); i++)
        {
            Encounter exit = this.encounters.get(i);
            {
                if (exit.getName().equals("Exit Door"))
                {
                    flag = true;
                    break;
                }
            }
            location = i;
        }
        return location;
    }

    public ArrayList<Encounter> getEncounters()
    {
        return encounters;
    }
    
    
}
