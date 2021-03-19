package app.controller;

import app.model.Task;
import app.model.TaskList;
import app.view.Printer;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class implements a to do list application. It is the top level class in this project.
 * The app communicates via text input and output in the terminal.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class ToDoListApp {
    private final Printer printer;
    private final FileHandler fileHandler;
    private final TaskList taskList;
    private boolean usingApp;

    /**
     * Creates a to do list app
     */
    public ToDoListApp() {
        printer = new Printer(); // printer responsible for text output
        fileHandler = new FileHandler(); // handles loading and saving to file
        taskList = fileHandler.loadTaskListFromFile(); // loads the previous task list from file
        usingApp = true; // this remains true until user saves and quits
    }

    /**
     * Main method creates a ToDoListApp and runs the app.
     */
    public static void main(String[] args) {
        ToDoListApp toToListApp = new ToDoListApp();
        toToListApp.runApp();
    }

    /**
     * Starts the to do list app and remains running until the user quits.
     */
    public void runApp() {
        printer.printWelcome();
        printer.printTaskListOverview(taskList.getNumberOfTasks(), taskList.getNumberOfDoneTasks());
        while (usingApp) {
            runMainMenu(); // returns to the main menu after each completed operation
        }
        printer.printGoodbye();
    }

    /**
     * Prints the main menu options and performs the user's choice
     */
    public void runMainMenu() {
        printer.printMainMenu();
        int menuChoice = getValidMenuChoiceFromUser(4);
        performMainMenuChoice(menuChoice);
    }

    /**
     * Prints the view task menu options and responds to the user's choice
     */
    public void runViewTaskListMenu() {
        printer.printViewTaskListMenu();
        int menuChoice = getValidMenuChoiceFromUser(4);
        performViewTaskMenuChoice(menuChoice);
    }

    /**
     * Responds to the user's chosen main menu option
     *
     * @param mainOptionChosen the user's chosen menu option
     */
    public void performMainMenuChoice(int mainOptionChosen) {
        switch (mainOptionChosen) {
            case 1:
                runViewTaskListMenu();
                break;
            case 2:
                addNewTaskAndConfirm();
                break;
            case 3:
                editAnExistingTask();
                break;
            case 4:
                save();
                usingApp = false;
                break;
            default:
                break;
        }
    }

    /**
     * Displays the task list in the sort order specified.
     *
     * @param viewOptionChosen the desired order to view the task list items
     */
    public void performViewTaskMenuChoice(int viewOptionChosen) {
        switch (viewOptionChosen) {
            case 1: // by due date ascending
                sortAndPrintTaskList(1, false);
                break;
            case 2: // by due date descending
                sortAndPrintTaskList(1, true);
                break;
            case 3: // by project ascending
                sortAndPrintTaskList(2, false);
                break;
            case 4: // by project descending
                sortAndPrintTaskList(2, true);
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
    public void performEditMenuChoice(int operationChosen, int indexTaskToEdit) {
        switch (operationChosen) {
            case 1:
                editTaskDetailsAndConfirm(indexTaskToEdit);
                break;
            case 2:
                markTaskAsDoneAndConfirm(indexTaskToEdit);
                break;
            case 3:
                removeTaskAndConfirm(indexTaskToEdit);
                break;
            default:
                break;
        }
    }

    /**
     * Sort the task list according to given instructions and prints it.
     *
     * @param type       what field to sort on
     * @param descending whether or not to reverse the natural order
     */
    public void sortAndPrintTaskList(int type, boolean descending) {
        taskList.sortList(type, descending);
        printer.printTaskListHeader();
        printer.printLine("\n" + taskList.toString());
    }

    /**
     * Performs the user's chosen edit operation on the user's chosen task.
     */
    public void editTaskDetailsAndConfirm(int indexTaskToEdit) {
        Task taskToEdit = taskList.getTask(indexTaskToEdit); // retrieve the task to edit
        printer.printHeaderForEditingAnExistingTask();
        String title = determineTitle(); // prompts for and updates task fields
        taskToEdit.setTitle(title);
        LocalDate dueDate = determineDueDate();
        taskToEdit.setDueDate(dueDate);
        String project = determineProject();
        taskToEdit.setProject(project);
        printer.printHeaderForTaskUpdated(); // prints confirmation
        printer.printLine(taskToEdit.toString());
    }

    /**
     * Marks a task as done.
     *
     * @param indexDoneTask the index of the task that is done
     */
    public void markTaskAsDoneAndConfirm(int indexDoneTask) {
        taskList.getTask(indexDoneTask).setDoneStatus(true);
        printer.printHeaderForTaskUpdated();
    }

    /**
     * Remove a task from the task list.
     *
     * @param indexTaskToRemove the index of the task that is done
     */
    public void removeTaskAndConfirm(int indexTaskToRemove) {
        taskList.removeTask(indexTaskToRemove);
        printer.printConfirmationTaskRemoved();
    }

    /**
     * Determines the task to be edited and returns its index.
     *
     * @return index of the task to be edited
     * @throws NumberFormatException if there are no tasks in the list
     */
    public int determineTaskToEdit() throws NullPointerException {
        int listSize = taskList.getTasks().size();
        int indexTaskToEdit;
        if (listSize == 0) { // no tasks available to edit
            throw new NullPointerException();
        } else if (listSize == 1) { // only one task, index must be 0
            indexTaskToEdit = 0;
        } else { // multiple tasks, user decides which task to edit
            indexTaskToEdit = getUserChoiceOfTaskToEdit(listSize);
        }
        return indexTaskToEdit;
    }

    /**
     * Prompts the user for which task they want to edit and returns its index.
     *
     * @param listSize number of tasks in the task list
     * @return index of the task to be edited
     */
    public int getUserChoiceOfTaskToEdit(int listSize) {
        printer.printPromptForTaskToEdit(taskList.getNumberedTaskTitles());
        return getValidMenuChoiceFromUser(listSize);
    }

    /**
     * Determine which edit operation the user wants to perform on a given task
     *
     * @return menu number of the chosen edit operation
     */
    public int determineEditChoice() {
        printer.printEditOptions();
        return getValidMenuChoiceFromUser(3);
    }

    /**
     * Gets the user's validated menu choice input.
     *
     * @param menuSize number of menu options
     * @return the user's valid menu choice.
     */
    public int getValidMenuChoiceFromUser(int menuSize) {
        try {
            int menuChoice = Parser.getNextInt();
            Validator.validateMenuChoice(menuSize, menuChoice);
            return menuChoice;
        } catch (IllegalArgumentException illegalArgumentException) {
            printer.printInvalidInputMessage();
            return getValidMenuChoiceFromUser(menuSize);
        }
    }

    /**
     * Prompts the user to enter a new title and returns a valid title.
     *
     * @return a non-empty title String.
     */
    public String getValidTitleFromUser() {
        try {
            String title = Parser.getNextLine();
            Validator.validateStringIsNotEmpty(title);
            return title;
        } catch (IllegalArgumentException illegalArgumentException) {
            printer.printPromptForTitle();
            return getValidTitleFromUser();
        }
    }

    /**
     * Gets the user's validated menu choice input.
     *
     * @return a valid LocalDate.
     */
    public LocalDate getValidLocalDateFromUser() {
        try {
            String dueDateInput = Parser.getNextLine();
            return LocalDate.parse(dueDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeException dateTimeException) {
            printer.printInvalidInputMessage();
            return getValidLocalDateFromUser();
        }
    }

    /**
     * Performs the user's chosen edit operation on the user's chosen task.
     */
    public void editAnExistingTask() {
        try {
            int indexTaskToEdit = determineTaskToEdit() - 1; // offset one-based menu index
            int editChoice = determineEditChoice();
            performEditMenuChoice(editChoice, indexTaskToEdit);
        } catch (NullPointerException nullPointerException) {
            printer.printLine("There are no existing tasks to edit");
        }
    }

    /**
     * Adds a new task based on user inputs.
     */
    public void addNewTaskAndConfirm() {
        printer.printHeaderForAddingANewTask();
        String title = determineTitle(); // determine field values...
        LocalDate dueDate = determineDueDate();
        String project = determineProject();
        Task task = new Task(title, dueDate, project); // instantiate task and add to list
        taskList.getTasks().add(task);
        printer.printHeaderForNewTaskAdded(); // confirm
        printer.printLine(task.toString());
    }

    /**
     * Returns a valid task title
     *
     * @return a non-empty string
     */
    public String determineTitle() {
        printer.printPromptForTitle();
        return getValidTitleFromUser();
    }

    /**
     * Returns a valid due date
     *
     * @return a LocalDate
     */
    public LocalDate determineDueDate() {
        printer.printPromptForDueDate();
        return getValidLocalDateFromUser();
    }

    /**
     * Returns a valid project name from the user, which may be empty.
     *
     * @return a string, which may be empty
     */
    public String determineProject() {
        printer.printPromptForProject();
        return Parser.getNextLine();
    }

    /**
     * Returns the task list.
     */
    public TaskList getTaskList() {
        return taskList;
    }

    /**
     * Saves the current task list to file or prints an error message if an exception was caught.
     */
    private void save() {
        try {
            fileHandler.saveTaskListToFile(taskList);
        }
        catch (IOException ioException) {
            printer.printLine("Sorry, a problem occurred when saving to file.");
        }
    }

}
