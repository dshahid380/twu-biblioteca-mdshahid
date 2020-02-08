package com.twu.biblioteca;
import org.junit.jupiter.api.Test;
import java.io.PrintStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
}