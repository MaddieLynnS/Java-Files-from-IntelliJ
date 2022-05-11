public class Weapon {
    /////////////////////////////////////////////////////
    // Instance Variables
    /////////////////////////////////////////////////////
    private String name;
    private String type;
    private int durability;
    private int baseDamage;

    /////////////////////////////////////////////////////
    // Constructors - add as you see fit
    /////////////////////////////////////////////////////

    // Default Constructor
    public Weapon() {
        this.name = "Firey Fists of Fury";
        this.type = "Fists";
        this.durability = 100;
        this.baseDamage = 100;
    }

    // Constructor with all parameters
    public Weapon(String name, String type, int durability, int baseDamage) {
        this.name = name;
        this.type = type;
        this.durability = durability;
        this.baseDamage = baseDamage;
    }

    /////////////////////////////////////////////////////
    // Methods
    /////////////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
}