import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    /**
     * Creates a new task with title, due date and associated project and adds it to to the task list.
     */
    public void createTask() {
        Task task = new Task();
        editTitle(task);
        editDueDate(task);
        editProject(task);
        tasks.add(task);
    }

    public void editTitle(Task task) {
        System.out.println("Enter the task title:");
        String title = ToDoListApp.parser.getNextLine();
        task.setTitle(title);
    }

    public void editDueDate(Task task) {
        System.out.println("Enter the due date in the format YYYY-MM-DD:");
        String dateString = ToDoListApp.parser.getNextLine();
        LocalDate dueDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        task.setDueDate(dueDate);
    }

    public void editProject(Task task) {
        System.out.println("Enter the project that this task belong to or \"none\" if not applicable:");
        String project = ToDoListApp.parser.getNextLine();
        task.setProject(project);
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
