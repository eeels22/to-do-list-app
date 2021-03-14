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
        System.out.println("\n***************************************");
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
     * Prints the cue for user input.
     */
    public void printInputCue() {  //
        System.out.print(">  ");
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
        printInputCue();
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
        printInputCue();
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
        printInputCue();
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
        printInputCue();
    }

    /**
     * Prints the 'Adding a new task' header
     */
    public void printHeaderForAddingANewTask() {
        System.out.println("\nADDING A NEW TASK");
        System.out.println("=================");
    }

    /**
     * Prints the 'New task added' header
     */
    public void printHeaderForNewTaskAdded() {
        System.out.println("\nNEW TASK ADDED");
        System.out.println("==============");
    }

    /**
     * Prints the 'Editing an existing task' header
     */
    public void printHeaderForEditingAnExistingTask() {
        System.out.println("\nEDITING AN EXISTING TASK");
        System.out.println("========================");
    }

    /**
     * Prints prompt for user to enter a task title.
     */
    public void printPromptForTitle() {
        System.out.println("\nEnter the task title (required):");
        printInputCue();
    }

    /**
     * Prints prompt for user to enter a due date.
     */
    public void printPromptForDueDate() {
        System.out.println("\nEnter the due date in the format YYYY-MM-DD:");
        printInputCue();
    }



    /**
     * Prints prompt for user to enter a task project.
     */
    public void printPromptForProject() {
        System.out.println("\nEnter the project that this task belong to (optional):");
        printInputCue();
    }

    /**
     *
     */
    public void printNumberedTaskTitles() {//todo update
        System.out.println("\n");
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
