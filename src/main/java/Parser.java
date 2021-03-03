import java.util.Scanner;

/**
 * The Parser is responsible for processing user input.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Parser {
    Scanner reader;

    public Parser() {
        reader = new Scanner(System.in);
    }

    public String getCommand() {
        String inputLine;
        inputLine = reader.nextLine();
        return inputLine;
    }


}
