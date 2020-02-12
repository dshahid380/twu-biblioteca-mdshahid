package com.twu.biblioteca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.mockito.Mockito.*;

class UserInputTest {
    Console console;
    Library library;
    UserInput userInput;

    @BeforeEach
    public void setUp() {
        console = mock(Console.class);
        library = mock(Library.class);
        userInput = new UserInput(library, console);
    }

    @Test
    void testShouldPrintDetailsOfBooks() throws IOException {
        when(console.readInteger()).thenReturn(1);
        userInput.readInput();
        verify(library,times(1)).displayAllBooks();
    }

    @Test
    void testShouldPrintAnMessageToUserWhenEnterWrongOption() throws IOException {
        when(console.readInteger()).thenReturn(6);
        userInput.readInput();
        verify(console, times(1)).display("Please select a valid option!");
    }

    @Test
    void testShouldPrintAnMessageToUserForQuit() throws IOException {
        when(console.readInteger()).thenReturn(4);
        userInput.readInput();
        verify(console, times(1)).display("Thank you!");
    }

}