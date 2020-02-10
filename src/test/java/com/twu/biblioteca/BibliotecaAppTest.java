package com.twu.biblioteca;

import com.ginsberg.junit.exit.ExpectSystemExit;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    @Test
    @ExpectSystemExit
    public void testShouldPrintTheWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        System.setIn(new ByteArrayInputStream("3".getBytes()));

        BibliotecaApp.main(new String[]{});

        verify(printStream).println("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    @ExpectSystemExit
    public void testShouldBeAbleToPrintAllAvailableBooks() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        System.setIn(new ByteArrayInputStream("3".getBytes()));

        BibliotecaApp.main(new String[]{});

        verify(printStream).print("Book1");
        verify(printStream).print("Book2");
        verify(printStream).println("Thank you!");

    }

    @Test
    @ExpectSystemExit
    void testShouldPrintAllBooksWithTheirAuthorsNameAndYear() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        System.setIn(new ByteArrayInputStream("3".getBytes()));

        BibliotecaApp.main(new String[]{});

        verify(printStream).print("Book1");
        verify(printStream).print("Author1");
        verify(printStream).print("1997");
        verify(printStream).print("Book2");
        verify(printStream).print("Author2");
        verify(printStream).print("1998");
    }

    @Test
    @ExpectSystemExit
    void testShouldPrintAllBooksDetailsWhenUserSelectListOfBooks() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        System.setIn(new ByteArrayInputStream("1".getBytes()));
        System.setIn(new ByteArrayInputStream("3".getBytes()));
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
    @ExpectSystemExit
    void testShouldPrintInvalidOptionIfUserChooseInvalidOption() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("6".getBytes()));
        System.setIn(new ByteArrayInputStream("3".getBytes()));

        BibliotecaApp.main(new String[]{});

        verify(printStream, times(1)).println("Please select a valid option!");
    }

    @Test
    @ExpectSystemExit
    void testShouldQuitTheApplicationWhenUserOptToQuit() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        System.setIn(new ByteArrayInputStream("3".getBytes()));

        BibliotecaApp.main(new String[]{});

        verify(printStream).println("Thank you!");
    }

    @Test
    @ExpectSystemExit
    void testShouldCheckOutABookFromLibraryWhenUserCheckOut() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String option1 = "3";
        String bookName = "Book1";
        String bookAuthor = "Author1";
        String bookYear = "1997";
        String inputStream = option1 + "\n" + bookName + "\n" + bookAuthor + "\n" + bookYear;
        System.setIn(new ByteArrayInputStream(inputStream.getBytes()));

        BibliotecaApp.main(new String[]{});
        verify(printStream, times(0)).print("Book1");
        verify(printStream, times(1)).print("Book2");
    }
}