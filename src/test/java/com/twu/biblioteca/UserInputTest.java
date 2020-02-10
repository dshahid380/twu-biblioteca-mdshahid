package com.twu.biblioteca;

import com.ginsberg.junit.exit.ExpectSystemExit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.List;

import static org.mockito.Mockito.*;

class UserInputTest {
    PrintStream printStream;
    UserInput userInput;

    @BeforeEach
    public void setUp() {
        List<Book> bookList = List.of(new Book("Book1", "Author1", "1997"),
                new Book("Book2", "Author2", "1998"));
        Library library = new Library(bookList);
        userInput = new UserInput(library);
        printStream = mock(PrintStream.class);
        System.setOut(printStream);
    }

    @Test
    @ExpectSystemExit
    void testShouldPrintDetailsOfBooks() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        userInput.readInput();
        verify(printStream).print("Book1");
        verify(printStream).print("Author1");
        verify(printStream).print("1997");
        verify(printStream).print("Book2");
        verify(printStream).print("Author2");
        verify(printStream).print("1998");
    }

    @Test
    @ExpectSystemExit
    void testShouldPrintAnMessageToUserWhenEnterWrongOption() {
        System.setIn(new ByteArrayInputStream("6".getBytes()));
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        userInput.readInput();
        verify(printStream, times(1)).println("Please select a valid option!");
    }

    @Test
    @ExpectSystemExit
    void testShouldPrintAnMessageToUserForQuit() {
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        userInput.readInput();
        verify(printStream, times(1)).println("Thank you!");
    }

    @Test
    @ExpectSystemExit
    void testShouldAllowUserToCheckOutBook() {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        System.setIn(new ByteArrayInputStream("Book1".getBytes()));
        System.setIn(new ByteArrayInputStream("Author1".getBytes()));
        System.setIn(new ByteArrayInputStream("1997".getBytes()));
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        System.setIn(new ByteArrayInputStream("3".getBytes()));

        userInput.readInput();

        verify(printStream, times(0)).print("Book1");
        verify(printStream, times(1)).print("Book2");
    }

    @Test
    @ExpectSystemExit
    void testShouldNotifyWithAnMessageToUserWhenUserCheckOutABook() {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        System.setIn(new ByteArrayInputStream("Book1".getBytes()));
        System.setIn(new ByteArrayInputStream("Author1".getBytes()));
        System.setIn(new ByteArrayInputStream("1997".getBytes()));
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        userInput.readInput();
        verify(printStream, times(1)).println("Thank you! Enjoy the Book");
    }

    @Test
    @ExpectSystemExit
    void testShouldNotifyWithAnMessageToUserWhenUserWantToCheckOutButBookNotAvailable() {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        System.setIn(new ByteArrayInputStream("Book4".getBytes()));
        System.setIn(new ByteArrayInputStream("Author4".getBytes()));
        System.setIn(new ByteArrayInputStream("1997".getBytes()));
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        userInput.readInput();
        verify(printStream, times(1)).println("Sorry, that book is not available");
    }

}