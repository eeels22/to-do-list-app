package app;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Task class that models a task with a task title, due date, status and project.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
public class TaskTest {

    @Test
    @DisplayName("Create a new task with a title, due due and project")
    void createNewTaskWithTitleDueDueAndProject() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");

        assertAll(() -> assertEquals("Eat lunch", task1.getTitle()),
                () -> assertEquals(LocalDate.of(2021, 11, 20), task1.getDueDate()),
                () -> assertEquals("Stay alive", task1.getProject()),
                () -> assertEquals(false, task1.getStatus()));
    }


    @Test
    @DisplayName("Get title successfully")
    void getTitleSuccessfully() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        assertEquals("Eat lunch", task1.getTitle());
    }

    @Test
    @DisplayName("Set title successfully")
    void setTitleSuccessfully() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setTitle("Eat dinner");
        assertEquals("Eat dinner", task1.getTitle());
    }

    // how to check method that requires user input?  --> set the input yourself. Goal is not to get that Scanner works.
    @Test
    @Disabled
    void editTitle() {
        Task task1 = new Task();
        task1.setTitle("Learn JUnit5");
        assertEquals("Learn JUnit5", task1.getTitle());
    }

    @Test
    @DisplayName("Get due date successfully")
    void getDueDateSuccessfully() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        LocalDate expectedLocalDate = LocalDate.of(2021, 11, 20);
        assertEquals(expectedLocalDate, task1.getDueDate());
    }

    @Test
    @DisplayName("Set due date successfully")
    void setDueDateSuccessfully() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setDueDate(LocalDate.of(2021, 11, 15));
        assertEquals(LocalDate.of(2021, 11, 15), task1.getDueDate());
    }

    // how to check method that requires user input?
    @Test
    void editDueDate() {

    }

    @Test
    @DisplayName("Get status should return false (to do)")
    void getStatusShouldReturnFalse() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        assertEquals(false, task1.getStatus());
    }

    @Test
    @DisplayName("Get status should return true (done)")
    void getStatusShouldReturnTrue() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setStatus(true);
        assertEquals(true, task1.getStatus());
    }

    @Test
    @DisplayName("Set status to true (done)")
    void setStatusToTrue() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setStatus(true);
        assertEquals(true, task1.getStatus());
    }

    @Test
    @DisplayName("Set status to false (done)")
    void setStatusToFalse() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setStatus(false);
        assertEquals(false, task1.getStatus());
    }

    @Test
    @DisplayName("Get project successfully")
    void getProjectSuccessfully() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        assertEquals("Stay alive", task1.getProject());
    }

    @Test
    @DisplayName("Set project successfully")
    void setProjectSuccessfully() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setProject("Healthy eating habits");
        assertEquals("Healthy eating habits", task1.getProject());
    }

    // how to check method that requires user input?
    @Test
    void editProject() {
    }

    @Test
    @DisplayName("Test toString method")
    void testToString() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        assertEquals("Task: Eat lunch\nDue: 2021-11-20\nStatus: to do\nProject: Stay alive\n", task1.toString());
    }
}
