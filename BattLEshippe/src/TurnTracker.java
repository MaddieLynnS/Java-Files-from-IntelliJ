public class TurnTracker
{
    //This class should keep track of turns, which player is taking a turn, and if a turn is valid


    public static int turn;

    public static int getTurn()
    {
        return ((turn % 2) + 1);
    }

    //This method returns true if space row, col is a valid space
    public static boolean pickLocation(GameBoard guessBoard, int row, int col)
    {
        if(!guessBoard.guessboard[row][col].equals("H") && !guessBoard.guessboard[row][col].equals("M"))
        {
            return true;
        }
        return false;
    }

    //This method returns true if space row, col has a ship
    public static boolean hasBoat(GameBoard shipBoard, int col, int row)
    {
        //if row, col has ship, return true
        if(shipBoard.shipboard[row][col].equals("="))
        {
            return true;
        }
        //else return false
        return false;
    }
}
