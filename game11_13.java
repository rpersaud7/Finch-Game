import java.util.Scanner; 

public class game11_13
{
    public static void main (String[] args)
    {
        int dietotal=0,board = 0, moveboard = 1, hp1, hp2, turnindicate = 1; 
        String name1, name2, usercontinue;
        myFinch finchcontroller = new myFinch(); 
        Scanner grabby = new Scanner(System.in);
        System.out.println("Player 1 please enter your first and last name and press the enter key.");
        name1 = grabby.nextLine();
        Player player1 = new Player(name1);  
        System.out.println("Player 2 please enter your first and last name and press the enter key.");
        name2 = grabby.nextLine();
        Player player2 = new Player(name2);

        hp1 = player1.changeHP(0);
        hp2 = player2.changeHP(0);

        do
        {
            if(turnindicate == 1)
            {
                dietotal = diceThrow(name1);
                board = player1.movePlayer(dietotal );
                
                if(board == 7 || board == 14 || board == 21 || board == 28 || board == 35 || board == 42 || board == 49 || board == 56 || board == 63 || board == 70 || board == 77 || board == 84 || board == 91 || board == 98)
                {
                    pickandUseCard(player1,finchcontroller);

                }
                randomEvents(player1, finchcontroller);
                System.out.println("Your current health is " + player1.changeHP(0));
                System.out.println("");
            }
            else if(turnindicate == 2)
            {
                dietotal = diceThrow(name2);
                board = player2.movePlayer(dietotal );

                if(board == 7 || board == 14 || board == 21 || board == 28 || board == 35 || board == 42 || board == 49 || board == 56 || board == 63 || board == 70 || board == 77 || board == 84 || board == 91 || board == 98)
                {
                    pickandUseCard(player2,finchcontroller);

                }
                randomEvents(player2,finchcontroller);
                System.out.println("Your current health is " + player2.changeHP(0));
                System.out.println("");
            }
            if(turnindicate == 1)
            {
                turnindicate = 2;
            }
            else if(turnindicate == 2)
            {
                turnindicate = 1;
            }
            
            System.out.println("Would you like to continue? Yes/No");
            usercontinue = grabby.nextLine();
            if(usercontinue.equals("Yes"))
            {
                System.out.println("stuff");
            }
            else if(usercontinue.equals("No"))
            {
                player1.changeHP(-100);
                player2.changeHP(-100);
            }

        }while(player1.checkAlive() && player2.checkAlive());

    }

    public static int diceThrow(String name1)
    {
        int dietotal = 0, die1;
        for(int count1 = 1; count1<=2; count1++)
        {
            die1 = (int) ( Math.random() * 6) + 1;
            dietotal = dietotal + die1;
        }
        System.out.println(name1 + " you threw a total of " + dietotal);
        return dietotal;
    }

    public static void pickandUseCard(Player currentplayer, myFinch finchcontroller)
    {
        int card = (int) (Math.random() * 7 + 1);
        if(card == 1)
        {
            System.out.println("A mysterious stranger appears...where is that guitar coming from?");
            System.out.println("The stranger gives you a hand. What a kind guy...wait, where did he go?");
            System.out.println("Gain 5 hp.");
            currentplayer.changeHP(5);
        }
        else if(card == 2)
        {
            System.out.println("You were so thirsty you decided to take a sip from the dirty puddle over there...poor decision.");
            System.out.println("Lose 10 hp.");
            currentplayer.changeHP(-20);
        }
        else if(card == 3)
        {
            System.out.println("You see someone off in the distance, you decide to wave at him. It turns out he's a friendly guy and just wants a hug, how nice. (Get ready with the finch!)");

            if(finchcontroller.hugTest()==true)
            {
                currentplayer.changeHP(5);
            }
            else
            {
                currentplayer.changeHP(-10);
            }
        }
        else if(card == 4)
        {
            System.out.println("Wandering around you find another person. It seems like love at first sight, how adorable...annnnnnnnnd they're being taken away by a massive hawk.");
            System.out.println("Tis better to have loved and lost rather than never have loved at all?");
            System.out.println("Gain 20 health.");
            currentplayer.changeHP(20);
        }
        else if(card == 5)
        {
            System.out.println("Thats curious...what is that growling sound? Oh my, looks like an angry bear, good luck! (Get ready with the finch!)");

            if(finchcontroller.fightingFinch() == true)
            {
                System.out.println("Did you really just fight off a bear? That is definitely something that belongs on your resume.");
                System.out.println("No change in hp");
            }
            else
            {
                System.out.println("Well did you really think you could fight off a bear? Silly goose.");
                System.out.println("Lose 40 hp.");
                currentplayer.changeHP(-40);
            }
        }
        else if(card == 6)
        {
            System.out.println("You are starving and could probably eat a horse, so you decide to grab that plant near your feet and much on it in hopes its edible. This can't end well...");
            int coin = (int) (Math.random() * 3);
            if(coin == 1)
            {
                System.out.println("You ate a random plant and threw up soon after, who could have seen that one coming?...Why are you petting a tree and calling it Maxwell.");
                System.out.println("Lose 15 hp.");
                currentplayer.changeHP(-15);
            }
            else
            {
                System.out.println("Huh, so that wasn't a dangerous thing to eat after all, and better yet you only feel like eating half a horse now. Good thing there aren't any horses around.");
                System.out.println("Gain 10 hp.");
                currentplayer.changeHP(10);
            }
        }
        else if(card == 7)
        {
            System.out.println("You find a nice little settlement and are strolling around town when you hear 'Hey stranger, I've got some good things on sale today.' from a dark alley. You decide to check it out, what could go wrong? (Get ready with the finch!)");
            
            if(finchcontroller.fightingFinch() == true)
            {
                System.out.println("Turns out the guy wanted to knock you out and steal your organs judging by the many medical tools he's got lying around, and the fact he tried to knock you out.");
                System.out.println("You fought him off and even took some of his supplies, serves him right, jerk.");
                System.out.println("Gain 15 hp.");
                currentplayer.changeHP(15);
            }
            else
            {
                System.out.println("Turns out the guy wanted to knock you out and steal your organs judging by the many medical tools he's got lying around, and the fact he tried to knock you out.");
                System.out.println("You wake up in the same alley but the shady guy is gone...you also feel a pain in your side.");
                System.out.println("Judging by the poorly stitched up incision there you probably got your kidney stolen, incredible decision making following a stranger in to a back alley. Well at least you were born with 2.");
                System.out.println("Lose 20 hp.");
                currentplayer.changeHP(-20);
            }
        }
    }

    public static void randomEvents(Player currentplayer, myFinch finchcontroller)
    {
        int[] randomnumber = new int[4];
        for(int count = 0; count <= 3; count++)
        {
            randomnumber[count] = (int) Math.random() * 6 + 1; 
        }
        
        if(randomnumber[0] == 1 && randomnumber[3] == 5) 
        {
            System.out.println("(Random event time!)");
            System.out.println("You are travelling along one of the main roads when you spot a figure with a large backpack off in the distance walking towards you along the road.");
            System.out.println("He seems to be wearing a red cross indicating he's a doctor like in the old times. He offers to give you a check up for free, what a cool guy.");
            System.out.println("Gain 30 hp.");
            currentplayer.changeHP(30);
        }
        else if(randomnumber[0] == 2)
        {
            System.out.println("(Random event time!)");
            System.out.println("The path you are walking on is particularly rough. Large, uneven rocks everywhere that are difficult to step on.");
            System.out.println("You trip and fell, that one looked like it hurt");
            System.out.println("Lose 5 hp.");
            currentplayer.changeHP(-5);
        }
        else if(randomnumber[0] == 3 || randomnumber[3] == 6)
        {
            System.out.println("(Random event time!)");
            System.out.println("Moving along your way you feel the wind picking up and getting pretty harsh.");
            System.out.println("And what do you know, its a dust storm. Good luck with this one, you know with the whole stinging winds and inability to breathe and all that.");
            System.out.println("Lose 30 hp.");
            currentplayer.changeHP(-30);
        }
        else if(randomnumber[0] == 4)
        {
            System.out.println("(Random event time!)");
            System.out.println("You continue on your merry way until you spot a group of guys with a camp on the side of the road.");
            System.out.println("You hope to sneak past them by going off the road for a bit but it turns out that did not work out so well.");
            System.out.println("They turn out to be bandits and chase you down wanting to rob you, just your luck right? (Get ready with the finch!)");
            if(finchcontroller.fightingFinch() == true)
            {
                System.out.println("You fight off the bandits quite expertly seeing as how they were in a group against little ol' you. Nice job.");
                System.out.println("You decide to give them a bit of karmic justice and steal some of their supplies instead, seems like they were well stocked, were.");
                System.out.println("Gain 10 hp.");
                currentplayer.changeHP(10);
            }
            else
            {
                System.out.println("The bandits caught up to you and you ended up getting knocked about by the jerks and having some of your stuff stolen. Good thing you like to hide your stuff in secret pockets.");
                System.out.println("Lose 10 hp.");
                currentplayer.changeHP(-10);
            }
        }
        else if(randomnumber[0] == 1 && randomnumber[1] == 3 && randomnumber[2] == 3 && randomnumber[3] == 7)
        {
            System.out.println("(Random event time!)");
            System.out.println("Waking up you pack up your camp and get moving along on your merry way, the weather is nice and you feel pretty great and are well stocked. What could go wrong?");
            System.out.println("Annnnnnd you were just killed by some jerk with a sniper rifle off in the distance. You must be very very unfortunate.");
            System.out.println("Current player loses.");
            currentplayer.changeHP(-100);
        }
    }
}