package app.view;

/**
 * The Responder is responsible for printing information to the terminal.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Printer {

    /**
     * Prints a welcome message.
     */
    public void printWelcome() {
        System.out.println("\n***************************************");
        System.out.println("WELCOME TO JOTTER! Let's get organised.");
        System.out.println("***************************************");
    }

    /**
     * Prints a goodbye message.
     */
    public void printGoodbye() {
        System.out.println("\n********************************************");
        System.out.println("THANKS FOR USING JOTTER. See you again soon!");
        System.out.println("********************************************");
    }

    /**
     * Prints the desired string and moves the cursor to the next line.
     */
    public void printLine(String printString) {  // todo replace all Sout with this method
        System.out.println(printString);
    }

    /**
     * Prints a visual cue for user to enter an input.
     */
    public void printInputCue() {  //
        System.out.print(">  ");
    }

    /**
     * Prints the main menu options.
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
     * Prints the menu for options to edit a task.
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
        System.out.print("==============");
    }

    /**
     * Prints the 'Editing an existing task' header
     */
    public void printHeaderForEditingAnExistingTask() {
        System.out.println("\nEDITING AN EXISTING TASK");
        System.out.println("========================");
    }

    /**
     * Prints the 'New task added' header
     */
    public void printHeaderForTaskUpdated() {
        System.out.println("\nTASK UPDATED");
        System.out.println("============");
    }

    /**
     * Prints confirmation of task removal.
     */
    public void printConfirmationTaskRemoved() {
        System.out.println("\nTask removed.");
    }

    /**
     * Prints a message advising that the user input is invalid and to try again.
     */
    public void printInvalidInputMessage() {
        System.out.println("Sorry, that input is invalid, please try again.");
        printInputCue();
    }

    /**
     * Prints prompt for user to select a task to edit.
     */
    public void printPromptForTaskToEdit(String numberedTaskTitles) {
        System.out.println("\nWhich task would you like to edit?" + numberedTaskTitles);
        System.out.println();
        printInputCue();
    }

    /**
     * Prints prompt for user to enter a task title.
     */
    public void printPromptForTitle() {
        System.out.println("Enter the task title (required):");
        printInputCue();
    }

    /**
     * Prints prompt for user to enter a due date.
     */
    public void printPromptForDueDate() {
        System.out.println("Enter the due date in the format YYYY-MM-DD:");
        printInputCue();
    }

    /**
     * Prints prompt for user to enter a task project.
     */
    public void printPromptForProject() {
        System.out.println("Enter the project that this task belong to (optional):");
        printInputCue();
    }

    /**
     * Prints how many tasks there are and how many are done.
     * @param numTasks total number of tasks
     * @param numDoneTasks number of tasks that are done
     */
    public void printTaskListOverview(int numTasks, int numDoneTasks) {
        System.out.println("\nTotal tasks: " + numTasks + "\nDone tasks: " + numDoneTasks);
    }
}
