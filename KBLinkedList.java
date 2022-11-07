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
    private int dungeonSize;
    private ArrayList<Encounter> encounters;
    public KBLinkedList()
    {
        this.head = null;
        this.tail = null;

    }
    //player enters dungeon size into scanner
    

    
    //creates dungeon based on player input size.  takes objects from arraylist and randomly assigns them to amount of Cells = dungeonsize
    
    //return contents of encounters array list from above
    
    //nothing yet
    
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
        Encounter tryout = (Encounter) swapCell.data;
        swapCell.data = temp.data;
        temp.data = tryout;
    }
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
        
        Encounter tryout = (Encounter) temp.data;
        temp.data = swapCell.data;
        swapCell.data = tryout;
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
    //adds empty room, but still only to the head. if i try temp=this.tail, i get null pointer exception. while loop must be wrong.
    public void emptyRoom(int location)
    {
        Cell temp = this.head;
        int tab = 0;
        while (temp.getPrevious() != null && tab<location-1)
        {
            temp = temp.getPrevious();
            tab++;
        }
        temp.setData(new Encounter("Empty Room"));
    }
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
    public void playerData()
    {
        Cell temp = this.head;
        int location = playerLocation();
        for (int i = 0; i < location; i++)
        {
            temp = temp.getNext();
        }
        Encounter encounter = (Encounter) temp.getData();
        System.out.print(encounter.getStats());
    }

    public E returnHead()
    {
        return head.getData();
    }

    public E returnTail()
    {
        return tail.getData();
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