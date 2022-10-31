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
        
        String third = "Beware! You are about to traverse" +
            dungeonSize + "rooms! You will face many enemies!";
        System.out.println(third);
    }

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
    public ArrayList<Encounter> getEncounters()
    {
        return encounters;
    }
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
       



        // Node tail = head.previous;
        // Node<E> newNode = new Node<>(item);
        // Node<E> temp = head;
        // if(emptyCheck()){
            // newNode.next = newNode.previous = newNode;
            // head = newNode;
        // }
        // else
        // {
            // while (temp.previous != null)
            // {
                // temp = temp.previous;
            // }
            
            // temp.previous = newNode;
            // newNode.next = temp;
                dungeonSize++;
        }
        


    public E returnHead()
    {
        return head.data;
    }

    public E returnTail()
    {
        return tail.data;
    }

    public int returndungeonSize()
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
        private Node<E> next;
        private Node<E> previous;

        private Node(E dataItem)
        {
            data = dataItem;
            next = null;
            previous = null;
        }

        private Node(E dataItem, Node<E> toNextNode, Node<E> toPreviousNode)
        {
            data = dataItem;
            next = toNextNode;
            previous = toPreviousNode;
        }

    }

}