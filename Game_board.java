import javalib.worldimages.*;
import java.awt.Color;

/**
 * Write a description of class Game_board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game_board
{

    public static void main (String[] args)
    {
        WorldImage wasteland = AImage.makeRectangle(500,500, Color.green, Mode.filled);
        WorldImage pathway = AImage.makeRectangle(50,50, Color.red, Mode.filled);
        WorldImage player = AImage.makeCircle(25, Color.blue, Mode.filled);
        
        for(int count1 = 1; count1 <= 9; count1++)
        {
            wasteland = wasteland.place(pathway, 50*count1, 500/4);    
            wasteland = wasteland.place(player, 50, 500/4);
        }
        wasteland.show();
    }

}
