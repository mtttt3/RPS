import java.util.Random;     // need this for the random function
import java.util.Scanner;    // need this for the user input function

enum AttackType
{
    ROCK,
    PAPER,
    SCISSORS
}

public class RockPaperScissorsGame
{
    int MoveByBot;
    public void run()
    {
        boolean keepPlaying = true;
        

        while (keepPlaying)
        {
            // Code for the game goes here.
            // 
            // You can call the functions 'getRandomInt', 'getUserInt', and 'intToAttackType'
            // to help run the program. You may also want to define your own functions.
            //
            // Note: Since those functions are defined in this class, and we are using them
            // in this class, we can label them 'private'. If that's confusing, then just label
            // all of them 'public' for now. We will learn about private vs. public later.

            // <code>
            

            System.out.println("\nRock Paper Scissors Game");
            wait(1000);
            
            System.out.print("\nIts currently your turn: \n 0 - rock \n 1 - paper \n 2 - scissors\n");

            boolean g = true;
            while(g)
            {   
                // get user input
                // each if statement prints the user input, gets the bot move, and displays the match result

                Scanner i = new Scanner(System.in);

                // if "i" is not an integer LOOOOP back until "i" is an integer

                while (!i.hasNextInt()) 
                {
                    System.out.println("Erm, that is not a number...\n---------------------");
                    System.out.print("\nIts currently your turn: \n 0 - rock \n 1 - paper \n 2 - scissors\n");
                    i.next();
                     g = true;}

                int user_int = i.nextInt();

                if (user_int == 0) // user chose rock
                {
                    System.out.println("     You chose rock ");
                    wait(750);
                    intToAttackType(botMove());
                    matchResult(user_int,MoveByBot);
                    g = false;
                    
                }
                else if (user_int == 1) // user chose paper
                {
                    System.out.println("     You chose paper ");
                    wait(750);
                    intToAttackType(botMove());
                    matchResult(user_int,MoveByBot);
                    g = false;
                }
                else if (user_int == 2) // user chose scissors
                {
                    System.out.println("     You chose scissors ");
                    wait(750);
                    intToAttackType(botMove());
                    matchResult(user_int, MoveByBot);
                    g = false;
                }
                else // if "i" is an integer BUT NOT "0", "1", or "2" ask until valid
                {   

                    System.out.println("Erm, wrong choice...\n---------------------");
                    System.out.print("\nIts currently your turn: \n 0 - rock \n 1 - paper \n 2 - scissors\n");
                    g = true;
                }
                

            }

            System.out.println("Do you want to play again?");
            System.out.print("0->yes  1->no. Enter a number: ");
            int keepPlayingInt = getUserInt(0, 1);
            if (keepPlayingInt == 1)
            {
                keepPlaying = false;
            }
        }
    }
    

    private int botMove() // generate a random move for the bot
    {
        int e = getRandomInt(0, 2);
        MoveByBot = e;
        return e;
        
    }

    private void matchResult(int user_int, int MoveByBot) // Return nothing, print the match result
    {
        String x = "";
        // When user input is 0 (ROCK)
        if (user_int == 0 & MoveByBot == 0)
        x = "     The Bot chose the same movee (ROCK)\n ---Its a tie!---\n";
        else if (user_int == 0 & MoveByBot == 1)
        x =  "    The Bot chose Paper \n ---You lose---\n"; 
        else if (user_int == 0 & MoveByBot == 2)
        x = "     The Bot chose scissors \n ---You win!---\n";

        // When user input is 1 (PAPER)
        else if (user_int == 1 & MoveByBot == 1)
        x = "     The Bot chose the same move (PAPER)\n ---Its a tie!---\n";
        else if (user_int == 1 & MoveByBot == 0)
        x = "     The Bot chose rock \n ---You win!---\n";
        else if (user_int == 1 & MoveByBot == 2)
        x = "     The Bot chose Scissors \n ---You Lose---\n";

        //When user input is 2 (SCISSORS)
        else if (user_int == 2 & MoveByBot == 2)
        x = "     The Bot chose the same move (SCISSORS)\n ---Its a tie!---\n";
        else if (user_int == 2 & MoveByBot == 0)
        x = "     The Bot chose rock \n ---You lose---\n";
        else if (user_int == 2 & MoveByBot == 1)
        x = "     The Bot chose paper \n ---You win!---\n";

        
        System.out.println(x);
    }


    // 'getRandomInt' returns a random integer that is at least 'min' and at most 'max'.
    private int getRandomInt(int min, int max)
    {
        Random rand = new Random();
        return min + rand.nextInt(max - min + 1);
    }

    // 'getUserInt' loops until a valid integer has been submitted by the user that is at least 'min' and at most 'max'.
    // The function returns the valid integer that the user typed in.
    private int getUserInt(int min, int max)
    {
        Scanner scn = new Scanner(System.in);
        
        int userNumber = min - 1; // Set userNumber to be less than min, so that we enter the loop.
        String prompt = "Enter an integer between " + min + " and " + max + ": ";
        boolean repeat = false;

        while (userNumber < min || userNumber > max) // Note: || means or
        {
            // Modify the prompt based on whether we are repeating or not.
            if (repeat)
            {
                System.out.println("Number must be at least " + min + " and at most " + max + ".\n");
                System.out.print(prompt);
            }
            else
            {
                repeat = true;
                System.out.print(prompt);
            }
            
            // Loop as long as an integer has NOT been inputted.
            while (!scn.hasNextInt())
            {
                System.out.println("That is not an integer.\n");
                System.out.print(prompt);
                scn.next(); // Consume the next token. Note: scn.hasNextInt() does NOT consume the token.
            }

            // There is a valid integer, so grab that and store it in userNumber.
            userNumber = scn.nextInt();
        }

        return userNumber;
    }
    

    // 'intToAttackType' converts an integer to an AttackType, where AttackType is an enum.
    // The function returns the AttackType.
    // number 0 --> Rock
    // number 1 --> Paper
    // number 2 --> Scissors
    private AttackType intToAttackType(int number)
    {
        if (number == 0) { return AttackType.ROCK; }
        else if (number == 1) { return AttackType.PAPER; }
        else { return AttackType.SCISSORS; }
        
    }

    public static void wait(int ms)
    {
    try
    {
        Thread.sleep(ms);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
    }
}