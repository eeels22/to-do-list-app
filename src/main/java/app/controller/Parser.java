package app.controller;

import java.util.Scanner;

/**
 * The Parser is responsible for processing user input.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Parser {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Default Parser constructor
     */
    public Parser() {
    }

    /**
     * Gets the next line of user input from the Scanner and returns it as a string.
     *
     * @return the user's string input
     */
    public static String getNextLine() {
        return scanner.nextLine();
    }

    /**
     * Gets the next integer user input.
     *
     * @return the user's integer input
     */
    public int getNextInt() throws NumberFormatException {
        String inputString = scanner.nextLine();
        return Integer.parseInt(inputString);
    }

}
