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
    private String project = "";


    public Task() {
    }

    public Task(String title, LocalDate dueDate, String project) {
        this.title = title;
        this.dueDate = dueDate;
        this.project = project;
    }

    public Task(String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public boolean getStatus() {
        return this.isDone;
    }

    public String getProject() {
        return this.project;
    }

    @Override
    public String toString() {
        return "\nTask: " + title + "\nDue: " + dueDate + "\nStatus: " + statusToString() + "\nProject: " + projectToString();
    }

    private String statusToString() {
        return isDone ? "done" : "to do";
    }

    private String projectToString() {
        return (project.isEmpty()) ? "not assigned" : project;
    }

}