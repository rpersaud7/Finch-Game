
public class Player
{
    private String name;
    private int hp;
    private int board;
    public Player(String name)
    {
        this.name = name;
        this.hp = 100;
    }

    public String getName()
    {
        return this.name;
    }

    public int changeHP(int change)
    {

        this.hp = this.hp + change;

        if(this.hp > 100)
        {
            this.hp = 100;

        }
        else if(this.hp < 0)
        {
            this.hp = 0;
        }
        return this.hp;
    }

    public  int movePlayer(int dietotal)
    {

        board = board + dietotal; 
        board =boardreset( );
        return this.board;
    }

    public   int boardreset( )
    {

        if(board > 100)
        { 
            board = board-100;
            System.out.println("You are now on square " + board);
            return board;

        }
        else 
        {
            System.out.println("You are now on space " + board);
            return board;
        }
    }

    public boolean checkAlive()
    {
        if(this.hp == 0 || this.hp < 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
