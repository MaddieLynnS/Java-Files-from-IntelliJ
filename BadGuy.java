public class BadGuy {
    /////////////////////////////////////////////////////
    // Instance Variables
    /////////////////////////////////////////////////////

    private String name;

    // Items
    private Weapon weapon;

    // Hero Stats
    private int hitPoints;
    private int stamina;

    // Score
    private Score score;

    /////////////////////////////////////////////////////
    // Constructors
    /////////////////////////////////////////////////////

    // I have included 2 constructors, add other constructors for your program's use cases

    // Default Constructor
    public BadGuy() {
        // ** make sure that you are instantiating your instance variables **
        this.name = "BadGuy";

        // Default weapon
        this.weapon = new Weapon();

        this.hitPoints = 100;
        this.stamina = 100;

        // Default score
        this.score = new Score();
    }

    // Constructor with all parameters
    public BadGuy(String name, Weapon weapon, int hitPoints, int stamina, Score score) {
        this.name = name;
        this.weapon = weapon;
        this.hitPoints = hitPoints;
        this.stamina = stamina;
        this.score = score;
    }

    /////////////////////////////////////////////////////
    // Class Methods
    /////////////////////////////////////////////////////

    ////////
    //toString to print beginning stats
    ////////
    
    public String toString() {
        return "Meet your bad guy: " + name + ". He has a " + weapon.getName() + ", " +
        hitPoints + " hit points, " + stamina + " in stamina, and a score of " + score.getScore();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public boolean isDead() {
        return this.hitPoints <= 0;
    }
}