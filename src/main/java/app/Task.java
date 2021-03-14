package app;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


/**
 * Models a task with a task title, due date, status and project.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Task implements Serializable {
    private String title;
    private LocalDate dueDate;
    private boolean isDone;
    private String project;

    /**
     * Default task constructor.
     */
    public Task() {
        title = "";
        isDone = false;
        project = "";
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
     * Return the task title if it is not empty, otherwise return "not assigned".
     *
     * @return the title of the task or "not assigned"
     */
    public String getTitle() {

        return (title.isEmpty()) ? "not assigned" : title;
    }

    /**
     * Assigns the task title if it is valid.
     */
    public void setTitle(String title) { //todo validity checking should occur in App class where parser is available
//        if (isStringValid(title)) {
            this.title = title;
//        } else {
//            System.out.println("Please enter a valid title.");
//        }
    }

    /**
     * Returns task´s due date.
     */
    public LocalDate getDueDate() {
        return this.dueDate;
    }

    /**
     * Updates the task´s due date.
     */
    public void setDueDate(LocalDate dueDate) { // todo catch invalid inputs in App class
        this.dueDate = dueDate;
    }

    /**
     * Returns the task status.
     */
    public boolean getDoneStatus() {
        return this.isDone;
    }

    /**
     * Sets the task status to the given boolean.
     *
     * @param isDone true if done and false if to do
     */
    public void setDoneStatus(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Returns the project this task belongs to if it is not empty, otherwise return "not assigned".
     * @return the project name or "not assigned"
     */
    public String getProject() {

        return (project.isEmpty()) ? "not assigned" : project;
    }

    /**
     * Assigns the task to a project if it is valid.
     */
    public void setProject(String project) {
//        if (isStringValid(project)) { todo validity checking should happen in App class
            this.project = project;
//        } else {
//            System.out.println("Please enter a valid project name or \"none\"");
//        }
    }

    /**
     * Produces a String representation of the task details
     *
     * @return a String with details of the task on separate lines
     */
    @Override
    public String toString() {
        return "\nTask: " + getTitle() + "\nDue: " + dueDate + "\nStatus: " + statusToString() + "\nProject: " + getProject();
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
     * Checks if a given task's fields matches those of this task.
     *
     * @param taskObject the task to compare to the current task
     * @return true if all fields are the same, false if not.
     */
    @Override
    public boolean equals(Object taskObject) {
        if (this == taskObject) return true;
        if (taskObject == null || getClass() != taskObject.getClass()) return false;
        Task task = (Task) taskObject;
        boolean sameTitle = title.equals(task.title);
        boolean sameDueDate = dueDate.equals(task.dueDate);
        boolean sameStatus = isDone == task.isDone;
        boolean sameProject = project.equals(task.project);
        return sameTitle && sameDueDate && sameStatus && sameProject;
    }

    /**
     * Produces a String representation of the task status
     *
     * @return task status String as "done" or "to do"
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, dueDate, isDone, project);
    }

//    /**
//     * Produces a String representation of the task project
//     *
//     * @return the name of the project associated with the task or "not assigned"
//     */
//    private String projectToString() {
//        return (project.isEmpty()) ? "not assigned" : project;
//    }
//
//    /**
//     * Produces a String representation of the task title
//     *
//     * @return the name of the project associated with the task or "not assigned"
//     */
//    private String titleToString() {
//        return (title.isEmpty()) ? "not assigned" : title;
//    }


    //    /**
//     * Checks for a valid String input.
//     *
//     * @return true if String is valid.
//     */
//    private boolean isStringValid(String string) {
//        return title != null && !title.isEmpty();
//    }

//    /**
//     * Prompts user for the task´s due date and set's it.
//     */
//    public void editDueDate() {
//        String dateString = ToDoListApp.parser.getNextLine();
//        LocalDate dueDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
//        setDueDate(dueDate);
//    }

    //    /**
//     * Update the project that the task belongs to.
//     */
//    public void editProject() {
//        String project = ToDoListApp.parser.getNextLine();
//        setProject(project);
//    }

}