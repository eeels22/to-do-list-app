import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

//    public void createTask() {
//        Task task = new Task();
//    }

    public void addTaskToTaskList(Task task) {
        tasks.add(task);
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
