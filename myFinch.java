
// Needs a package declaration to move to another folder

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

/**
 * Created by:
 * Date:
 * A starter file to use the Finch
 */

public class myFinch
{
    Finch myFinch = new Finch();
    public boolean hugTest()
    {
        myFinch.sleep(5000);
        int[] lightlevels = myFinch.getLightSensors();
        if(lightlevels[0] < 15 && lightlevels[1] < 15)
        {
            myFinch.setLED(0, 255, 0);
            System.out.println("You gave him a big hug, nice to know not everyone is crazy.");
            System.out.println("Gain 5 hp.");
            myFinch.quit();
            return true;
        }
        else
        {
            myFinch.setLED(255, 0, 0);
            System.out.println("You did not give him a hug...oh no, he looks pretty mad.");
            System.out.println("The stranger kicked you. That looked like it hurt.");
            System.out.println("Lose 10 hp.");
            myFinch.quit();
            return false;
        }
    }

    public boolean fightingFinch()
    {
        int random;
        boolean[] successcheck = new boolean[8];
        for(int count = 0; count <= 7; count++)
        {
            random = (int) (Math.random() * 4 + 1);
            if(random == 1)
            {
                System.out.println("Jump! (Finch up)");
                myFinch.sleep(2000);
                successcheck[count] = myFinch.isBeakUp();
            }
            else if(random == 2)
            {
                System.out.println("Duck! (Finch down)");
                myFinch.sleep(2000);
                successcheck[count] = myFinch.isBeakDown();
            }
            else if(random == 3)
            { 
                System.out.println("Dodge left! (Finch turned left)");
                myFinch.sleep(2000);
                successcheck[count] = myFinch.isLeftWingDown();
            }
            else if(random == 4)
            {
                System.out.println("Dodge right! (Finch turned right)");
                myFinch.sleep(2000);
                successcheck[count] = myFinch.isRightWingDown();
            }      
        }
        int successcount=0;
        for(int count1 = 0; count1 <= 7; count1++)
        {
            if(successcheck[count1] == true)
            {
                successcount++;
            }
            else
            {
                successcount = successcount;
            }
        }
        if(successcount > 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

