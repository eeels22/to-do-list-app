package app;

import java.util.Scanner;

/**
 * The Parser is responsible for processing user input.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Parser {
    private static Scanner scanner;

    /**
     * Constructs a Parser and instantiate a Scanner with the input source: System.in
     */
    public Parser() {
        scanner = new Scanner(System.in);
    }

    /**
     * Gets the next line of user input from the Scanner and returns it as a string.
     * @return the user's string input
     */
    public static String getNextLine() {  // todo check closing of scanner after each use
        return scanner.nextLine();
    } // todo change to non-static?

    /**
     * Gets the next integer user input.
     * @return the user's integer input
     */
    public int getNextInt() {
        String inputString = scanner.nextLine(); // todo check closing of scanner after each use
        return Integer.parseInt(inputString);
    }

     /**
     * Closes the scanner.
     */
    public void close() {
        scanner.close();
    }

//    public boolean validateMenuOption(int menuOptionChosen, int minMenuChoice, int maxMenuChoice) {
//        boolean isValue = false;
//        String inputString = scanner.nextLine(); // todo check closing of scanner after each use
//        return isValid;
//    }


}

