package app;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    void addTask() {
    }

    @Test
    void getTasks() {
    }

    @Test
    void testToString() {
        TaskList taskList1 = new TaskList();
        taskList1.getTasks().add(new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive"));
        taskList1.getTasks().add(new Task("Read about Streams", LocalDate.of(2021, 05, 12), "Learn Java"));
        taskList1.toString();
        assertEquals("Task: Eat lunch\nDue: 2021-11-20\nStatus: to do\nProject: Stay alive\nTask: Read about Streams\nDue: 2021-05-12\nStatus: to do\nProject: Learn Java\n", taskList1.toString());
    }

    @Test
    void sortByTitleAscending() {
        TaskList tasksToSort = new TaskList();
        tasksToSort.getTasks().add(new Task("Read about Streams", LocalDate.of(2021, 05, 12), "Learn Java"));
        tasksToSort.getTasks().add(new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive"));
        tasksToSort.getTasks().add(new Task("Call parents", LocalDate.of(2021, 04, 19), "Family"));
        ArrayList<Task> sortedTasks = tasksToSort.sortByTitleAscending();
        String actualTitle = sortedTasks.get(0).getTitle();
        String expectedTitle = "Call parents";
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void sortByTitleDescending() {
        TaskList tasksToSort = new TaskList();
        tasksToSort.getTasks().add(new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive"));
        tasksToSort.getTasks().add(new Task("Read about Streams", LocalDate.of(2021, 05, 12), "Learn Java"));
        tasksToSort.getTasks().add(new Task("Call parents", LocalDate.of(2021, 04, 19), "Family"));
        ArrayList<Task> sortedTasks = tasksToSort.sortByTitleDescending();
        String actualTitle = sortedTasks.get(0).getTitle();
        String expectedTitle = "Read about Streams";
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void sortByProjectAscending() {
        TaskList tasksToSort = new TaskList();
        tasksToSort.getTasks().add(new Task("Read about Streams", LocalDate.of(2021, 05, 12), "Learn Java"));
        tasksToSort.getTasks().add(new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive"));
        tasksToSort.getTasks().add(new Task("Call parents", LocalDate.of(2021, 04, 19), "Family"));
        ArrayList<Task> sortedTasks = tasksToSort.sortByProjectAscending();
        String actualProject = sortedTasks.get(0).getProject();
        String expectedProject = "Family";
        assertEquals(expectedProject, actualProject);
    }

    @Test
    void sortByProjectDescending() {
        TaskList tasksToSort = new TaskList();
        tasksToSort.getTasks().add(new Task("Read about Streams", LocalDate.of(2021, 05, 12), "Learn Java"));
        tasksToSort.getTasks().add(new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive"));
        tasksToSort.getTasks().add(new Task("Call parents", LocalDate.of(2021, 04, 19), "Family"));
        ArrayList<Task> sortedTasks = tasksToSort.sortByProjectDescending();
        String actualProject = sortedTasks.get(0).getProject();
        String expectedProject = "Stay alive";
        assertEquals(expectedProject, actualProject);
    }

    @Test
    @Disabled
    void removeTask() {

    }
}