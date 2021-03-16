package app.controller;

import app.model.Task;
import app.model.TaskList;
import app.view.Printer;

import java.io.EOFException;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class implements a to do list application. // todo break down into more classes?
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
        printer.printTaskListOverview(taskList.getNumberOfTasks(), taskList.getNumberOfDoneTasks());
        while (usingApp) {
            runMainMenu();
        }
        printer.printGoodbye();
    }

    /**
     * Prints the main menu options and performs the user's choice
     */
    public void runMainMenu() {
        printer.printMainMenu();
        int menuChoice = getValidatedMenuChoice(4);
        performMainMenuChoice(menuChoice);
    }

    /**
     * Prints the view task menu options and responds to the user's choice
     */
    public void runViewTaskListMenu() {
        printer.printViewTaskListMenu();
        int menuChoice = getValidatedMenuChoice(4);
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
                runViewTaskListMenu();
                break;
            case 2:
                addNewTaskAndConfirm();
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
    public void performEditChoice(int operationChosen, int indexTaskToEdit) {
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
     * Depending on th which task the user wants to edit, or advises there are no existing tasks.
     *
     * @return index of the task to be edited
     */
    public int determineTaskToEdit() throws NullPointerException {  //todo could be named "runTaskToEditMenu    also refactor out methods eg     getUserChoiceOfTaskToEdit
        int sizeOfTaskList = taskList.getTasks().size();
        int indexTaskToEdit;
        if (sizeOfTaskList == 1) { // only one task, index must be 0
            indexTaskToEdit = 0;
        } else if (sizeOfTaskList > 1) { // user picks task to edit from numbered list of task titles
            printer.printPromptForTaskToEdit(taskList.getNumberedTaskTitles());
            indexTaskToEdit = getValidatedMenuChoice(sizeOfTaskList);
        } else { // no tasks available to edit
            throw new NullPointerException();
        }
        return indexTaskToEdit;
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
        } catch (EOFException eofException) { // todo move to file handler
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
        } catch (IOException exception) { // todo move to file handler
            printer.printLine("Sorry, there was a problem with saving the file: " + exception);
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
            validateMenuChoice(menuSize, menuChoice);
            return menuChoice;
        } catch (IllegalArgumentException illegalArgumentException) {
            printer.printInvalidInputMessage();
            return getValidatedMenuChoice(menuSize);
        }
    }

    /**
     * Checks if the menu choice is valid and throws an exception if it is invalid.
     *
     * @param menuSize   number of menu options
     * @param menuChoice user's chosen menu option
     * @throws IllegalArgumentException if the menu choice is not valid
     */
    public void validateMenuChoice(int menuSize, int menuChoice) throws IllegalArgumentException {
        if (menuChoice < 1 || menuChoice > menuSize) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Prompts the user to enter a new title and returns a valid title.
     *
     * @return a nn-empty title String.
     */
    public String getValidatedTitle() {
        try {
            String title = Parser.getNextLine();
            validateTitle(title);
            return title;
        } catch (IllegalArgumentException illegalArgumentException) {
            printer.printPromptForTitle();
            return getValidatedTitle();
        }
    }

    /**
     * Checks if the title is empty and throws an exception if true.
     * @throws IllegalArgumentException if the title is empty.
     */
    public void validateTitle(String title) throws IllegalArgumentException {
        if (title.isEmpty()) {
            throw new IllegalArgumentException();
        }
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
    public void editTaskDetailsAndConfirm(int indexTaskToEdit) {
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
            printer.printLine("There are no existing tasks to edit");
        }
    }

    /**
     * Adds a new task based on user inputs.
     */
    public void addNewTaskAndConfirm() {
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
     * Marks a task as done.
     *
     * @param indexDoneTask the index of the task that is done
     */
    public void markTaskAsDoneAndConfirm(int indexDoneTask) { // todo bespoke message
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

}
