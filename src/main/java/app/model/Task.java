package app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


/**
 * Models a task with a task title, due date, done status and project.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class Task implements Serializable {
    private String title; // title of the task
    private LocalDate dueDate; // task deadline
    private boolean isDone; // whether the task has been done
    private String project; // a project that the task belongs to (may be empty)

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
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns task´s due date.
     */
    public LocalDate getDueDate() {
        return this.dueDate;
    }

    /**
     * Updates the task´s due date.
     *
     * @param dueDate a date when the task is due by
     */
    public void setDueDate(LocalDate dueDate) {
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
     * @param isDone true if done and false if not
     */
    public void setDoneStatus(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Returns the project this task belongs to if it is not empty, otherwise return "not assigned".
     *
     * @return the project name or "not assigned"
     */
    public String getProject() {
        return (project.isEmpty()) ? "not assigned" : project;
    }

    /**
     * Assigns the task to a project
     *
     * @param project name of a project, which may be empty
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * Produces a String representation of the task details
     *
     * @return a String with details of the task on new lines
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
    public String statusToString() {
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
     * Generates a hash code for the task
     *
     * @return hashcode for the task
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, dueDate, isDone, project);
    }

}