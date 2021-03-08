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
        Task task1 = new Task();
        task1.editTitle();
        task1.editDueDate();
        task1.editProject();
        System.out.println(task1.toString());
        tasks.add(task1);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }


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
