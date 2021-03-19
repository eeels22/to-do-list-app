package app.controller;

/**
 * The Validator checks that the input is valid.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Validator {

    /**
     * Checks if the menu choice is valid and throws an exception if it is invalid.
     *
     * @param menuSize   number of menu options
     * @param menuChoice user's chosen menu option
     * @throws IllegalArgumentException if the menu choice is not valid
     */
    public static void validateMenuChoice(int menuSize, int menuChoice) throws IllegalArgumentException {
        if (menuChoice < 1 || menuChoice > menuSize) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Checks if the title is empty and throws an exception if true.
     *
     * @param title a string that should not be empty to be validated
     * @throws IllegalArgumentException if the title is empty.
     */
    public static void validateStringIsNotEmpty(String title) throws IllegalArgumentException {
        if (title.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }


}
