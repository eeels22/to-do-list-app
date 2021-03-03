import java.time.LocalDate;

/**
 * Main entry for the app.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class ToDoListApp {
    Responder responder = new Responder();
    Parser parser = new Parser();

    public static void main(String[] args) {
        ToDoListApp toToListApp = new ToDoListApp();
        toToListApp.startApp();
        Task t1 = new Task("Eat chocolate", LocalDate.of(2021, 05, 12));


    }

    public void ToDoListApplication() {
    }

    public void startApp() {
        responder.printWelcome();
        responder.printMainOptions();
        // while loop
        responder.printGoodbye();
    }

//    public boolean processCommand(Command command) {
//        boolean quit = false;
//        // ADD processing logic here
//        return quit;
//    }
}
