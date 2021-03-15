package app.model;
import app.model.Task;
import org.junit.jupiter.api.BeforeEach;
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

    private Task task1;

    @BeforeEach
    void setUp() {
        task1 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
    }

    @Test
    @DisplayName("Create a new task with a title, due due and project")
    void createNewTaskWithTitleDueDueAndProject() {
        assertEquals("Eat lunch", task1.getTitle());
        assertEquals(LocalDate.of(2021, 11, 20), task1.getDueDate());
        assertEquals("Stay alive", task1.getProject());
        assertFalse(task1.getDoneStatus());
    }

    @Test
    @DisplayName("Get project should return project string if not empty")
    void getProjectShouldReturnProjectStringIfNotEmpty() {
        assertEquals("Stay alive", task1.getProject());
    }

    @Test
    @DisplayName("Get project should return 'not assigned' if empty")
    void getProjectShouldReturnNotAssignedIfEmpty() {
        Task taskWithoutProject = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "");
        assertEquals("not assigned", taskWithoutProject.getProject());
    }

    @Test
    @DisplayName("Equals should return true when all fields in two Tasks are the same ")
    void equalsShouldReturnTrueWhenAllFieldsInTwoTasksAreTheSame() {
        Task task2 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        boolean isEqualShouldBeTrue = task2.equals(task1);
        assertTrue(isEqualShouldBeTrue);
    }

    @Test
    @DisplayName("Equals should return false when titles do not match")
    void equalsShouldReturnFalseTitleNotMatching() {
        Task task2 = new Task("Watch TV", LocalDate.of(2021, 11, 20), "Stay alive");
        boolean isEqualShouldBeFalse = task2.equals(task1);
        assertFalse(isEqualShouldBeFalse);
    }

    @Test
    @DisplayName("Equals should return false when due dates do not match")
    void equalsShouldReturnFalseDateNotMatching() {
        Task task2 = new Task("Eat lunch", LocalDate.of(1999, 01, 20), "Stay alive");
        boolean isEqualShouldBeFalse = task2.equals(task1);
        assertFalse(isEqualShouldBeFalse);
    }

    @Test
    @DisplayName("Equals should return false when projects do not match")
    void equalsShouldReturnFalseProjectNotMatching() {
        Task task2 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Food");
        boolean isEqualShouldBeFalse = task2.equals(task1);
        assertFalse(isEqualShouldBeFalse);
    }

    @Test
    @DisplayName("Equals should return false when done statuses do not match")
    void equalsShouldReturnFalseStatusNotMatching() {
        Task task2 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        task2.setDoneStatus(true);
        boolean isEqualShouldBeFalse = task2.equals(task1);
        assertFalse(isEqualShouldBeFalse);
    }

    @Test
    @DisplayName("Hash codes for two Tasks should match when all fields are equal")
    void hashCodesShouldMatchWhenAllFielsAreEqual() {
        Task task2 = new Task("Eat lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        boolean shouldMatch = task1.hashCode() == task2.hashCode();
        assertTrue(shouldMatch);
    }

    @Test
    @DisplayName("Hash codes should not match as not all fields are equal")
    void hashCodeShouldNotMatchWhenNotAllFieldsAreEqual() {
        Task task2 = new Task("Make lunch", LocalDate.of(2021, 11, 20), "Stay alive");
        boolean shouldNotMatch = task1.hashCode() == task2.hashCode();
        assertFalse(shouldNotMatch);
    }

    @Test
    @DisplayName("statusToString should return 'done' if isDone is true")
    void statusToStringShouldReturnDoneIfIsDoneIsTrue() {
        task1.setDoneStatus(true);
        assertEquals("done", task1.statusToString());
    }

    @Test
    @DisplayName("statusToString should return 'to do' if isDone is false")
    void statusToStringShouldReturnToDoIfIsDoneIsFalse() {
        assertEquals("to do", task1.statusToString());
    }
}
