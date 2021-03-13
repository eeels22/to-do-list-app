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
     * Prints the desired string.
     */
    public void printLine(String printString) { // todo is this needed?
        System.out.println(printString);
    } // todo replace all Sout with this method

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
        printLine("\nMAIN MENU");
        printLine("=========");
        printLine("Please select an option:");
        printLine("(1) View task list");
        printLine("(2) Add a new task");
        printLine("(3) Edit an existing task");
        printLine("(4) Save and quit\n");
        printLine(">  ");
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
        System.out.println("\nInvalid input, please try again.");
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
