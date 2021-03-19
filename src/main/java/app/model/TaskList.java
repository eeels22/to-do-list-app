package app.model;

import app.model.Task;
import app.model.TaskComparator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Models a collection of tasks that can be sorted by date and project.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class TaskList implements Serializable {
    private ArrayList<Task> tasks;

    /**
     * Construct a task list and initialises an empty task ArrayList
     */
    public TaskList() { //todo load from file
        tasks = new ArrayList<>();
    }

    /**
     * Get the task to be edited by finding its title.
     *
     * @param index the title of the task to be edited
     * @return the task to be edited
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Remove a given task from the task list
     *
     * @param index the index of the task to remove
     */
    public void removeTask(int index) {
        tasks.remove(index);
    }

    /**
     * @return the task list
     */
    public ArrayList<Task> getTasks() {
        return tasks;
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
                taskListStringBuilder.append(task.toString()).append("\n");
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
                taskTitles.append("\n(").append(menuNumber).append(") ").append(tasks.get(index).getTitle());
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
        tasks.sort(comparator);
        if (descending) {
            Collections.reverse(tasks);
        }
        return tasks;
    }

    /**
     * Gets the number of tasks in the task list
     *
     * @return the number of tasks
     */
    public int getNumberOfTasks() {
        return tasks.size();
    }

    /**
     * Gets the number of tasks that are marked as done in the task list
     *
     * @return the number of done tasks
     */
    public int getNumberOfDoneTasks() {
        int numDoneTasks = 0;
        for (Task task : tasks) {
            if (task.getDoneStatus()) {
                numDoneTasks++;
            }
        }
        return numDoneTasks;
    }


}
