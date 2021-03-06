import java.time.LocalDate;

/**
 * Models a task with a task title, due date, status and project.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Task {
    private String title;
    private LocalDate dueDate;
    private boolean isDone = false;
    private String project;

    /**
     * Default task constructor.
     */
    public Task() {
    }

    /**
     * Constructs a task with a title, due date and associated project.
     */
    public Task(String title, LocalDate dueDate, String project) {
        this.title = title;
        this.dueDate = dueDate;
        this.project = project;
    }

    /**
     * Checks for a valid String input.
     *
     * @return true if String is valid.
     */
    private boolean isStringValid(String string) {
        return title != null && !title.isEmpty();
    }

    public String getTitle() {
        return this.title;
    }

    /**
     * Assigns the task title if it is valid.
     */
    public void setTitle(String title) {
        if (isStringValid(title)) {
            this.title = title;
        }
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getStatus() {
        return this.isDone;
    }

    public void setStatus(boolean doneOrNot) {
        isDone = doneOrNot;
    }

    public String getProject() {
        return this.project;
    }

    /**
     * Assigns the task to a project if it is valid.
     */
    public void setProject(String project) {
        if (isStringValid(project)) {
            this.project = project;
        }
    }

    /**
     * Produces a String representation of the task details
     *
     * @return a String with details of the task on separate lines
     */
    @Override
    public String toString() {
        return "\nTask: " + title + "\nDue: " + dueDate + "\nStatus: " + statusToString() + "\nProject: " + projectToString() + "\n";
    }

    /**
     * Produces a String representation of the task status
     *
     * @return task status String as "done" or "to do"
     */
    private String statusToString() {
        return isDone ? "done" : "to do";
    }

    /**
     * Produces a String representation of the task project
     *
     * @return the name of the project associated with the task or "not assigned"
     */
    private String projectToString() {
        return (project.isEmpty()) ? "not assigned" : project;
    }

}