package app.controller;

import app.controller.ToDoListApp;
import app.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDoListAppTest {
    private ToDoListApp toDoListApp = new ToDoListApp();

    /**
     * Set up TaskList and create three tasks.
     * This method is executed once before every test case in this class.
     */
    @BeforeEach
    @DisplayName("Set up to execute before each test")
    public void setUp() {
        toDoListApp.getTaskList().getTasks().add(new Task("Read about Streams", LocalDate.of(2021, 05, 12), "Learn Java"));
    }
    @Test
    @DisplayName("determineTaskToEdit returns 1 when there is one task in the list")
    void determineTaskToEditReturns1WhenThereIsOneTaskInTheList() {
        int actualIndex = toDoListApp.determineTaskToEdit();
        assertEquals(1, actualIndex);
    }

    @Test
    void getUserChoiceOfTaskToEdit() {
    }

    @Test
    void determineEditChoice() {
    }

    @Test
    void loadTaskList() {
    }

    @Test
    void saveTaskList() {
    }

    @Test
    void getValidMenuChoiceFromUser() {
    }

    @Test
    void getValidTitleFromUser() {
    }

    @Test
    void getValidLocalDateFromUser() {
    }

    @Test
    void editAnExistingTask() {
    }

    @Test
    void addNewTaskAndConfirm() {
    }

    @Test
    void determineTitle() {
    }

    @Test
    void determineDueDate() {
    }

    @Test
    void determineProject() {
    }
}