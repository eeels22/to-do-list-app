package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListAppTest {
    private ToDoListApp toDoListApp = new ToDoListApp();


    @Test
    void checkMenuChoiceIsInRangeShouldReturnTrue() {
         assertTrue(toDoListApp.checkMenuChoiceIsInRange(5, 1));
    }

    @Test
    void checkPositiveMenuChoiceIsInRangeShouldReturnFalse() {
        assertFalse(toDoListApp.checkMenuChoiceIsInRange(5, 10));
    }

    @Test
    void checkNegativeMenuChoiceIsInRangeShouldReturnFalse() {
        assertFalse(toDoListApp.checkMenuChoiceIsInRange(5, -1));
    }


}