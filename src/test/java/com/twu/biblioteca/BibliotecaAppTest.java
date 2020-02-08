package com.twu.biblioteca;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    @Test
    public void testShouldPrintTheWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        BibliotecaApp.main(new String[]{});
        verify(printStream).println("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void testShouldBeAbleToPrintAllAvailableBooks() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        BibliotecaApp.main(new String[]{});

        verify(printStream).print("Book1");
        verify(printStream).print("Book2");

    }

    @Test
    void testShouldPrintAllBooksWithTheirAuthorsNameAndYear() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

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

        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp.main(new String[]{});

        verify(printStream).print("1. List of Books");
        verify(printStream).print("Book1");
        verify(printStream).print("Author1");
        verify(printStream).print("1997");
        verify(printStream).print("Book2");
        verify(printStream).print("Author2");
        verify(printStream).print("1998");

    }
}