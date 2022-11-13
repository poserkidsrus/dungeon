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
    private ArrayList<Encounter> inventory;
    private int playerLocation;
    private char z;
    public KBLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.scanner = new Scanner(System.in);
        this.inventory = new ArrayList<>();
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
        if (swapCell.getData().getClass().getSimpleName() == "Item")
        {
            System.out.print("Would you like to pick up this item? Enter Y for yes or N for no.");
            this.z = this.scanner.next().charAt(0);
            if(Character.toLowerCase(z) == 'y')
            {
                getItemRight();
                Encounter tryout = (Encounter) temp.data;
                temp.data = swapCell.data;
                swapCell.data = tryout;
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

        if(swapCell.getData().getClass().getSimpleName() == "Item")
        {
            System.out.print("Would you like to pick up this item? Enter Y for yes or N for no.");
            this.z = this.scanner.next().charAt(0);
            if(Character.toLowerCase(z) == 'y')
            {
                getItemLeft();
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
    // return index of cell to the right of player position
    public int rightOfPlayer()
    {
        int locationMove = 0;
        boolean flag = false;
        Cell temp = this.head;

        while (temp != null)
        {
            if (temp.previous.getData().getClass().getSimpleName() == "Player")
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
            if (temp.next.getData().getClass().getSimpleName() == "Player")
            {
                flag = true;
                break;
            }

            temp = temp.getNext();

            locationMove++;
        }
        return locationMove;
    }

    // if item is present in the cell left of the player, add item to inventory and replace with empty room
    public void getItemLeft()
    {
        Cell temp = this.head;
        Cell swapCell = this.head;

        int location = playerLocation();
        int moveLocation = leftOfPlayer();

        for(int i = 0; i < location; i++)
        {
            temp=temp.getNext();

        }
        for(int i = 0; i < moveLocation; i++)
        {
            swapCell=swapCell.getNext();

        }
        Encounter inventoryitem = (Encounter) swapCell.data;
        inventory.add(inventoryitem);
        swapCell.setData(new Encounter("Empty Room"));

    }

    // if item is present in the cell right of player, add item to inventory and replace with empty room
    public void getItemRight()
    {
        Cell temp = this.head;
        Cell swapCell = this.head;

        int location = playerLocation();
        int moveLocation = rightOfPlayer();

        for(int i = 0; i < location; i++)
        {
            temp=temp.getNext();

        }

        for(int i = 0; i < moveLocation; i++)
        {
            swapCell=swapCell.getNext();

        }
        Encounter inventoryitem = (Encounter) swapCell.data;
        inventory.add(inventoryitem);
        swapCell.setData(new Encounter("Empty Room"));
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

    // returns Encounter Items in inventory
    public ArrayList<Encounter> getInventory()
    {
        return inventory;
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