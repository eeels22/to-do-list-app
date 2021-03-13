package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Models a collection of tasks that can be sorted by date and project.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class TaskList implements Serializable {
    private final ArrayList<Task> tasks;

    public TaskList() { //todo load from file
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
     *
     * @param index the title of the task to be edited
     * @return the task to be edited
     */
    public Task getTask(int index) {
        if (index < 0 || index > tasks.size() - 1) {
            System.out.println("Invalid selection, please try again.");
        }
        return tasks.get(1); // placeholder
    }

    /**
     * Remove a given task from the task list
     *
     * @param index the index of the task to remove
     */
    public void removeTask(int index) {
        try {
            tasks.remove(index);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Invalid selection, please try again.");
        } catch (UnsupportedOperationException unsupportedOperationException) {
            System.out.println("Something went wrong: " + unsupportedOperationException);
        }

    }

    /**
     * @return the task list
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Creates a new task with title, due date and associated project and adds it to to the task list.
     *
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
     * Returns details of each task in the list or a message to say it is empty.
     *
     * @return details of the task list as a String
     */
    @Override
    public String toString() {
        StringBuilder taskListStringBuilder = new StringBuilder();
        if (tasks.size() == 0) {
            return "Your task list is empty.";
        }
        for (Task task : tasks) {
            taskListStringBuilder.append(task.toString());
        }
        return taskListStringBuilder.toString();
    }

    /**
     * Sort the task list in the the desired order
     *
     * @param type       what field to sort on
     * @param descending whether or not to use descending order
     * @return a list of tasks in the desired order
     */
    public List<Task> sortList(int type, boolean descending) {
        TaskComparator comparator = new TaskComparator(type);

        List<Task> sortedTasks = tasks;
        Collections.sort(sortedTasks, comparator);

        if (descending)
            Collections.reverse(sortedTasks);

        return sortedTasks;
    }

}
