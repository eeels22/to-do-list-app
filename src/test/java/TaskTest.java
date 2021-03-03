import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TaskTest {

    @Test
    @Disabled("Just testing a test")
    void createNewTask() {
        Task task1 = new Task("Eat lunch", LocalDate.of(2021, 03, 20), "Stay alive");

        // Assertions.assertEquals(1, 1);
    }
}
