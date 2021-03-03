import java.time.LocalDate;

/**
 * ToDoListApp is the main entry for the app.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class ToDoListApp {
    private Responder responder = new Responder();
    private Parser parser = new Parser();

    public static void main(String[] args) {
        ToDoListApp toToListApp = new ToDoListApp();
        // toToListApp.startApp();
        Task t1 = new Task("Eat chocolate", LocalDate.of(2021, 05, 12), "Stay alive");
        Task t2 = new Task("Eat soup", LocalDate.of(2021, 12, 12), "Stay alive");
        TaskList taskList1 = new TaskList();
        taskList1.addTaskToTaskList(t1);
        taskList1.addTaskToTaskList(t2);
        toToListApp.responder.printTaskList(taskList1);



    }

    public void ToDoListApp() {
    }

    public void startApp() {
        responder.printWelcome();
        responder.printMainOptions();
        // while (appIsInUse) {

        // steps

        // set appIsInUse to false triggered
        // }
        //
        responder.printGoodbye();
        // Anything else required to stop program?
    }

//    public boolean processCommand(Command command) {
//        boolean quit = false;
//        // ADD processing logic here
//        return quit;
//    }
}
