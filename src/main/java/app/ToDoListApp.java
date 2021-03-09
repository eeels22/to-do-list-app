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


//        System.out.println(toToListApp.taskList.toString());
//        toToListApp.taskList.addTask();
//        System.out.println(toToListApp.taskList.toString());


//        String command = toToListApp.parser.getNextLine();
//        toToListApp.parser.generateMainResponse(command);
//        Task t1 = new Task("Eat chocolate", LocalDate.of(2021, 05, 12), "Stay alive");

//        System.out.println("Title is: " + t1.getTitle());
//        t1.editTitle();
//        System.out.println("New title is: " + t1.getTitle());

//        System.out.println("Due date is: " + t1.getDueDate());
//        t1.editDueDate();
//        System.out.println("New due date is: " + t1.getDueDate());

//        System.out.println("Project is: " + t1.getProject());
//        t1.editProject();
//        System.out.println("New project is: " + t1.getProject());

//        Task t2 = new Task("Eat soup", LocalDate.of(2021, 12, 12), "Stay alive");
//        TaskList taskList1 = new TaskList();
//        taskList1.addTask();
//        toToListApp.responder.printTaskList(taskList1);


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
        responder.printMainOptions();
        generateMainMenuResponse(parser.getNextInt());
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
            case 1: // show task list
                // ask user order to view tasks
                // options: in order of creation, by title, by project
                    // a) in order of creation
                    System.out.println("\nYOUR TASK LIST");
                    System.out.println("==============");
                    System.out.println("\n" + taskList.toString());
                    displayMainMenuAndRespond();
                    // b) by title
                    // c) by project

                break;
            case 2: // add a new task
                taskList.addTask();
                displayMainMenuAndRespond();
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
                displayMainMenuAndRespond();
                break;
            case 4: // save and quit
                System.out.println("Should save and quit");
                break;
            default:
                // error message and prompt reprint again?
                break;
        }
    }

}
