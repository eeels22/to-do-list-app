package app;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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

}