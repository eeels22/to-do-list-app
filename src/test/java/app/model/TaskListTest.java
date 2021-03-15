package app.model;
import app.model.Task;
import app.model.TaskList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TaskList.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
class TaskListTest {
    private TaskList taskList = new TaskList();

    /**
     * Set up TaskList and create three tasks.
     * This method is executed once before every test case in this class.
     */
    @BeforeEach
    public void setUp() {
        taskList.getTasks().add(new Task("Read about Streams", LocalDate.of(2021, 05, 12), "Learn Java"));
        taskList.getTasks().add(new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive"));
        taskList.getTasks().add(new Task("Call parents", LocalDate.of(2021, 04, 19), "Family"));
    }

    @Test
    void sortListByDueDateAscending() {
        ArrayList<Task> sortedTasks = taskList.sortList(1, false);
        String actualProject = sortedTasks.get(0).getTitle();
        String expectedProject = "Call parents";
        assertEquals(expectedProject, actualProject);
    }

    @Test
    void sortListByDueDateDescending() {
        ArrayList<Task> sortedTasks = (ArrayList<Task>) taskList.sortList(1, true);
        String actualProject = sortedTasks.get(0).getTitle();
        String expectedProject = "Eat lunch";
        assertEquals(expectedProject, actualProject);
    }

    @Test
    void sortListByProjectAscending() {
        ArrayList<Task> sortedTasks = (ArrayList<Task>) taskList.sortList(2, false);
        String actualProject = sortedTasks.get(0).getProject();
        String expectedProject = "Family";
        assertEquals(expectedProject, actualProject);
    }

    @Test
    void sortListByProjectDescending() {
        ArrayList<Task> sortedTasks = (ArrayList<Task>) taskList.sortList(2, true);
        String actualProject = sortedTasks.get(0).getProject();
        String expectedProject = "Stay alive";
        assertEquals(expectedProject, actualProject);
    }

    @Test
    void getNumberOfDoneTasksShouldReturn1WhenOneTaskIsDone() {
        Task doneTask = new Task("Test app", LocalDate.of(2021, 05, 12), "Programming");
        doneTask.setDoneStatus(true);
        taskList.getTasks().add(doneTask);
        int actualNumberOfDoneTask = taskList.getNumberOfDoneTasks();
        int expectedNumberOfDoneTasks = 1;
        assertEquals(expectedNumberOfDoneTasks, actualNumberOfDoneTask);
    }
}