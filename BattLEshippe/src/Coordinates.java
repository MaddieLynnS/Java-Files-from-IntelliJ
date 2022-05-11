public class Coordinates
{
    //This class exists solely to take the user input and format it correctly. For example,
    //if the user entered "G", this will turn it into col int, or 6.

    public static int convert(String row)
    {
        if(row.equals("A"))
        {
            return 0;
        }
        else if(row.equals("B"))
        {
            return 1;
        }
        else if(row.equals("C"))
        {
            return 2;
        }
        else if(row.equals("D"))
        {
            return 3;
        }
        else if(row.equals("E"))
        {
            return 4;
        }
        else if(row.equals("F"))
        {
            return 5;
        }
        else if(row.equals("G"))
        {
            return 6;
        }
        else if(row.equals("H"))
        {
            return 7;
        }
        else if(row.equals("I"))
        {
            return 8;
        }
        return 9;
    }
}
