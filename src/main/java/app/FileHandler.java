package app;
import java.io.*;

/**
 * The FileHandler is responsible for saving and loading task lists to and from file.
 *
 * @author En-Chi Liu
 * @version 1.0
 */

public class FileHandler {

    // The task list on which input and output operations are performed
    private TaskList taskList;
    // The path in the root directory where the file is located
    private String path = "src/main/resources/";
    // File name and extension
    private String fileName = "taskList.txt";

    /**
     * Constructor for the file handler.
     *
     * @param taskList The task list to save and load.
     */
    public FileHandler(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * Saves the task list to a file. Prints an error message if an exception is caught.
     */
    public void saveTaskListToFile(TaskList taskList) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException exception) {
            System.out.println("Oops, there's a problem with saving the file: " + exception);
        }
    }

    /**
     * Loads a task list from a file. Prints an error message if an exception is caught.
     *
     * @throws IOException
     */
    public TaskList loadTaskListFromFile() {

        try {
            FileInputStream fileInputStream = new FileInputStream(path + fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            taskList = (TaskList) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Oops, there's a problem with loading the file: " + exception);
            // Could the message here be that the task list is empty?
        }
        return taskList;
    }
}

