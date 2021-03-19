package app.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Validator class responsible for getting user input.
 *
 * @author En-Chi Liu
 * @version 1.0
 */
class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    @DisplayName("validateMenuChoice should not throw exception when choice is valid")
    void validateMenuChoiceShouldNotThrowExceptionWhenChoiceIsValid() {
        assertDoesNotThrow( () -> {
            validator.validateMenuChoice(4, 4);
        });
    }

    @Test
    @DisplayName("validateMenuChoice should throw exception when choice is invalid (over upper bound)")
    void validateMenuChoiceShouldThrowExceptionWhenChoiceIsInvalidUpperBound() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateMenuChoice(4, 5);
        });
    }

    @Test
    @DisplayName("validateMenuChoice should throw exception when choice is invalid (under lower bound)")
    void validateMenuChoiceShouldThrowExceptionWhenChoiceIsInvalidLowerBound() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateMenuChoice(4, 0);
        });
    }

    @Test
    @DisplayName("validateStringIsNotEmpty should not throw exception when string is not empty")
    void validateStringIsNotEmptyShouldNotThrowExceptionWhenStringIsNotEmpty() {
        assertDoesNotThrow( () -> {
            validator.validateStringIsNotEmpty("string not empty");
        });
    }

    @Test
    @DisplayName("validateStringIsNotEmpty should throw exception when string is empty")
    void validateStringIsNotEmptyShouldThrowExceptionWhenStringIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateStringIsNotEmpty("");
        });
    }
}