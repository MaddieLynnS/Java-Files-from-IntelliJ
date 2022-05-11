////////
//CODE FOR MINI-GAME
////////

public class Question {
    
    private String question;
    private String correctAnswer;
    private int points;

    public Question(String question, String correctAnswer, int points) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String toString() {
        return this.question;
    }
}