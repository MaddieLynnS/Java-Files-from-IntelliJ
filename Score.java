public class Score {
    private int points;

    // Default Constructor
    public Score() {
        points = 0;
    }

    // Constructor with initial Points
    public Score(int initialPoints) {
        points = initialPoints;
    }
    
    // Get score
    public int getScore() {
        return points;
    }
}