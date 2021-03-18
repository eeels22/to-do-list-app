package app.model;

import app.model.Task;

import java.util.Comparator;

/**
 * Defines comparators for the Task class by due date or project.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class TaskComparator implements Comparator<Task>
{
    private int type; // the task field that we want to compare

    /**
     * Constructor for the TaskComparator.
     */
    public TaskComparator(int type)
    {
        this.type = type;
    }

    /**
     * Compares two task arguments for order.
     *
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Task task1, Task task2)
    {
        switch (type) {
            case 1: // compare due date
                return task1.getDueDate().compareTo(task2.getDueDate());
            case 2: // compare project
                return task1.getProject().toLowerCase().compareTo(task2.getProject().toLowerCase());
            default:
                return 0; // todo throw exception instead? (what type of exception) and try catch in method calling this
        }
    }
}

