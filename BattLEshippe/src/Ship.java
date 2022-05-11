
//I'm not altogether sure how everything is working, but this class
//has a ship constructor and some getters and setters

public class Ship
{
    //public static ArrayList<Ship> boats = new ArrayList<Ship>();
    private String name;
    private int hitPoints;

    public Ship(String name, int hitPoints)
    {
        this.name = name;
        this.hitPoints = hitPoints;
    }

    public String getName()
    {
        return name;
    }
    public int getHitPoints()
    {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
    }
}
