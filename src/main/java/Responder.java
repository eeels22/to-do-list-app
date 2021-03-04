/**
 * The Responder is responsible for printing information to the terminal.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Responder {

    /**
     * Prints the welcome message when the app is started.
     */
    public void printWelcome() {

        System.out.println("Welcome to Jotter! Let's get organised.\n");
    }

    /**
     * Prints the top-level menu options.
     */
    public void printMainOptions() {
        System.out.println("Please select an option:");
        System.out.println("(1) Show task list");
        System.out.println("(2) Add a new task");
        System.out.println("(3) Edit an existing task");
        System.out.println("(4) Save and quit\n");
        System.out.print(">  ");
    }

    /**
     * Prints instructions for adding a new task.
     */

    public static void printInstructionsToAddTask() {
        System.out.println("Enter the task title:");
    }

    /**
     * Prints each task in the task list in default order.
     */
    public void printTaskList(TaskList taskList) {
        System.out.println(taskList);
    }

    /**
     * Prints each task in the task list in ascending title order.
     */


    /**
     * Prints each task in the task list in descending title order.
     */


    /**
     * Prints each task in the task list in ascending project order.
     */


    /**
     * Prints each task in the task list in descending project order.
     */


    /**
     * Prints a goodbye message.
     */
    public void printGoodbye() {
        System.out.println("Thanks for using Jotter. See you again soon!");
    }
}
