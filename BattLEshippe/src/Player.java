import java.util.ArrayList;
import java.util.Scanner;

public class Player
{

    //This here's the player class. Lots of stuff happens here.
    //Players are created with getters and setters, are assigned
    //their boats, can place them, and can take their turn



    //Instance Variables
    private GameBoard shipBoard;
    private GameBoard guessBoard;
    private String name;
    ArrayList<Ship> boats = new ArrayList<Ship>();
    Scanner input = new Scanner(System.in);

    //Constructor
    public Player(GameBoard shipBoard, GameBoard guessBoard, String name)
    {
        this.shipBoard = shipBoard;
        this.guessBoard = guessBoard;
        this.name = name;
    }

    //Boring constructor
    public Player(String name)
    {
        this.shipBoard = new GameBoard(false);
        this.guessBoard = new GameBoard(true);
        this.name = name;
    }

    //Getters

    public String getName()
    {
        return name;
    }

    public GameBoard getShipBoard()
    {
         return shipBoard;
    }

    public GameBoard getGuessBoard()
    {
        return guessBoard;
    }

    //Create boats for each player
    public void createBoats()
    {
        Ship carry = new Ship("Carrier", 5);
        boats.add(carry);
        Ship battle = new Ship("Battleship", 4);
        boats.add(battle);
        Ship cruise = new Ship("Cruiser", 3);
        boats.add(cruise);
        Ship sub = new Ship("Submarine", 3);
        boats.add(sub);
        Ship destroy = new Ship("Destroyer", 2);
        boats.add(destroy);
    }

    //Helps player place their boats
    public void setShipBoard()
    {
        System.out.println("Place your boats!");
        System.out.println("The top of your boats will be placed at the row and column you input.");
        for(int i = 0; i < boats.size(); i++)
        {
            System.out.println("Enter letter from A-J to place your " + boats.get(i).getName());
            String letter = input.nextLine();
            int row = Coordinates.convert(letter);
            System.out.println("Enter number 0-9: ");
            int col = input.nextInt();//might also not need to be a minus one
            input.nextLine();
            System.out.println("Do you want this ship to be horizontal or vertical?");
            String orient = input.nextLine();
            checkboats(row, col, orient, boats.get(i).getHitPoints());

        }
    }

    //Determines whether boats can be placed at location row, col
    //without going out of bounds. Will move boat if needed, then place it.
    //Shipboard will have "=" indicating where the ships are
    //there are a few problems with this but it mostly works as intended
    private void checkboats(int r, int c, String o, int hits)
    {
        if(o.equals("horizontal"))
        {
            while((r + 5) > 10)
            {
                r--;
            }
            for (int j = 0; j < hits; j++)
            {
                this.shipBoard.shipboard[c][r + j] = "=";
            }
        }
        else if(o.equals("vertical"))
        {
            while((c + 5) > 10)
            {
                c--;
            }
            for(int j = 0; j < hits; j++)
            {
                this.shipBoard.shipboard[c + j][r] = "=";
            }
        }

        //I could technically put provisions for if they put a ship through another
        //but I kinda can't at the moment I'm rather busy lol

    }

    //intended to find ship the player hit and return its hit points
    //either that or find ship based on its hit points and return the ship itself
   // private Ship whichBoat()
   // {

   // }



    //This method places an X or O at location row, col based on the int turn
    public boolean takeTurn(GameBoard shippy, int col, int row)
    {
        if (TurnTracker.pickLocation(this.guessBoard, col, row))
        {
            //needs to be something to check if the space has a ship on it
            //I guess that would access the enemy's shipboard
            //should put "O" if it does, "X" if it doesn't
            if(TurnTracker.hasBoat(shippy, col, row))
            {
                System.out.println("That's a hit!");
                this.guessBoard.guessboard[row][col] = "O";
                //find out which boat and set its hit points, something like below
                //how to find out which boat I don't know, maybe separate method?
               // int old = boat.getHitPoints();
                //boat.setHitPoints(old - 1);
               // if(boat.getHitPoints() == 0);
                //{
                //    System.out.println("You sunk the " + boat.getName());
               // }
                return true;
            }
            System.out.println("That's a miss!");
            this.guessBoard.guessboard[row][col] = "X";
            return false;
        }
        System.out.println("Invalid input. Next person's turn!");
        return false;
    }

}
