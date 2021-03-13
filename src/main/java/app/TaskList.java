package app;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Models a collection of tasks that can be sorted by date and project.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class TaskList implements Serializable { //todo refactor out printing
    private ArrayList<Task> tasks;

    /**
     * Construct a task list and initialises an empty task ArrayList
     */
    public TaskList() { //todo load from file
        tasks = new ArrayList<>();
    }

    /**
     * Creates a new default task, prompts user for the title, due date and associated project and adds it to to the task list.
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

//    /**
//     * Creates a new task with title, due date and associated project and adds it to to the task list.
//     */
//    public void addTaskAndInitializeField(String title, LocalDate dueDate, String project) {
//        Task task1 = new Task(title, dueDate, project);
//        tasks.add(task1);
//    }

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
        return tasks.get(index); // placeholder
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
     * Edits an existing task's title, due date and project fields.
     *
     * @param index the index of the task to be edited
     */
    public void editTask(int index) {
        System.out.println("\nEDITING AN EXISTING TASK");
        System.out.println("========================");
        tasks.get(index).editTitle();
        tasks.get(index).editDueDate();
        tasks.get(index).editProject();
        System.out.println("\nTASK EDITS SAVED");
        System.out.println("================");
        System.out.println(tasks.get(index).toString());
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
        } else {
            for (Task task : tasks) {
                taskListStringBuilder.append(task.toString() + "\n");
            }
            return taskListStringBuilder.toString();
        }
    }

    /**
     * Returns all titles of tasks in the list.
     *
     * @return all task titles as a String
     */
    public String getNumberedTaskTitles() {
        StringBuilder taskTitles = new StringBuilder();
        if (tasks.size() == 0) {
            return "Your task list is empty.";
        } else {
            for (int index = 0; index < tasks.size(); index++) {
                int menuNumber = index + 1;
                taskTitles.append("\n(" + menuNumber + ") " + tasks.get(index).getTitle());
            }
            return taskTitles.toString();
        }
    }

    /**
     * Sort the task list in the the desired order
     *
     * @param type       what field to sort on
     * @param descending whether or not to use descending order
     * @return the task list in the desired order
     */
    public ArrayList<Task> sortList(int type, boolean descending) {
        TaskComparator comparator = new TaskComparator(type);

        Collections.sort(tasks, comparator);

        if (descending)
            Collections.reverse(tasks);

        return tasks;
    }

    public int getNumberOfTasks() {
        return tasks.size();
    }

    public int getNumberOfDoneTasks() {
        int numDoneTasks = 0;
        for (Task task : tasks) {
            if (task.getStatus() == true) {
                numDoneTasks++;
            }
        }
        return numDoneTasks;
    }


}
