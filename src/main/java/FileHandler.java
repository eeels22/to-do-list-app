import java.io.*;

/**
 * The FileHandler is responsible for saving and loading task lists to and from file.
 * @author En-Chi Liu
 * @version 1.0
 */

public class FileHandler {

    private TaskList taskList;
    private String path = "src/";


    public void saveTaskListToFile(TaskList taskList) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "taskList.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException exception) {
            System.out.println("Oops, there's a problem with saving the file: " + exception);
        }
    }

    public TaskList loadTaskListFromFile() {

        try {
            FileInputStream fileInputStream = new FileInputStream(path + "taskList.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            taskList = (TaskList) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Oops, there's a problem with loading the file: " + exception);
        }
        return taskList;
    }
}
