public class Dice {
    // d20 dice
    public static int roll() {
        return (int) (Math.random() * (20 - 1) + 1);
    }
}