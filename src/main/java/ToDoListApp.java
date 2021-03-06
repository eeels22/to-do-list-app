/**
 * This class implements a to do list application.
 * It is the top level class in this project.
 * The app communicates via text input and output in the terminal.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class ToDoListApp {
    private Responder responder;
    public static Parser parser;
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


//        String command = toToListApp.parser.getNextLine();
//        toToListApp.parser.generateMainResponse(command);
//        Task t1 = new Task("Eat chocolate", LocalDate.of(2021, 05, 12), "Stay alive");
//        Task t2 = new Task("Eat soup", LocalDate.of(2021, 12, 12), "Stay alive");
//        TaskList taskList1 = new TaskList();
//        taskList1.addTaskToTaskList(t1);
//        taskList1.addTaskToTaskList(t2);
//        toToListApp.responder.printTaskList(taskList1);


    }

    /**
     * Starts the to do list app by printing a welcome message and the main options.
     * Enters a loop of dialogue with the user until they quit.
     */
    public void start() {
        boolean usingApp = true;
        responder.printWelcome();
        responder.printMainOptions();
        // while (usingApp) {
        // if they choose to quit, set usingApp to false
        // else
        // break;
        // }

        // responder.printGoodbye();

    }

    /**
     * Load taskList from file
     */

    /**
     * Load taskList from file
     */
    public void generateMainMenuResponse(int mainOptionChosen) {
        switch (mainOptionChosen) {
            case 1:
                // show task list
                System.out.println("Should show task list");
                // print options: default order, sort by title, sort by project
                break;
            case 2:
                taskList.createTask();
                break;
            case 3:
                // edit task
                System.out.println("What would you like to edit?");
                // print options: edit title, edit due date, mark as done, remove task
                break;
            case 4:
                // save and quit
                System.out.println("Should save and quit");
                break;
            default:
                break;
        }
    }

}
