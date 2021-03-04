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
        String command;
        command = reader.nextLine();
        return command;
    }

    public void generateMainResponse(String command) {
        switch(command) {
            case "1":
                // show task list
                System.out.println("Should show task list");
                // print options: default order, sort by title, sort by project
                break;
            case "2":
                // add task
                Responder.printInstructionsToAddTask();
                // prompt title
                // prompt due date
                // prompt project - optional
                break;
            case "3":
                // edit task
                System.out.println("What would you like to edit?");
                // print options: edit title, edit due date, mark as done, remove task
                break;
            case "4":
                // save and quit
                System.out.println("Should save and quit");
                break;

        }

    }


}
