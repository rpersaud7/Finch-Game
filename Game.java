import java.util.Scanner; 
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{

    public static void main (String[] args)
    {
        int dietotal, board, finaltotal=0, moveboard = 0; 
        String name; 
        Scanner grabby = new Scanner(System.in);
        System.out.println("Please enter your first and last name and press the enter key.");
        name = grabby.nextLine();
        for(int count1 = 1; count1 <= 5; count1++)
        {
            System.out.println(name + " you are going to play game " + count1 + " now.");
            for(int count2 = 1; count2 <= 10; count2++)
            {
                dietotal = diceThrow(name);
                moveboard= moveboard + dietotal; 
                board =movePlayer(moveboard);
                
                if(count2 == 10)
                {
                    System.out.println(name + " is on square " + board);
                    finaltotal= finaltotal + board; 
                    if(board > 80)
                    {
                        System.out.println(name + " you win!"); 
                    }
                    else
                    {
                        System.out.println("Sorry you lost.");
                    }
                }    
            }
            board= 0;
            dietotal = 0; 
            moveboard =0;
        }
        finaltotal = finaltotal/5;
        System.out.println(name + " your average final square for all 5 games was " + finaltotal);
    }

    public static int diceThrow(String name)
    {
        int dietotal = 0, die1;
        for(int count1 = 1; count1<=2; count1++)
        {
            die1 = (int) ( Math.random() * 6) + 1;
            dietotal = dietotal + die1;
        }
        System.out.println(name + " you threw a total of " + dietotal);
        return dietotal;
    }

    public static int movePlayer(int board)
    {
        
        
        if(board > 100)
        { 
            board = board-100;
            System.out.println("You are now on space " + board);
            return board;
            
        }
        else 
        {
            System.out.println("You are now on space " + board);
            return board;
        }
    }
}
