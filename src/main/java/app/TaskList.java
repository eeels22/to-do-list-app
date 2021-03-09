package app;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
     * @return true if removal was successful or false if unsuccessful
     */
    public boolean removeTask(Task taskToRemove){
        // Remove the given task frm the ArrayList of tasks
        // retu

        return false; // placeholder

    }

    /**
     * @return the task list
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
     * Returns details of each task in the list or a message to say it is empty.
     * @return details of the task list as a String
     */
    @Override
    public String toString() {
        StringBuilder taskListStringBuilder = new StringBuilder();

        if (tasks.size() == 0) {
            return "Your task list is empty.";
        }

        for (Task task : tasks) {
            String taskString = task.toString();
            taskListStringBuilder.append(taskString);
        }

        return taskListStringBuilder.toString();
    }

    /**
     * Sort the tasks by ascending title
     * @return an ArrayList of tasks in ascending title order
     */
    public ArrayList<Task> sortByTitleAscending () {

        List<Task> sortedTasks = tasks.stream()
                .sorted(Comparator.comparing(Task::getTitle,
                        String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
        return (ArrayList<Task>) sortedTasks;
    }

    /**
     * Sort the tasks by descending title
     * @return an ArrayList of tasks in descending title order
     */
    public ArrayList<Task> sortByTitleDescending () {
        List<Task> sortedTasks = tasks.stream()
                .sorted(Comparator.comparing(Task::getTitle,
                        String.CASE_INSENSITIVE_ORDER).reversed())
                .collect(Collectors.toList());
        return (ArrayList<Task>) sortedTasks;
    }

    /**
     * Sort the tasks by ascending project
     * @return an ArrayList of tasks in ascending project order
     */
    public ArrayList<Task> sortByProjectAscending () {
        List<Task> sortedTasks = tasks.stream()
                .sorted(Comparator.comparing(Task::getProject,
                        String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
        return (ArrayList<Task>) sortedTasks;
    }

    /**
     * Sort the tasks by descending project
     * @return an ArrayList of tasks in descending project order
     */
    public ArrayList<Task> sortByProjectDescending () {
        List<Task> sortedTasks = tasks.stream()
                .sorted(Comparator.comparing(Task::getProject,
                        String.CASE_INSENSITIVE_ORDER).reversed())
                .collect(Collectors.toList());
        return (ArrayList<Task>) sortedTasks;
    }

}
