package app;

import java.time.LocalDate;

/**
 * This class implements a to do list application.
 * It is the top level class in this project.
 * The app communicates via text input and output in the terminal.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class ToDoListApp {
    public static Parser parser;
    private Responder responder;
    private TaskList taskList;

    /**
     * Creates a to do list app
     */
    public ToDoListApp() {
        responder = new Responder();
        parser = new Parser();
        taskList = new TaskList();
    }

    public static void main(String[] args) {
        ToDoListApp toToListApp = new ToDoListApp();
        toToListApp.start();

//        TaskList taskList = new TaskList();
//        taskList.addTaskAndInitializeField("Eat good", LocalDate.of(2021, 04, 12), "Stay alive");
//        taskList.addTaskAndInitializeField("Make tea", LocalDate.of(2021, 04, 15), "Be zen");
//        System.out.println(taskList);

    }

    /**
     * Starts the to do list app by printing a welcome message and the main options.
     * Enters a loop of dialogue with the user until they quit.
     */
    public void start() {
        boolean usingApp = true;
        responder.printWelcome();

        displayMainMenuAndRespond();
        // while (usingApp) {
        // if they choose to quit, set usingApp to false
        // else
        // break;
        // }

        // responder.printGoodbye();

    }
    /**
     * Prints the main menu options and responds according to the user's choice
     */
    public void displayMainMenuAndRespond() {
        responder.printMainMenu();
        generateMainMenuResponse(parser.getNextInt());
    }

    /**
     * Prints the main menu options and responds according to the user's choice
     */
    public void displayViewTaskListMenuAndRespond() {
        responder.printViewTaskListMenu();
        generateShowTaskListMenuResponse(parser.getNextInt());
    }


    /**
     * Load taskList from file
     *
     * UPDATE THIS
     */
    public TaskList loadFromFile() {
        // placeholder
        return new TaskList();
    }

    /**
     * Returns the task list
     */
    public TaskList getTaskList() {
        return taskList;
    }

    /**
     * Generates the app's response to the main menu selection
     *
     * @param mainOptionChosen the user's chosen menu option
     */
    public void generateMainMenuResponse(int mainOptionChosen) {
        // shift the cursor to the next line so it reads the next input correctly
        parser.getNextLine();
        switch (mainOptionChosen) {
            case 1: // view task list
                displayViewTaskListMenuAndRespond();
                break;
            case 2: // add a new task
                taskList.addTask();
                break;
            case 3: // edit an existing task
                // determine which task they want to edit
                System.out.println(taskList.getAllTitles());
                int taskToEdit = parser.getNextInt();
                // determine which operation they want to do (edit details, mark as done, remove)
                responder.printEditOptions();
                generateEditOptionsResponse(parser.getNextInt(), taskList.getTask(taskToEdit));
                break;
            case 4: // save and quit
                FileHandler fileHandler = new FileHandler(taskList);
                fileHandler.saveTaskListToFile();
                System.out.println("Should save and quit");
                break;
            default:
                responder.printInvalidInputMessage();
                break;
        }
    }

    private void generateEditOptionsResponse(int editOptionChosen, Task taskToEdit) {
        // shift the cursor
        parser.getNextLine();
        switch (editOptionChosen) {
            case 1: // Edit task details
                // 1. check if there is an existing task to edit - check size of ArrayList tasks
                // 2. if a task exists, prompt for the title of task to be edited. - getTask
                // 3. Edit the fields

                break;
            case 2: // Mark a task as done

                break;
            case 3: // Remove a task

                break;
            default:
                responder.printInvalidInputMessage();
                break;
        }
    }

    public void generateShowTaskListMenuResponse(int viewOptionChosen) {
            // shift the cursor
            parser.getNextLine();
            switch (viewOptionChosen) {
                case 1:
                    // todo skip default order
                    System.out.println("\n" + taskList.toString());
                    break;
                case 2:
                    // by due date ascending
                    // sort list
                    taskList.sortList(1, false);
                    System.out.println("\n" + taskList.toString());
                    break;
                case 3:
                    // by due date descending
                    System.out.println("\n" + taskList.sortList(1, true));
                   break;
                case 4:
                    // by project ascending
                    System.out.println("\n" + taskList.sortList(2, false));
                    break;
                case 5:
                    // by project descending
                    System.out.println("\n" + taskList.sortList(2, true));
                    break;
                default:
                    responder.printInvalidInputMessage();
                    break;
        }
    }

}
