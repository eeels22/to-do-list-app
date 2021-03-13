package app;
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
        System.out.println("***************************************");
        System.out.println("WELCOME TO JOTTER! Let's get organised.");
        System.out.println("***************************************");
    }

    /**
     * Prints the desired string.
     */
    public void print(String printString) {
        System.out.println(printString);
    }

    /**
     * Prints the top-level menu options.
     */
    public void printMainMenu() {
        System.out.println("\nMAIN MENU");
        System.out.println("=========");
        System.out.println("Please select an option:");
        System.out.println("(1) View task list");
        System.out.println("(2) Add a new task");
        System.out.println("(3) Edit an existing task");
        System.out.println("(4) Save and quit\n");
        System.out.print(">  ");
    }

    /**
     * Prints the menu for options to show the task list.
     */
    public void printViewTaskListMenu() {
        System.out.println("\nVIEW TASK LIST MENU");
        System.out.println("===================");
        System.out.println("How would you like to view the task list?");
        System.out.println("(1) Default order");
        System.out.println("(2) By due date (ascending)");
        System.out.println("(3) By due date (descending)");
        System.out.println("(4) By project (ascending)");
        System.out.println("(5) By project (descending)\n");
        System.out.print(">  ");
    }

    /**
     * Prints the three different options to edit a task.
     */
    public void printEditOptions() {
        System.out.println("\nEDIT OPTIONS");
        System.out.println("=================");
        System.out.println("Please select an option:");
        System.out.println("(1) Edit task details");
        System.out.println("(2) Mark a task as done");
        System.out.println("(3) Remove a task\n");
        System.out.print(">  ");
    }

    /**
     * Prints the task list header
     */
    public void printTaskListHeader() {
        System.out.println("\nYOUR TASK LIST");
        System.out.println("==============");
    }

    /**
     * Prints error message regarding an invalid input
     */
    public void printInvalidInputMessage() {
        System.out.println("\nInvalid input, please try again.");
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
