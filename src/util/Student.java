/* This is part of the starter code!
 * You need to complete this class yourself!*/
package util;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPid() {
        return pid;
    }

    public Grade getGrade() {
        return grade;
    }

    // Creates student constructor, student will have a first name, last name, a pid, and a score
    public Student(String firstName, String lastName, int pid, int score) {

        // Check if the input for the pid has leading zeros
        if (pid < 1000000 || pid > 9999999) {
            throw new IllegalArgumentException("PID cannot have any leading zeros! Please try again.");
        }
        // Also checks in case its a String
        if (Integer.toString(pid).startsWith("0")) {
            throw new IllegalArgumentException("PID cannot have leading zeros.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = new Grade(score);
    }

}
