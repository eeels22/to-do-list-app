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

    public Parser() {
        scanner = new Scanner(System.in);
    }

    public static String getNextLine() {  // todo check closing of scanner after each use
        return scanner.nextLine();
    }

    public int getNextInt() {
        String inputString = scanner.nextLine(); // todo check closing of scanner after each use
        return Integer.parseInt(inputString);
    }

//    public boolean validateMenuOption(int menuOptionChosen, int minMenuChoice, int maxMenuChoice) {
//        boolean isValue = false;
//        String inputString = scanner.nextLine(); // todo check closing of scanner after each use
//        return isValid;
//    }


}

