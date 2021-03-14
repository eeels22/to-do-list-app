package app;

import java.io.EOFException;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class implements a to do list application.
 * It is the top level class in this project.
 * The app communicates via text input and output in the terminal.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class ToDoListApp {
    private final Parser parser; // todo should this be public static?
    private final Printer printer;
    private final TaskList taskList;
    private boolean usingApp;

    /**
     * Creates a to do list app
     */
    public ToDoListApp() {
        printer = new Printer();
        parser = new Parser();
        taskList = loadTaskList();
        usingApp = true;
    }

    public static void main(String[] args) {
        ToDoListApp toToListApp = new ToDoListApp();
        toToListApp.start();
    }

    /**
     * Starts the to do list app and remains running until the user quits.
     */
    public void start() {
        printer.printWelcome();
        getNumberOfDoneTasksOutOfTotal();
        while (usingApp) {
            printMainMenuAndPerformChoice();
        }
        printer.printGoodbye();
    }

    /**
     * Prints the main menu options and performs the user's choice
     */
    public void printMainMenuAndPerformChoice() {
        printer.printMainMenu();
        int menuChoice = getValidatedMenuChoice(4); //todo update param if menu size changes
        performMainMenuChoice(menuChoice);
    }

    /**
     * Prints the view task menu options and responds to the user's choice
     */
    public void viewTaskListByChosenSortingOrder() {
        printer.printViewTaskListMenu();
        int menuChoice = getValidatedMenuChoice(4); //todo update param if menu size changes
        performViewTaskMenuChoice(menuChoice);
    }

    /**
     * Returns the task list
     */
    public TaskList getTaskList() {
        return taskList;
    }

    /**
     * Responds to the user's chosen main menu option
     *
     * @param mainOptionChosen the user's chosen menu option
     */
    public void performMainMenuChoice(int mainOptionChosen) {
        switch (mainOptionChosen) {
            case 1:
                viewTaskListByChosenSortingOrder();
                break;
            case 2:
                addNewTask();
                break;
            case 3:
                editAnExistingTask();
                break;
            case 4:
                saveTaskList();
                usingApp = false;
                break;
            default:
                break;
        }
    }

    /**
     * Performs the user's desired edit operation on a chosen task.
     *
     * @param operationChosen type of editing operation
     * @param indexTaskToEdit index of the task to be edited
     */
    private void performEditChoice(int operationChosen, int indexTaskToEdit) {
        switch (operationChosen) {
            case 1:
                editTaskDetails(indexTaskToEdit);
                break;
            case 2: // Mark a task as done
                taskList.getTask(indexTaskToEdit).setDoneStatus(true); // todo add confirmation line
                break;
            case 3:
                taskList.removeTask(indexTaskToEdit); // todo add confirmation line
                break;
            default:
                break;
        }
    }

    public void performViewTaskMenuChoice(int viewOptionChosen) {
        switch (viewOptionChosen) {
            case 1:
                // by due date ascending
                sortAndPrintTaskList(1, false);
                break;
            case 2:
                // by due date descending
                sortAndPrintTaskList(1, true);
                break;
            case 3:
                // by project ascending
                sortAndPrintTaskList(2, false);
                break;
            case 4:
                // by project descending
                sortAndPrintTaskList(2, true);
                break;
            default:
                printer.printInvalidInputMessage();
                break;
        }
    }

    /**
     * Sort and print task list
     */
    public void sortAndPrintTaskList(int type, boolean descending) {
        taskList.sortList(type, descending);
        printer.printTaskListHeader();
        printer.printLine("\n" + taskList.toString());
    }

    /**
     * Determine which task the user wants to edit, or advises there are no existing tasks.
     *
     * @return index of the task to be edited
     */
    public int determineTaskToEdit() {  //todo return Task?
        int sizeOfTaskList = taskList.getTasks().size();
        int indexTaskToEdit;
        if (sizeOfTaskList == 1) { // only one task, index must be 0
            indexTaskToEdit = 0;
        } else if (sizeOfTaskList > 1) { // user picks task to edit
            printer.printLine("\nWhich task would you like to edit?" + taskList.getNumberedTaskTitles());
            printer.print("\n>  ");
            indexTaskToEdit = getValidatedMenuChoice(sizeOfTaskList);
        } else { // no tasks available to edit
            throw new NullPointerException("No existing tasks to edit.");
        }
        return indexTaskToEdit;
        //todo replace return type with Task
    }

    /**
     * Determine which operation the user wants to perform on a given task
     */
    public int determineEditChoice() { // todo merge with method above? this never needs to be called on its own
        printer.printEditOptions();
        return getValidatedMenuChoice(3);
    }

    /**
     * Instructs the FileHandler to load the previous taskList from file
     */
    public TaskList loadTaskList() {
        try {
            FileHandler fileHandler = new FileHandler();
            return fileHandler.loadTaskListFromFile();
        } catch (EOFException eofException) {
            printer.printLine("No task list saved. Creating a new task list... ");
            return new TaskList();
        } catch (IOException | ClassNotFoundException exception) {
            printer.printLine("Oops, there's a problem with loading the file. Creating a new task list instead...");
            return new TaskList();
        }
    }

    /**
     * Instructs the File Handler to save this task list to file
     */
    public void saveTaskList() {
        try {
            FileHandler fileHandler = new FileHandler();
            fileHandler.saveTaskListToFile(taskList);
        } catch (IOException exception) {
            printer.printLine("Oops, there's a problem with saving the file: " + exception);
        }

    }

    /**
     * Gets the user's validated menu choice input.
     *
     * @param menuSize number of menu options
     * @return true if the menu choice is within range, or false if not.
     */
    public int getValidatedMenuChoice(int menuSize) {
        try {
            int menuChoice = parser.getNextInt();
            boolean integerInRange = menuChoice >= 1 && menuChoice <= menuSize;
            while (!integerInRange) {
                printer.printInvalidInputMessage();
                menuChoice = parser.getNextInt();
            }
            return menuChoice;
        } catch (NumberFormatException numberFormatException) {
            printer.printInvalidInputMessage();
            return getValidatedMenuChoice(menuSize);
        }
    }


    /**
     * Prompts the user to enter a new title and returns a valid title.
     *
     * @return a nn-empty title String.
     */
    public String getValidatedTitle() {
        String title = Parser.getNextLine();
        while (title.isEmpty()) {
            printer.printPromptForTitle();
            title = Parser.getNextLine();
        }
        return title;
    }

    /**
     * Gets the user's validated menu choice input.
     *
     * @return a valid local date.
     */
    public LocalDate getValidatedLocalDate() {
        try {
            String dueDateInput = Parser.getNextLine();
            return LocalDate.parse(dueDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeException dateTimeException) {
            printer.printInvalidInputMessage();
            return getValidatedLocalDate();
        }
    }

    /**
     * Performs the user's chosen edit operation on the user's chosen task.
     */
    public void editTaskDetails(int indexTaskToEdit) {
        Task taskToEdit = taskList.getTask(indexTaskToEdit);
        printer.printHeaderForEditingAnExistingTask();
        String title = determineTitle();
        taskToEdit.setTitle(title);
        LocalDate dueDate = determineDueDate();
        taskToEdit.setDueDate(dueDate);
        String project = determineProject();
        taskToEdit.setProject(project);
        printer.printHeaderForTaskUpdated();
        printer.printLine(taskToEdit.toString());
    }

    /**
     * Performs the user's chosen edit operation on the user's chosen task.
     */
    public void editAnExistingTask() {
        try {
            int indexTaskToEdit = determineTaskToEdit() - 1; //offset zero-based menu index
            int editChoice = determineEditChoice();
            performEditChoice(editChoice, indexTaskToEdit);
        } catch (NullPointerException nullPointerException) {
            printer.printLine("There are no existing tasks to edit"); //todo check other possible exceptions
        }
    }

    /**
     * Adds a new task based on user inputs.
     */
    public void addNewTask() {
        printer.printHeaderForAddingANewTask(); // determine field values
        String title = determineTitle();
        LocalDate dueDate = determineDueDate();
        String project = determineProject();
        Task task = new Task(title, dueDate, project); // instantiate task and add to list
        taskList.getTasks().add(task);
        printer.printHeaderForNewTaskAdded(); // confirm
        printer.printLine(task.toString());
    }

    /**
     * Returns a valid task title
     */
    public String determineTitle() {
        printer.printPromptForTitle();
        return getValidatedTitle();
    }

    /**
     * Returns a valid due date
     */
    public LocalDate determineDueDate() {
        printer.printPromptForDueDate();
        return getValidatedLocalDate();
    }

    /**
     * Returns a valid project name, which may be empty.
     */
    public String determineProject() {
        printer.printPromptForProject();
        return Parser.getNextLine();
    }

    /**
     * Prints how many tasks are on the list and how many of them are done.
     */
    public void getNumberOfDoneTasksOutOfTotal() {
        int numTasks = taskList.getNumberOfTasks();
        int numDoneTasks = taskList.getNumberOfDoneTasks();
        printer.printLine("\nYou have " + numTasks + " tasks of which " + numDoneTasks + " are done.");
    }


}
