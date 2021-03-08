package app;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @Disabled
    void createTask() {
        TaskList taskList1 = new TaskList();
        //taskList1.addTask();

    }

    @Test
    void testToString() {
        TaskList taskList1 = new TaskList();
        taskList1.getTasks().add(new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive"));
        taskList1.getTasks().add(new Task("Read about Streams", LocalDate.of(2021, 5, 12), "Learn Java"));
        taskList1.toString();
    }
}