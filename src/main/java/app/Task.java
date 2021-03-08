package app;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Models a task with a task title, due date, status and project.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Task {
    private String title;
    private LocalDate dueDate;
    private boolean isDone;
    private String project;

    /**
     * Default task constructor.
     */
    public Task() {
        title = "Not specified";
        isDone = false;
        project = "Not assigned";
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


    /**
     *
     * @return the title field of this Task
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Assigns the task title if it is valid.
     */
    public void setTitle(String title) {
        if (isStringValid(title)) {
            this.title = title;
        } else {
            System.out.println("Please enter a valid title.");
        }
    }

    public void editTitle() {
        System.out.println("Enter the task title:");
        System.out.print(">  ");
        String title = ToDoListApp.parser.getNextLine();
        this.setTitle(title);
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Updates the task´s due date.
     */
    public void editDueDate() {
        System.out.println("Enter the due date in the format YYYY-MM-DD:");
        // add try - catch
        String dateString = ToDoListApp.parser.getNextLine();
        LocalDate dueDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        setDueDate(dueDate);
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
        } else{
            System.out.println("Please enter a valid project name or \"none\"");
        }
    }

    /**
     * Update the project that the task belongs to.
     */
    public void editProject() {
        System.out.println("Enter the project that this task belong to or \"none\" if not applicable:");
        String project = ToDoListApp.parser.getNextLine();
        setProject(project);
    }

    /**
     * Produces a String representation of the task details
     *
     * @return a String with details of the task on separate lines
     */
    @Override
    public String toString() {
        return "Task: " + title + "\nDue: " + dueDate + "\nStatus: " + statusToString() + "\nProject: " + project + "\n";
    }

    /**
     * Produces a String representation of the task status
     *
     * @return task status String as "done" or "to do"
     */
    private String statusToString() {
        return isDone ? "done" : "to do";
    }

//    /**
//     * Produces a String representation of the task project
//     *
//     * @return the name of the project associated with the task or "not assigned"
//     */
//    private String projectToString() {
//        return (project.isEmpty()) ? "not assigned" : project;
//    }





}