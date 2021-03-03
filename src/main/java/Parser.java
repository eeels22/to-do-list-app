import java.util.Scanner;

/**
 * The Parser is responsible for processing user input.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Parser {
    Scanner reader;
    String inputLine;

    public Parser() {
        reader = new Scanner(System.in);
    }

    public void getCommand() {
        String inputLine;
        inputLine = reader.nextLine();
        this.inputLine = inputLine;
    }

    public void generateMainResponse() {
        switch(inputLine) {
            case "1":
                // show task list
                break;
            case "2":
                // add task
                break;
            case "3":
                // edit task
                break;
            case "4":
                // save and quit
                break;

        }

    }


}
