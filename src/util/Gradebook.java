/* This is part of the starter code!
 * You need to complete this class yourself!*/
package util;

import java.util.*;

// Import static method that converts numeric grade to corresponding letter grade.
import static util.Grade.calculateLetterGrade;

public class Gradebook {
    private ArrayList<Student> listOfStudents;

    // Constructor setting listOfStudents as the ArrayList for the gradebook.
    public Gradebook() {
        listOfStudents = new ArrayList<>();
    }

    // This method was provided in the starter code, servers to calculate the score average
    public double calculateAvg() {
        double sum = 0;
        for (Student s : listOfStudents)
            sum += s.getGrade().getScore();
        return sum / listOfStudents.size();
    }

    /* This method will print the corresponding letter grade of the average numerical score using the
       static method calculateLetterGrade*/
    public void printAverageLetterGrade() {
        double averageScore = calculateAvg();

        // Check if theres any students
        if (averageScore == -1.0) {
            System.out.println("No students in the gradebook.");
        } else {
            // Set a cast to the double value to truncate and set the average numerical score to its letter
            String averageLetterGrade = calculateLetterGrade((int) averageScore);
            System.out.println("Average letter grade: " + averageLetterGrade);
        }
    }

    // Simply adds student object as an index of the ArrayList and theres a student in the listOfStudents
    public void addStudent(Student student) {
        listOfStudents.add(student);
    }

    // Method was provided in starter code, it will calculate the median numerical score
    public float calculateMedian() {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for (Student s : listOfStudents)
            scores[i++] = s.getGrade().getScore();
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        else
            return scores[n / 2];
    }

    /* This method will print the corresponding letter grade of the median numerical score using the
      static method calculateLetterGrade*/
    public void printMedianLetterGrade() {
        double medianScore = calculateMedian();
        // Check if any students
        if (medianScore == -1.0) {
            System.out.println("No students in the gradebook.");
        } else {
            // Set a cast to the double value to truncate and set the median numerical score to its letter
            String medianLetterGrade = Grade.calculateLetterGrade((int) medianScore);
            System.out.println("Median letter grade: " + medianLetterGrade);
        }
    }

    // Method is not used but is useful to printAllStudents and check while working, starter code.
    public void printAllStudents() {
        for (Student s : listOfStudents)
            System.out.printf("%s\t%s\t%d\t%d\t%s\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore(), s.getGrade().getLetterGrade());
    }

    /* This method will print the minimum score of the student ArrayList. Breaking it down:*/
    public int calculateMinimumScore() {
        // Check if the list is empty.
        if (listOfStudents.isEmpty()) {
            return -1; // Return a special value to indicate no students
        }
        // Creates an int that represents the current index of the list.
        int minScore = listOfStudents.get(0).getGrade().getScore();
        // Loops through the list
        for (Student student : listOfStudents) {
            // Gets current index in loop iteration.
            int score = student.getGrade().getScore();
            /* Checks if the current index is smaller than the first index. If so, then set it to
               the minimum score.*/
            if (score < minScore) {
                minScore = score;
            }
        }
        // Return the minimum score.
        return minScore;
    }

    /* This method will print the maximum score of the student ArrayList. Breaking it down:*/
    public int calculateMaximumScore() {
        // Check if empty.
        if (listOfStudents.isEmpty()) {
            return -1; // Return a special value to indicate no students
        }
        // Creates an int that represents the current index of the list.
        int maxScore = listOfStudents.get(0).getGrade().getScore();
        // Loops through the list.
        for (Student student : listOfStudents) {
            // Gets current index in loop iteration.
            int score = student.getGrade().getScore();
            /* Checks if the current index is bigger than the first index. If so, then set it to
               the maximum score.*/
            if (score > maxScore) {
                maxScore = score;
            }
        }
        // Return the maximum score.
        return maxScore;
    }

    // This method converts the maximum score to its letter grade equivalent.
    /* Note: To make more efficient, this method could call the calc max score and
       just convert the return value to its letter grade equivalent using the static method.*/
    public String calculateMaximumLetterGrade() {
        // Check if empty.
        if (listOfStudents.isEmpty()) {
            return "No students in the gradebook.";
        }
        // Set starting value.
        String maxLetterGrade = listOfStudents.get(0).getGrade().getLetterGrade();
        // Loop through list.
        for (Student student : listOfStudents) {
            // Set current value.
            String letterGrade = student.getGrade().getLetterGrade();
            // Compare both.
            if (letterGrade.compareTo(maxLetterGrade) < 0) {
                maxLetterGrade = letterGrade;
            }
        }
        // Return max letter grade.
        return maxLetterGrade;
    }

    // This method converts the minimum score to its letter grade equivalent.
    /* Note: To make more efficient, this method could call the calc min score and
       just convert the return value to its letter grade equivalent using the static method.*/
    public String calculateMinimumLetterGrade() {
        // Check if empty.
        if (listOfStudents.isEmpty()) {
            return "No students in the gradebook.";
        }
        // Set starting value.
        String minLetterGrade = listOfStudents.get(0).getGrade().getLetterGrade();
        // Loop through the list.
        for (Student student : listOfStudents) {
            // Set current value.
            String letterGrade = student.getGrade().getLetterGrade();
            // Compare
            if (letterGrade.compareTo(minLetterGrade) > 0) {
                minLetterGrade = letterGrade;
            }
        }
        // Return min letter grade
        return minLetterGrade;
    }

    // This method serves to search for the letter grade given the pid. First start off with int param
    public String findLetterGradeByPid(int pid) {
        // Loop through the list.
        for (Student student : listOfStudents) {
            // Check if the pid in the list matches the pid entered.
            if (student.getPid() == pid) {
                // Return the letter grade that correlates to the pid.
                return student.getGrade().getLetterGrade();
            }
        }
        // Else, return that the student was not found.
        return "Student not found.";
    }

    // This method searches for the students name given the pid as an int param.
    public String findStudentNameByPid(int pid) {
        // Loop through the list.
        for (Student student : listOfStudents) {
            // Check if the pid in the list matches the pid entered.
            if (student.getPid() == pid) {
                // Return the firstName + whitespace + lastName value of the student in the list.
                return student.getFirstName() + " " + student.getLastName();
            }
        }
        // Else, return that the student was not found.
        return "Student not found.";
    }

    /* This method updates the current students score given the new score they wish to enter.
       The user first searches for the student by their pid. */
    public void changeGradeByPid(int pid, int newScore) {
        // Loop through the list.
        for (Student student : listOfStudents) {
            // If the student matches the pid entered.
            if (student.getPid() == pid) {
                // Sets the new score value they entered and replaces the current score under that pid.
                student.getGrade().setScore(newScore);
                // Update the list.
                return;
            }
        }
        // Else, no student was found and the grade was not changed.
        System.out.println("Student not found. Grade not changed.");
    }

    // Simply prints the listOfStudents in the format of a table with the letter grade. If empty, then no students.
    public void printStudentTableLetters() {
        if (listOfStudents.isEmpty()) {
            System.out.println("No students in the gradebook.");
        } else {
            System.out.println("First Name\tLast Name\tPID\tLetter Grade");
            for (Student student : listOfStudents) {
                System.out.println(student.getFirstName() + "\t" +
                        student.getLastName() + "\t" +
                        student.getPid() + "\t" +
                        student.getGrade().getLetterGrade());
            }
        }
    }

    // Simply prints the listOfStudents in the format of a table with the score. If empty, then no students.
    public void printStudentTableScores() {
        if (listOfStudents.isEmpty()) {
            System.out.println("No students in the gradebook.");
        } else {
            System.out.println("First Name\tLast Name\tPID\tScore");
            for (Student student : listOfStudents) {
                System.out.println(student.getFirstName() + "\t" +
                        student.getLastName() + "\t" +
                        student.getPid() + "\t" +
                        student.getGrade().getScore());
            }
        }
    }

}
