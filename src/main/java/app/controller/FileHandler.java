package app.controller;

import app.model.TaskList;

import java.io.*;

/**
 * The FileHandler is responsible for saving and loading task lists to and from file.
 *
 * @author En-Chi Liu
 * @version 1.0
 */

public class FileHandler {

    // The path in the root directory where the file is located
    private String path = "src/main/resources/";
    // File name and extension
    private String fileName = "taskList.txt";

    /**
     * Default constructor for the file handler.
     */
    public FileHandler() {
    }

    /**
     * Loads a task list from a file.
     */
    public TaskList loadTaskListFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(path + fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            TaskList taskList = (TaskList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return taskList;
        } catch (IOException | ClassNotFoundException exception) {
            return new TaskList();
        }
    }

    /**
     * Saves the task list to a file.
     */
    public void saveTaskListToFile(TaskList taskList) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(taskList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException exception) {
        }
    }

}

