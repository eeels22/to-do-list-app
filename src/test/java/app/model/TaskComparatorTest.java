package app.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TaskComparator.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
class TaskComparatorTest {
    private TaskComparator taskComparatorDueDate = new TaskComparator(1);
    private TaskComparator taskComparatorProject = new TaskComparator(2);
    private Task task1 = new Task("Read about Streams",LocalDate.of(2021, 05, 12), "Learn Java");
    private Task task2 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
    private Task task3 = new Task("Drink water",LocalDate.of(2021, 05, 12), "Stay alive");

    @Test
    @DisplayName("compare should return a negative integer when first due date is less than the second due date")
    void compareShouldReturnNegativeIntegerWhenFirstDueDateIsLessThanSecondDueDate() {
        int actualInt = taskComparatorDueDate.compare(task1, task2);
        assert(actualInt < 0);
    }

    @Test
    @DisplayName("compare should return zero when first due date is the same as the second due date")
    void compareShouldReturnZeroWhenFirstDueDateIsSameAsSecondDueDate() {
        int actualInt = taskComparatorDueDate.compare(task1, task3);
        assert(actualInt == 0);
    }

    @Test
    @DisplayName("compare should return a positive integer when first due date is greater than the second due date")
    void compareShouldReturnPositiveIntegerWhenFirstDueDateIsGreaterThanSecondDueDate() {
        int actualInt = taskComparatorDueDate.compare(task2, task1);
        assert(actualInt > 0);
    }

    @Test
    @DisplayName("compare should return a negative integer when first project is less than the second project")
    void compareShouldReturnNegativeIntegerWhenFirstProjectIsLessThanSecondProject() {
        int actualInt = taskComparatorProject.compare(task1, task2);
        assert(actualInt < 0);
    }

    @Test
    @DisplayName("compare should return zero when first project is the same as the second project")
    void compareShouldReturnZeroWhenFirstProjectIsSameAsSecondProject() {
        int actualInt = taskComparatorProject.compare(task2, task3);
        assert(actualInt == 0);
    }

    @Test
    @DisplayName("compare should return a positive integer when first project is greater than the second project")
    void compareShouldReturnPositiveIntegerWhenFirstProjectIsGreaterThanSecondProject() {
        int actualInt = taskComparatorProject.compare(task2, task1);
        assert(actualInt > 0);
    }

}