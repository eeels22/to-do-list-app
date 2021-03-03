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
    private List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

//    public void createTask() {
//        Task task = new Task();
//    }

    public void addTaskToTaskList(Task task) {
        taskList.add(task);
    }

    @Override
    public String toString() {
        StringBuilder taskListStringBuilder = new StringBuilder();

        for (Task task : taskList) {
            String taskString = task.toString();
            taskListStringBuilder.append(taskString);
        }

        return taskListStringBuilder.toString();

    }



}
