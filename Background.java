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
    private int levelNumber;
    private char z;
    private ArrayList<Encounter> inventory;
    private Player player;
    Scanner scanner;

    /**
     * Constructor for objects of class Background
     */
    public Background()
    {
        // initialise instance variables
        this.scanner = new Scanner(System.in);
        this.player = new Player("Player1");
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

    public int createDungeon(int input)
    {
        levelNumber++;
        
        KBLinkedList<Encounter> dungeon = new KBLinkedList<>();
        this.encounters = new ArrayList<>();
        encounters.add(this.player);
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
        return levelNumber;
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
            System.out.println("E - Exit Options");
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
            this.dungeon.printDungeon();
        }
         else if (Character.toLowerCase(z) == 'b')
         {
             this.inventoryMenu();
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
            this.getExit();
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

    //show distance from player to exit
    public void getExit()
    {
        int exitLocation = this.dungeon.exitLocation();
        int playerLocation = this.dungeon.playerLocation();
        int exitDistance = Math.abs(exitLocation - playerLocation);
        //boolean flag3 = false;

        System.out.println("Have you grown weary of this torment?");
        System.out.println("If you would like to exit, enter 'e'.");
        System.out.println("If you would like to see the distance to the exit, enter 'y'.");
        char z = this.scanner.next().charAt(0);

        if(Character.toLowerCase(z) == 'y')
        {
            //flag3 = true;
            if (exitDistance > this.encounters.size() / 2)
            {
            exitDistance = this.encounters.size() - exitDistance;
            }
            System.out.println("The exit is ");
                if (exitDistance == 1)
                {
                System.out.print("next to you!");
                }
                else
                {
                System.out.print(exitDistance + " rooms away.");
                }
                
        }
        else if(Character.toLowerCase(z) == 'e')
        {
            //this.dungeon.exitLevel();
            moveToExit();
            
        }
        else
        {
            System.out.println("Please try again");
        }
    }
    
    public void inventoryMenu()
    {
        System.out.println("Inventory: " + this.dungeon.getInventory());
    }
    // public void updatePlayerStats()
    // {
        // int[] inventorystats = this.dungeon.getInventoryStats();
        // int atk = inventorystats[0];

    // }
    public void printStats()
    {
        System.out.println(player.getStats());
    }
    public boolean movePlayer()
    {
        boolean movement = false;
        while(!movement){
            System.out.print("Please enter L or R to move left or right.");
            this.z = this.scanner.next().charAt(0);
            if(Character.toLowerCase(z) == 'l')
            {
            this.dungeon.movePlayerLeft();
            movement = true;
            }
            else if(Character.toLowerCase(z) == 'r')
            {
            this.dungeon.movePlayerRight();
            movement = true;
            }
            else
            {
            System.out.println("Invalid input");
            
            }
        }
        return movement;
    }
    public void rollCredits()
    {
        System.out.print("\nGAME OVER\n");
        System.exit(0);
    }
    public void moveToExit()
    {
        System.out.println();
        System.out.println();
        System.out.println("Beware, adventurer! What awaits you is not kind...");
        System.out.println("Welcome to level " + (this.levelNumber + 1)+ "!");
        System.out.println("The deeper you go, the harder you must fight.");
        this.createDungeon(this.encounters.size()*2);
    }
    

    
    public ArrayList<Encounter> getEncounters()
    {
        return encounters;
    }
    
    
}