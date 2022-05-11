import java.util.Scanner;
public class Main {


    //We do be struggling but this here is the main
    //It could probably be much shorter but I kinda ran out of time
    //This is where the game is played and some other basic methods are called
    //Please note that wherever System.out.println("\033[H\033[2J"); is printed,
    //it would work in CodeHS but CodeHS is nothing compared to IntelliJ so
    //we're pretending it works haha.


    public static void main(String[] args)
    {

        /////////INITIALIZE VARIABLES/////////

        Scanner input = new Scanner(System.in);
        //ArrayList <Ship> ships = new ArrayList<Ship>();
        GameBoard jack = new GameBoard();
        GameBoard jill = new GameBoard(true);
        Player bob = new Player(jack, jill, "Bob");
        GameBoard ben = new GameBoard();
        GameBoard jerry = new GameBoard(true);
        Player barbie = new Player(ben, jerry, "Barbie");
        int win = 0;
        int win2 = 0;

        //////////START GAME///////////

        //print game intro
        //if I was a legend I'd ask the players if they want the intro
        //but I'm not going to because I don't care lol
        printIntro();

        //let both players create and set their boats
        bob.createBoats();
        System.out.print("Player one! ");
        bob.setShipBoard();
        System.out.println("Here are your ships:");
        jack.printShipBoard();
        System.out.println("\033[H\033[2J");

        barbie.createBoats();
        System.out.println("Player two!");
        barbie.setShipBoard();
        System.out.println("Here are your ships:");
        ben.printShipBoard();
        System.out.println("\033[H\033[2J");

        ///////////GAMEPLAY//////////

        waitAHotSec();
        while (win < 17 && win2 < 17)
        {
            int dude = TurnTracker.getTurn();
            System.out.println("Player " + dude + "! Your turn!");
            System.out.println("Here is your shipboard:");
            if(dude == 1)
            {
                //display player one's shipboard
                jack.printShipBoard();
            }
            if(dude == 2)
            {
                //display player two's shipboard
                ben.printShipBoard();
            }
            waitAHotSec();

            System.out.println("Here is your guessboard:");
            if(dude == 1)
            {
                //display player one's guessboard
                jill.printGuessBoard();
            }
            if(dude == 2)
            {
                //display player two's guessboard
                jerry.printGuessBoard();
            }
            waitAHotSec();

            input.nextLine();
            System.out.println("Where do you want to guess?");
            System.out.println("Enter a letter from A-J: ");
            String letter = input.nextLine();
            int col = Coordinates.convert(letter);
            System.out.println("Enter a number: ");
            int row = input.nextInt();
            //could put in provisions for invalid input if I have time

            //Finally take turn haha
            if(dude == 1)
            {
                if(bob.takeTurn(ben, col, row))
                {
                    win++;
                }
            }
            if(dude == 2)
            {
                if(barbie.takeTurn(jack, col, row))
                {
                    win2++;
                }
            }
            System.out.println("\033[H\033[2J");
            TurnTracker.turn++;
        }

        //Print which player won
        if(win > win2)
        {
            System.out.println("Player one wins! Yay!");
        }
        else
        {
            System.out.println("Player two wins! Yay!");
        }
    }

    //Makes game pause for a few seconds
    public static void waitAHotSec()
    {
        try
        {
            Thread.sleep(3500);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    //Prints intro to the game, then clears it off
    public static void printIntro()
    {
        System.out.println("Hello! Welcome to Battleship!");
        System.out.println("In case you don't know, here's how to play:");
        System.out.println("You are given five ships to hide on your shipboard. Your opponent will do the same.");
        System.out.println("Players take turns firing shots to attempt to hit the opponent's enemy ships.\n" +
                "On your turn, enter a letter and a number that identifies a row and column on your target grid. \nThis program checks that coordinate on their ocean grid and" +
                " will mark the spot with a \"X\" if there is no ship there, or \"O\" if you have correctly guessed a space that is occupied by a ship.\n" +
                "As the game proceeds, the hits will gradually identify the size and location of your opponent's ships.\n" +
                "When it is your opponent's turn to fire shots at you, each time one of your ships receives a hit, it will register on the ship corresponding to the grid space." +
                "\nWhen one of your ships has every slot filled with hits, your ship is sunk.\n" + "\n" +
                "The first player to sink all five of their opponent's ships wins the game!");
        waitAHotSec();
        waitAHotSec();
        System.out.println();
        System.out.println();
        System.out.println("If you're ready, let's play!");
        waitAHotSec();
        System.out.println("\033[H\033[2J");
    }
}
