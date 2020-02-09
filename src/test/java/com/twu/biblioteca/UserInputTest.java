package com.twu.biblioteca;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    @Test
    void testShouldTakeUserInput() {
        UserInput userInput = new UserInput();
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String expected = "1";
        assertEquals(expected, userInput.getUserInput());
    }
}