package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    @Test
    public void testShouldPrintTheWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        System.setIn(new ByteArrayInputStream("4".getBytes()));

        BibliotecaApp.main(new String[]{});

        verify(printStream).println("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void testShouldBeAbleToPrintAllAvailableBooks() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("1\n4".getBytes()));

        BibliotecaApp.main(new String[]{});

        verify(printStream).print("Book1");
        verify(printStream).print("Book2");
        verify(printStream).println("Thank you!");

    }

    @Test
    void testShouldPrintAllBooksWithTheirAuthorsNameAndYear() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("1\n4".getBytes()));

        BibliotecaApp.main(new String[]{});

        verify(printStream).print("Book1");
        verify(printStream).print("Author1");
        verify(printStream).print("1997");
        verify(printStream).print("Book2");
        verify(printStream).print("Author2");
        verify(printStream).print("1998");
    }

    @Test
    void testShouldPrintAllBooksDetailsWhenUserSelectListOfBooks() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        System.setIn(new ByteArrayInputStream("1\n4".getBytes()));
        BibliotecaApp.main(new String[]{});

        verify(printStream, times(2)).print("1. List of Books");
        verify(printStream).print("Book1");
        verify(printStream).print("Author1");
        verify(printStream).print("1997");
        verify(printStream).print("Book2");
        verify(printStream).print("Author2");
        verify(printStream).print("1998");
    }

    @Test
    void testShouldPrintInvalidOptionIfUserChooseInvalidOption() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("6\n4".getBytes()));

        BibliotecaApp.main(new String[]{});

        verify(printStream,times(1)).println("Please select a valid option!");
    }

    @Test
    void testShouldQuitTheApplicationWhenUserOptToQuit() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        System.setIn(new ByteArrayInputStream("4".getBytes()));

        BibliotecaApp.main(new String[]{});

        verify(printStream).println("Thank you!");
    }

}