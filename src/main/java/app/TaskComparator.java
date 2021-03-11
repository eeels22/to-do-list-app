package app;

import java.util.Comparator;

/**
 * Compares tasks by title or project.
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
            case 1: // compare title
                return task1.getTitle().compareTo(task2.getTitle());
            case 2: // compare project
                return task1.getProject().compareTo(task2.getProject());
            default:
                return -1; // todo check what to return as default
        }
    }
}

