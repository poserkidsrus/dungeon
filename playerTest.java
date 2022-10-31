
/**
 * Write a description of class playerTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class playerTest
{
   public static void main(String[] args)
    {
        Player player1 = new Player();
        player1.setLife(31);
        System.out.println("Current life total: "+player1.getLifeTotal());
        player1.gainLife(20);
        System.out.println("Current life total: "+player1.getLifeTotal());
        player1.gainLife(100);
        System.out.println("Current life total: "+player1.getLifeTotal());
    } 
}
