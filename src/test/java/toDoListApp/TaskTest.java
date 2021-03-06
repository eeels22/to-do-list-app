package toDoListApp;
import Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    @Test
    @DisplayName("Create a new task with a title, due date and project")
    void createNewTaskWithTitleDueDueAndProject() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 03, 20), "Stay alive");

        Assertions.assertAll(() -> assertEquals("Eat lunch", task1.getTitle()),
                () -> assertEquals(LocalDate.of(2021, 03, 20), task1.getDueDate()),
                () -> assertEquals("Stay alive", task1.getProject()),
                () -> assertEquals(false, task1.getStatus()));
    }

}
