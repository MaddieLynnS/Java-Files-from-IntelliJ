public class GameBoard
{

    //Contains both guessing and ship boards, starts them with "~" and can print them

    //Instance variables
    public String[][] shipboard = new String[10][10];
    public String[][] guessboard = new String[10][10];
    private boolean isGuessBoard;

    //Constructors differ based on guess or ship board
    public GameBoard()
    {
        for (int i = 0; i < shipboard.length; i++)
        {
            for (int j = 0; j < shipboard.length; j++)
            {
                shipboard[i][j] = "~";
            }
        }
    }

    public GameBoard(boolean isGuessBoard)
    {
        this.isGuessBoard = isGuessBoard;

        for (int i = 0; i < guessboard.length; i++)
        {
            for (int j = 0; j < guessboard.length; j++)
            {
                guessboard[i][j] = "~";
            }
        }
    }

    /*This method prints out the shipboard array on to the console
     */
    public void printShipBoard()
    {
        int num = 0;
        System.out.println("  A B C D E F G H I J");
        for(String[] row: shipboard)
        {
            System.out.print(num + " ");
            for (String play: row)
            {
                System.out.print(play + " ");
            }
            System.out.println();
            num++;
        }
    }

    /*This method prints out the guessboard array on to the console
     */
    public void printGuessBoard()
    {
        int num = 0;
        System.out.println("  A B C D E F G H I J");
        for(String[] row: guessboard)
        {
            System.out.print(num + " ");
            for (String play: row)
            {
                System.out.print(play + " ");
            }
            System.out.println();
            num++;
        }
    }
}
