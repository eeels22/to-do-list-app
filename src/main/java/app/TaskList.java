package app;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Models a collection of tasks that can be sorted by date and project.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class TaskList implements Serializable {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Creates a new task with title, due date and associated project and adds it to to the task list.
     */
    public void addTask() {
        System.out.println("\nADDING A NEW TASK");
        System.out.println("=================");
        Task task1 = new Task();
        task1.editTitle();
        task1.editDueDate();
        task1.editProject();
        System.out.println("\nNEW TASK ADDED");
        System.out.println("==============");
        System.out.println(task1.toString());
        tasks.add(task1);
    }

    /**
     * Get the task to be edited by finding its title.
     * @param title the title of the task to be edited
     * @return the task to be edited
     */
    public Task getTask(String title){
        // Given the task title, retrieve the task from the task list
        // Loop through the list until a match is found
        // If no match, print error message

        return new Task(); // placeholder

    }

    /**
     * Remove a given task from the task list
     * @param taskToRemove the task to be removed
     * @return true if removal was successul or false if unsuccessful
     */
    public boolean removeTask(Task taskToRemove){
        // Remove the given task frm the ArrayList of tasks
        // retu

        return false; // placeholder

    }

    /**
     *
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Creates a new task with title, due date and associated project and adds it to to the task list.
     * @param taskToEdit the existing task to be edited
     */
    public void editTask(Task taskToEdit) {
        System.out.println("\nEDITING AN EXISTING TASK");
        System.out.println("========================");
        taskToEdit.editTitle();
        taskToEdit.editDueDate();
        taskToEdit.editProject();
        System.out.println("\nTASK EDITS SAVED");
        System.out.println("================");
        System.out.println(taskToEdit.toString());
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder taskListStringBuilder = new StringBuilder();

        for (Task task : tasks) {
            String taskString = task.toString();
            taskListStringBuilder.append(taskString);
        }

        return taskListStringBuilder.toString();
    }


}
