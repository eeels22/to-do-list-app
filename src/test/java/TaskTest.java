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
    void createNewTaskWithTitleDueDueAndProject() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");

        assertAll(() -> assertEquals("Eat lunch", task1.getTitle()),
                () -> assertEquals(LocalDate.of(2021, 11, 20), task1.getDueDate()),
                () -> assertEquals("Stay alive", task1.getProject()),
                () -> assertFalse(task1.getStatus()));
    }


    @Test
    void getTitle() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        assertEquals("Eat lunch", task1.getTitle());
    }

    @Test
    void setTitle() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setTitle("Eat dinner");
        assertEquals("Eat dinner", task1.getTitle());
    }

    // how to check method that requires user input?
    @Test
    void editTitle() {
    }

    @Test
    void getDueDate() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        assertEquals(LocalDate.of(2021, 11, 20), task1.getDueDate());
    }

    @Test
    void setDueDate() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setDueDate(LocalDate.of(2021, 11, 15));
        assertEquals(LocalDate.of(2021, 11,  15), task1.getDueDate());
    }

    // how to check method that requires user input?
    @Test
    void editDueDate() {

    }

    @Test
    void getStatusShouldReturnFalse() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        assertFalse(task1.getStatus());
    }

    @Test
    void getStatusShouldReturnTrue() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setStatus(true);
        assertTrue(task1.getStatus());
    }

    @Test
    void setStatusToTrue() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setStatus(true);
        assertTrue(task1.getStatus());
    }

    @Test
    void setStatusToFalse() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setStatus(false);
        assertFalse(task1.getStatus());
    }

    @Test
    void getProject() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        assertEquals("Stay alive", task1.getProject());
    }

    @Test
    void setProject() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task1.setProject("Healthy eating habits");
        assertEquals("Healthy eating habits", task1.getProject());
    }

    // how to check method that requires user input?
    @Test
    void editProject() {
    }

    @Test
    void testToString() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        assertEquals("Task: Eat lunch\nDue: 2021-11-20\nStatus: to do\nProject: Stay alive\n", task1.toString());
    }
}
