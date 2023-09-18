/* This is part of the starter code!
 * You need to complete this class yourself!*/
package util;

public class Grade {
    private int score;
    private String letterGrade;

    public int getScore() {
        return score;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    /* Grade constructor, will hold the numeric score as a parameter and also store the letter grade
       equivalent of that numeric score in a letterGrade*/
    public Grade(int score) {

        /* Checks if score is non-negative, or greater than 100, mostly not needed since whitespace count is 4
           However, if user enters information such as score of 1, it will be stored*/
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be a non-negative integer between 0 and 100.");
        }

        this.score = score;
        this.letterGrade = calculateLetterGrade(score);
    }

    // Useful method to convert scores to their corresponding letter grades with the cutoff points
    static String calculateLetterGrade(int score) {
        if (score >= 90 && score <= 100) {
            return "A";
        } else if (score >= 80 && score <= 89) {
            return "B";
        } else if (score >= 70 && score <= 79) {
            return "C";
        } else if (score >= 60 && score <= 69) {
            return "D";
        } else {
            return "F";
        }
    }

    // This method servers to set the updated score of the student when updating scores
    public void setScore(int score) {

        // Again, checks for correct format
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be a non-negative integer between 0 and 100!");
        }
        this.score = score;

        // Convert score to its corresponding letter grade
        this.letterGrade = calculateLetterGrade(score);
    }

}