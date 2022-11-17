import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;
import java.lang.Class;

public class KBLinkedList<E>
{
    private Cell<E> head;
    private Cell<E> tail;
    private Scanner scanner;
    private int dungeonSize;
    private ArrayList<Encounter> encounters;
    private ArrayList<Item> inventory;
    private int[] inventorystats;
    private String[] statStrings;
    private int playerLocation;
    private char z;
    public KBLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.scanner = new Scanner(System.in);
        this.inventory = new ArrayList<>();
        this.inventorystats = new int[4];
    }

    //prints contents of current dungeon
    public void printDungeon()
    {
        System.out.println();
        System.out.print("[ ");
        if(head == null)
        {

            System.out.println("This dungeon is empty");
            return;
        }
        Cell temp = head;
        int location = playerLocation();
        for (int i = 0; i < location; i++)
        {
            temp = temp.getNext();
        }
        for (int i = 0; i <= this.dungeonSize / 2; i++)
        {
            temp = temp.getNext();
        }
        for (int i = 0; i < this.dungeonSize; i++)
        {
            Encounter encounter = (Encounter) temp.getData();
            System.out.print(encounter.getName());
            temp = temp.getNext();
            if(i < this.dungeonSize - 1)
            {
                System.out.print(" ]<>[ ");
            }
        }
        System.out.print(" ]");
        System.out.println();
    }
    //adds Cell to front of linkedlist

    public void fillDungeon(E item)
    {
        Cell temp = new Cell(item, null, null);
        if(head == null)
        {

            temp.setNext(temp);
            temp.setPrevious(temp);
            head = temp;
            tail = head;

        }
        else
        {
            temp.setNext(head);
            temp.setPrevious(tail);
            tail.setNext(temp);
            tail = temp;
        }
        dungeonSize++;
    }

    // move player to the right in the linked list
    public void movePlayerRight()
    {
        Cell temp = this.head;
        Cell swapCell = this.head;

        int location = this.playerLocation();
        int moveLocation = this.rightOfPlayer();

        for(int i = 0; i < location; i++)
        {
            temp=temp.getNext();

        }
        for(int i = 0; i < moveLocation; i++)
        {
            swapCell=swapCell.getNext();

        }

        if(swapCell.getData().getClass().getSimpleName().equals("Item"))
        {   Item inventoryitem = (Item) swapCell.data;
            System.out.println("This room contains a " +inventoryitem.getName() + " .");
            System.out.print("Would you like to pick up this item? Enter Y for yes or N for no.");
            this.z = this.scanner.next().charAt(0);
            if(Character.toLowerCase(z) == 'y')
            {
                Player p = (Player) temp.data;
                getItem(inventoryitem, p);
                swapCell.setData(new Encounter("Empty Room"));
                Encounter tryout = (Encounter) swapCell.data;
            swapCell.data = temp.data;
            temp.data = tryout;
            }
            else
            {
                Encounter tryout = (Encounter) swapCell.data;
            swapCell.data = temp.data;
            temp.data = tryout;
            }
        }
        else if(swapCell.getData().getClass().getSimpleName().equals("Enemy"))
        {
            Enemy e = (Enemy) swapCell.data;
            System.out.println();
            System.out.println("The " +e.getName()+ " has the following stats: ");
            System.out.println(e.getStats());
            System.out.println("Would you like to battle this enemy? Enter Y for yes or N for no.");
            this.z = this.scanner.next().charAt(0);
            if(Character.toLowerCase(z) == 'y')
            {
                Player p = (Player) temp.data;
                battle(p, e);
                if(e.getHealth() <= 0)
                {
                    swapCell.setData(new Encounter("Empty Room"));
                    p.gainExp(1);
                    Encounter tryout = (Encounter) swapCell.data;
            swapCell.data = temp.data;
            temp.data = tryout;
                }
                else
                {
                    Encounter tryout = (Encounter) swapCell.data;
            swapCell.data = temp.data;
            temp.data = tryout;
                }
            }
            else
            {
                Encounter tryout = (Encounter) swapCell.data;
            swapCell.data = temp.data;
            temp.data = tryout;
            }
        }
        // else if(swapCell.getData().getClass().getSimpleName().equals("Exit"))
        // {
            // System.out.print("Would you like to exit?");
            // this.z = this.scanner.next().charAt(0);
            // if(Character.toLowerCase(z) == 'y')
            // {
                // exitLevel();
            // }
            // else
            // {
                // Encounter tryout = (Encounter) temp.data;
                // temp.data = swapCell.data;
                // swapCell.data = tryout;
            // }
        // }
        else
        {
            Encounter tryout = (Encounter) swapCell.data;
            swapCell.data = temp.data;
            temp.data = tryout;
        }
    }

    // move player left in the linked list
    public void movePlayerLeft()
    {
        Cell temp = this.head;
        Cell swapCell = this.head;

        int location = this.playerLocation();
        int moveLocation = this.leftOfPlayer();

        for(int i = 0; i < location; i++)
        {
            temp=temp.getNext();

        }
        for(int i = 0; i < moveLocation; i++)
        {
            swapCell=swapCell.getNext();

        }

        if(swapCell.getData().getClass().getSimpleName().equals("Item"))
        {   Item inventoryitem = (Item) swapCell.data;
            System.out.println("This room contains a " +inventoryitem.getName() + " .");
            System.out.print("Would you like to pick up this item? Enter Y for yes or N for no.");
            this.z = this.scanner.next().charAt(0);
            if(Character.toLowerCase(z) == 'y')
            {
                Player p = (Player) temp.data;
                getItem(inventoryitem, p);
                swapCell.setData(new Encounter("Empty Room"));
                Encounter tryout = (Encounter) temp.data;
                temp.data = swapCell.data;
                swapCell.data = tryout;
            }
            else
            {
                Encounter tryout = (Encounter) temp.data;
                temp.data = swapCell.data;
                swapCell.data = tryout;
            }
        }
        else if(swapCell.getData().getClass().getSimpleName().equals("Enemy"))
        {
            Enemy e = (Enemy) swapCell.data;
            System.out.println();
            System.out.println("The " +e.getName()+ " has the following stats: ");
            System.out.println(e.getStats());
            System.out.println("Would you like to battle this enemy? Enter Y for yes or N for no.");
            this.z = this.scanner.next().charAt(0);
            if(Character.toLowerCase(z) == 'y')
            {
                Player p = (Player) temp.data;
                battle(p, e);
                if(e.getHealth() <= 0)
                {
                    swapCell.setData(new Encounter("Empty Room"));
                    p.gainExp(1);
                    Encounter tryout = (Encounter) temp.data;
                    temp.data = swapCell.data;
                    swapCell.data = tryout;
                }
                else
                {
                    Encounter tryout = (Encounter) temp.data;
                    temp.data = swapCell.data;
                    swapCell.data = tryout;
                }
            }
            else
            {
                Encounter tryout = (Encounter) temp.data;
                temp.data = swapCell.data;
                swapCell.data = tryout;
            }
        }
        // else if(swapCell.getData().getClass().getSimpleName().equals("Exit"))
        // {
            // System.out.print("Would you like to exit?");
            // this.z = this.scanner.next().charAt(0);
            // if(Character.toLowerCase(z) == 'y')
            // {
                // exitLevel();
            // }
            // else
            // {
                // Encounter tryout = (Encounter) temp.data;
                // temp.data = swapCell.data;
                // swapCell.data = tryout;
            // }
        // }
        else
        {
            Encounter tryout = (Encounter) temp.data;
            temp.data = swapCell.data;
            swapCell.data = tryout;
        }
    }

    // return index of cell to the right of player position
    public int rightOfPlayer()
    {
        int locationMove = 0;
        boolean flag = false;
        Cell temp = this.head;

        while (temp != null)
        {
            if (temp.previous.getData().getClass().getSimpleName().equals("Player"))
            {
                flag = true;
                break;
            }

            temp = temp.getNext();

            locationMove++;
        }
        return locationMove;
    }

    // return index of cell to the left of player position
    public int leftOfPlayer()
    {
        int locationMove = 0;
        boolean flag = false;
        Cell temp = this.head;

        while (temp != null)
        {
            if (temp.next.getData().getClass().getSimpleName().equals("Player"))
            {
                flag = true;
                break;
            }

            temp = temp.getNext();

            locationMove++;
        }
        return locationMove;
    }

    // if player decides to pick up item, show item stats and update player stats with those values.
    public void getItem(Item inventoryitem, Player p)
    {
        inventory.add(inventoryitem);
        System.out.println();
        System.out.println("The " +inventoryitem.getName()+ " you picked up has the following stats: ");

        updateInventory(p, inventoryitem);

    }
    public void updateInventory(Player p, Item i)
    {
        int atk;
        int spd;
        int dfn;
        int hlth;

        i = inventory.get(inventory.size() - 1);
        inventorystats[0] = atk = i.getAttack();
        inventorystats[1] = spd = i.getSpeed();
        inventorystats[2] = dfn =  i.getDefense();
        inventorystats[3] = hlth = i.getHealth();
        p.setStats(inventorystats[0], inventorystats[1], inventorystats[2], inventorystats[3]);
        System.out.println("Attack bonus : " +atk+ "\nSpeed bonus : " +spd+ "\nDefense Bonus : " +dfn+ "\nHealth Bonus : " +hlth);
    }

    public void fightEnemyRight(Enemy e, Player p)
    {

        battle(p , e);
    }
    public void fightEnemyLeft(Enemy e, Player p)
    {

        System.out.println();
        System.out.println("The " +e.getName()+ " has the following stats: ");
        System.out.print(e.getStats());

        battle(p , e);

    }    

    public boolean battle(Player p, Enemy e)
    {
        boolean flag = false;
        int dmg = 0;
        while (!flag)
        { 
            if (e.getSpeed() > p.getSpeed())
            {
                dmg = e.getAttack() - p.getDefense();
                if(dmg > 0)
                {
                    p.takeDamage(dmg);
                    flag = true;
                    break;
                }
                flag = true;
                break;
            }
            else
            {
                dmg = p.getAttack() - e.getDefense();
                if(dmg > 0)
                {
                    e.takeDamage(dmg);
                    if (e.getHealth() <= 0)
                    {
                        System.out.print("\n" +e.getName()+ " has been defeated! \n");
                        flag = true;
                        break;
                    }
                    flag = true;
                    break;
                }
                flag = true;
                break;
            }
        }
        return flag;
    }
    // loop through cells and iterate until player location is found, return value
    public int playerLocation()
    {
        int location = 0;
        boolean flag = false;
        Cell temp = this.head;
        String name = temp.getData().getClass().getSimpleName();
        while (temp != null)
        {
            {
                if (name.equals("Player"))
                {
                    flag = true;
                    break;
                }
            }
            temp = temp.getNext();
            name = temp.getData().getClass().getSimpleName();
            location++;
        }
        return location;

    }

    // loop through cells until exit is found, iterate and return value of exit cell
    public int exitLocation()
    {
        int location = 0;
        boolean flag = false;
        Cell temp = this.head;
        String name = temp.getData().getClass().getSimpleName();
        while (temp != null)
        {
            {
                if (name.equals("Exit"))
                {
                    flag = true;
                    break;
                }
            }
            temp = temp.getNext();
            name = temp.getData().getClass().getSimpleName();
            location++;
        }
        return location;

    }

    public void exitLevel()
    {
        Cell temp = this.head;
        Cell swapCell = this.head;

        int location = this.playerLocation();
        int moveLocation = this.exitLocation();
        for(int i = 0; i < location; i++)
        {
            temp=temp.getNext();         
        }

        for(int i = 0; i < moveLocation; i++)
        {
            swapCell=swapCell.getNext();     
        }
        temp.setData(new Encounter("Empty Room"));
    }
    // returns data of cell in head position
    public E returnHead()
    {
        return head.getData();
    }

    // returns data of cell in tail position
    public E returnTail()
    {
        return tail.getData();
    }

    // public E returnData()
    // {
    // return 
    // }
    // returns Encounter Items in inventory
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    public int[] getInventoryStats()
    {
        return inventorystats;
    }

    public boolean emptyCheck()
    {
        return head == null;
    }
    private class Cell<E>
    {
        private E data;
        private Cell next;
        private Cell previous;

        private Cell(E data)
        {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        private Cell(E data, Cell previousCell, Cell nextCell)
        {
            this.data = data;
            this.next = nextCell;
            this.previous = previousCell;
        }

        public void setData(E data)
        {
            this.data = data;
        }

        public E getData()
        {
            return this.data;
        }

        public Cell getNext()
        {
            return this.next;
        }

        public void setNext(Cell nextCell)
        {
            this.next = nextCell;
        }

        public Cell getPrevious()
        {
            return this.previous;
        }

        public void setPrevious(Cell previousCell)
        {
            this.previous = previousCell;
        }

    }

}