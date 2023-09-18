/* This is part of the starter code!
        * You need to complete this !*/
        package main;

// Organized imports, for exception handling, storing data, reading input, and formatting String input using regex
import util.Gradebook;
import util.Student;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // Main method
    public static void main(String[] args) {

        // Create the gradebook object for the commands and scanner for input
        Gradebook gradebook = new Gradebook();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to my grade book!\nPlease enter the information of " +
                "the first student using the following format:\n" + "\"firstName lastName PID grade\".\n" +
                "Press Enter when you are done.");

        command = scanner.nextLine();

        // Checks the input to quit
        if (command.equalsIgnoreCase("quit")) {
            System.out.println("Exiting the program.");
            System.exit(0);
        }

        // Split the string by whitespace
        String[] parts1 = command.split(" ");

        // Checks if there is more than 4 whitespaces to validate format
        if (parts1.length != 4) {
            System.out.println("Invalid input format!");
            System.exit(0);
        }
        // This is the regex pattern for the following format: "Ann Smith 1234567 90"
        String pattern = "^[A-Z][a-z]+\\s[A-Z][a-z]+\\s\\d{7}\\s\\d{2}$";

        // The following operation compiles the pattern, and compares it to the user input
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(command);

        // If the user input matches the pattern, it will return true and execute, else the program will quit
        if (matcher.matches()) {

            /* This try-catch statement will ensure that the string values will be converted to their
            designated values in order to store them, also serves to handle format error*/
            try {
                // Split the strings and convert these values
                String firstName1 = parts1[0];
                String lastName1 = parts1[1];
                int pid1 = Integer.parseInt(parts1[2]);
                int score1 = Integer.parseInt(parts1[3]);

                // Create a student object and add these values into the ArrayList
                Student student1 = new Student(firstName1, lastName1, pid1, score1);
                gradebook.addStudent(student1);
                System.out.println("First student added!");

                // Begin the repetition for the following students, will continuously ask to add student, stop, or quit
                while (true) {
                    System.out.println("Please enter the information of " +
                            "the next student using the same format.\n" +
                            "If there is no more students, please enter the keyword " + "\"DONE\".\n" +
                            "Press Enter when you are done.");
                    command = scanner.nextLine();

                    /* The following conditions will support the list of commands mentioned in the print statement
                       This is to compute the methods once DONE is entered (method explanation in Gradebook class)*/
                    if (command.equalsIgnoreCase("quit")) {
                        System.out.println("Exiting the program.");
                        System.exit(0);
                    }
                    if (command.equalsIgnoreCase("DONE")) {
                        System.out.println("Please enter a new command: (minScore, maxScore, minLetter, maxLetter, letter, name, change, averageScore, " +
                                "averageLetter, medianScore, medianLetter, tabScores, tabLetters)");
                        command = scanner.nextLine();

                        if (command.equalsIgnoreCase("minScore")) {
                            int min = gradebook.calculateMinimumScore();
                            System.out.println("Minimum score: " + min);
                        } else if (command.equalsIgnoreCase("maxScore")) {
                            int max = gradebook.calculateMaximumScore();
                            System.out.println("Maximum score: " + max);
                        } else if (command.equalsIgnoreCase("minLetter")) {
                            String min = gradebook.calculateMinimumLetterGrade();
                            System.out.println("Minimum letter grade: " + min);
                        } else if (command.equalsIgnoreCase("maxLetter")) {
                            String max = gradebook.calculateMaximumLetterGrade();
                            System.out.println("Maximum letter grade: " + max);
                        } else if (command.equalsIgnoreCase("letter")) {
                            // Here, the method will ask the user to enter the pid.
                            try {
                                System.out.print("Enter PID to find letter grade: ");
                                // Sets the search as the input int.
                                int search = scanner.nextInt();
                                // Moves down a line in the scanner.
                                command = scanner.nextLine();
                                // Finds given the search as param.
                                String found = gradebook.findLetterGradeByPid(search);
                                System.out.print("Letter Grade for PID " + search + ": " + found);
                            }
                            // This serves to prevent the program from crashing as a result of an input thats not a number.
                            catch (InputMismatchException e) {
                            }
                        } else if (command.equalsIgnoreCase("name")) {
                            // Here, the method will ask the user to enter the pid.
                            try {
                                System.out.print("Enter the PID to find student name: ");
                                // Sets the search as the input int.
                                int search = scanner.nextInt();
                                // Moves down a line in the scanner.
                                command = scanner.nextLine();
                                // Finds given the search as param and prints the name.
                                String found = gradebook.findStudentNameByPid(search);
                                System.out.print("Student name for PID " + search + ": " + found);
                            }
                            // This serves to prevent the program from crashing as a result of an input thats not a number.
                            catch (InputMismatchException e) {
                            }
                        } else if (command.equalsIgnoreCase("change")) {
                            // Here, the method will ask the user to enter in the format of keyword change XXXXXXX YY.
                            System.out.print("Enter student number and new grade to change ('change 1234567 85'): ");
                            // Move to the next line in scanner.
                            command = scanner.nextLine();
                            // Creates a string splitter that seperates all whitespaces.
                            String[] changeParts3 = command.split(" ");
                            // If the string has 3 whitespaces and the keyword starts with change.
                            if (changeParts3.length == 3 && changeParts3[0].equalsIgnoreCase("change")) {
                                try {
                                    // Begin converting values to their corresponding values in the list.
                                    int change = Integer.parseInt(changeParts3[1]);
                                    int newScore = Integer.parseInt(changeParts3[2]);
                                    // Runs the method to change the
                                    gradebook.changeGradeByPid(change, newScore);
                                    System.out.println("Grade updated successfully.");
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid number format! Please try again.");
                                }
                            } else {
                                System.out.println("Invalid number format! Please try again.");
                            }
                        } else if (command.equalsIgnoreCase("averageScore")) {
                            double avg = gradebook.calculateAvg();
                            System.out.println("Average score: " + avg);
                        } else if (command.equalsIgnoreCase("averageLetter")) {
                            gradebook.printAverageLetterGrade();
                        } else if (command.equalsIgnoreCase("medianScore")) {
                            float med = gradebook.calculateMedian();
                            // Print float format.
                            System.out.printf("Median score: " + "%.2f", med);
                        } else if (command.equalsIgnoreCase("medianLetter")) {
                            gradebook.printMedianLetterGrade();
                        } else if (command.equalsIgnoreCase("tabScores")) {
                            gradebook.printStudentTableScores();
                        } else if (command.equalsIgnoreCase("tabLetters")) {
                            gradebook.printStudentTableLetters();
                        } else if (command.equalsIgnoreCase("quit")) {
                            System.out.println("Exiting the program.");
                            System.exit(0);
                        } else {
                            System.out.println("Please try again!");
                        }
                    }
                    /* If the user inputs anything else other than DONE or quit it will check for new student
                       or print error and repeat statement*/

                    // Split the new student user input string
                    String[] parts2 = command.split(" ");
                    if (parts2.length != 4) {
                        System.out.println(" ");
                        continue;
                    }

                    // Serves the same purpose to handle exceptions, and prevent errors
                    try {

                        // Format next student data
                        String firstName2 = parts2[0];
                        String lastName2 = parts2[1];
                        int pid2 = Integer.parseInt(parts2[2]);
                        int score2 = Integer.parseInt(parts2[3]);

                        // Create next student object and store it to the ArrayList
                        Student student2 = new Student(firstName2, lastName2, pid2, score2);
                        gradebook.addStudent(student2);
                        System.out.println("Student added!");

                        // The following statements are to prevent the code from crashing
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format! Please try again.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } // The following statements are to prevent the code from crashing
            } catch (NumberFormatException e1) {
                System.out.println("Invalid input format!");
            } catch (IllegalArgumentException e1) {
                System.out.println(e1.getMessage());
            }
            // If all else fails, the program will print this statement and quit
        } else {
            System.out.println("Invalid input format!");
        }
        // Close scanner
        scanner.close();
    }
}