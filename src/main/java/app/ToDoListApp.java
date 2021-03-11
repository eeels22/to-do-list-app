package app;

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
                // ask user which edit operation to perform
                // options: edit task details, mark as done, or remove task
                responder.printEditOptions();
                //  a) edit title, dueDate or project
                // 1. check if there is an existing task to edit - check size of ArrayList tasks
                // 2. if a task exists, prompt for the title of task to be edited. - getTask
                // 3. Edit the fields
                //  b) mark as done
                //
                //  c) remove
                //
                break;
            case 4: // save and quit
                System.out.println("Should save and quit");
                break;
            default:
                // error message and prompt reprint again?
                break;
        }
    }

        public void generateShowTaskListMenuResponse(int showOptionChosen) {
            // shift the cursor to the next line so it reads the next input correctly
            parser.getNextLine();
            switch (showOptionChosen) {
                case 1:
                    // in order of creation
                    System.out.println("\n" + taskList.toString());
                    break;
                case 2:
                    // by title ascending
                    // sort list
                    System.out.println("\n" + taskList.toString());
                    break;
                case 3:
                    // by title descending
                    System.out.println("\n" + taskList.toString());
                    break;
                case 4:
                    // by project ascending
                    System.out.println("\n" + taskList.toString());
                    break;
                case 5:
                    // by project descending
                    System.out.println("\n" + taskList.toString());
                    break;
                default:
                    responder.printInvalidInputMessage();
                    break;

        }
    }

}
