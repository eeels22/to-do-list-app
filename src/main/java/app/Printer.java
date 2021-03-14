package app;
/**
 * The Responder is responsible for printing information to the terminal.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Printer {

    /**
     * Prints the welcome message when the app is started.
     */
    public void printWelcome() {
        System.out.println("***************************************");
        System.out.println("WELCOME TO JOTTER! Let's get organised.");
        System.out.println("***************************************");
    }

    /**
     * Prints the desired string and moves the cursor to the next line.
     */
    public void printLine(String printString) {  // todo replace all Sout with this method
        System.out.println(printString);
    }

    /**
     * Prints the desired string.
     */
    public void print(String printString) {
        System.out.print(printString);
    }

    /**
     *
     * */
    public void promptUser(String printString) {
        System.out.println(printString);
    }

    /**
     *
     * */
    public void printInfo(String printString) {
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
        System.out.println("View tasks by...");
        System.out.println("(1) Due date (Soonest first)");
        System.out.println("(2) Due date (Furthest first)");
        System.out.println("(3) Project (A to Z)");
        System.out.println("(4) Project (Z to A)\n");
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
        System.out.println("(2) Mark task as done");
        System.out.println("(3) Remove task\n");
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
        System.out.println("\nSorry, that input is invalid, please try again.");
        System.out.print(">  ");
    }

    /**
     * Prints instructions for adding a new task.
     */

    public static void printInstructionsToAddTask() {
        System.out.println("Enter the task title:");
    } // todo check use

    /**
     * Prints a goodbye message.
     */
    public void printNumberedTaskTitles() {
        System.out.println("Thanks for using Jotter. See you again soon!");
    }

    /**
     * Prints each task in the task list in default order.
     */
    public void printTaskList(TaskList taskList) { // todo check use
        System.out.println(taskList);
    }

    /**
     * Prints a goodbye message.
     */
    public void printGoodbye() {
        System.out.println("\nThanks for using Jotter. See you again soon!");
    }
}
