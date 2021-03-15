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
    private int type;

    public TaskComparator(int type)
    {
        this.type = type;
    }

    @Override
    public int compare(Task task1, Task task2)
    {
        switch (type) {
            case 1: // compare due date
                return task1.getDueDate().compareTo(task2.getDueDate());
            case 2: // compare project
                return task1.getProject().toLowerCase().compareTo(task2.getProject().toLowerCase());
            default:
                return -1; // todo check what to return as default
        }
    }
}

