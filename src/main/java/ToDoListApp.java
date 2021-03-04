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
    private Responder responder = new Responder();
    private Parser parser = new Parser();



    public void ToDoListApp() {
    }

    /**
     * Starts the to do list app by printing a welcome message and the main options.
     * Enters a loop of dialogue with the user until they quit.
     */
    public void start() {
        responder.printWelcome();
        responder.printMainOptions();
        // while (appIsInUse) {

        // steps

        // set appIsInUse to false triggered
        // }
        //
        // responder.printGoodbye();
        // Anything else required to stop program?
    }

//    public boolean processCommand(Command command) {
//        boolean quit = false;
//        // ADD processing logic here
//        return quit;
//    }

    public static void main(String[] args) {
        ToDoListApp toToListApp = new ToDoListApp();
        toToListApp.start();
//        String command = toToListApp.parser.getCommand();
//        toToListApp.parser.generateMainResponse(command);
//        Task t1 = new Task("Eat chocolate", LocalDate.of(2021, 05, 12), "Stay alive");
//        Task t2 = new Task("Eat soup", LocalDate.of(2021, 12, 12), "Stay alive");
//        TaskList taskList1 = new TaskList();
//        taskList1.addTaskToTaskList(t1);
//        taskList1.addTaskToTaskList(t2);
//        toToListApp.responder.printTaskList(taskList1);



    }
}
