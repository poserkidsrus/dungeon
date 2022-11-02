import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;

public class KBLinkedList<E>
{
    private Node<E> head;
    private Node<E> tail;
    private int dungeonSize;
    private ArrayList<Encounter> encounters;
    public KBLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.dungeonSize = 0;
    }
    //player enters dungeon size into scanner
    public void requestDungeonSize()
    {
        Scanner scanner = new Scanner(System.in);
        String first = "Hello traveler!\n" +
            "You are about to create a dangerous magical dungeon\n" +
            "How many rooms are you prepared to endure?\n";
        String second = "Please enter the size of your dungeon: ";

        System.out.println(first);
        System.out.println(second);
        int input = scanner.nextInt();
        
        dungeonSize = input;
        
        String third = "Beware! You are about to traverse " +
            dungeonSize + " rooms! You will face many enemies!";
        System.out.println(third);
    }
    //creates dungeon based on player input size.  takes objects from arraylist and randomly assigns them to amount of nodes = dungeonsize
    public void createDungeon()
    {
        encounters = new ArrayList<>();
        encounters.add(new Player("Player1"));
        encounters.add(new Exit("Exit Door"));
        String[] possibleMonsters = {"Goblin", "Stone Golem", "Spooky Skeleton", "Witch","Potion", "Sword"};
        Random rand = new Random();

        while(encounters.size() < dungeonSize)
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
    }
    //return contents of encounters array list from above
    public ArrayList<Encounter> getEncounters()
    {
        return encounters;
    }
    //nothing yet
    public void moveRooms()
    {
        
    }
    //prints contents of current dungeon
    public void printDungeon()
    {
        Node temp = head;
        if(head == null)
        {

            System.out.println("This dungeon is empty");
            return;
        }

        while(temp != null)
        {
            System.out.print(temp.data + "->");
            temp = temp.previous;
        }
        System.out.println("The End");
    }
    //adds node to front of linkedlist

    public void addRoom(E item)
    {
        if(head == null)
        {
           
            head = new Node<>(item);
        }
        else
        {
            Node<E> temp = head;
            while (temp.previous != null)
            {
                temp = temp.previous;
            }
            
            temp.previous = new Node<>(item);
            
        }
      
                dungeonSize++;
        }
        //adds empty room, but still only to the head. if i try temp=this.tail, i get null pointer exception. while loop must be wrong.
    public void emptyRoom(int location)
    {
        Node temp = this.head;
        int tab = 0;
        while (temp.getNext() != null && tab<location-1)
        {
            temp = temp.getNext();
            tab++;
        }
        temp.setData(new Encounter("Empty Room"));
    }
    public int playerLocation()
    {
        int location = 0;
        Node temp = this.head;
        String name = temp.getData().getClass().getSimpleName();
        while (!name.equals("Player1"))
        {
            temp = temp.getNext();
            name = temp.getData().getClass().getSimpleName();
            location++;
        }
        return location;
        
    }

    public E returnHead()
    {
        return head.data;
    }
    
    public E returnTail()
    {
        return tail.data;
    }
      
    public int returnDungeonSize()
    {
        return dungeonSize;
    }

    public boolean emptyCheck()
    {
        return dungeonSize == 0;
    }
    private class Node<E>
    {
        private E data;
        private Node next;
        private Node previous;

        private Node(E data)
        {
            this.data = data;
            next = null;
            previous = null;
        }

        public void setData(E data)
        {
            this.data = data;
        }
        public E getData()
        {
            return this.data;
        }
        public Node getNext()
        {
            return this.next;
        }
        public void setNext(Node nextNode)
        {
            this.next = nextNode;
        }
        public Node getPrevious()
        {
            return this.previous;
        }
        public void setPrevious(Node previousNode)
        {
            this.previous = previousNode;
        }

    }

}