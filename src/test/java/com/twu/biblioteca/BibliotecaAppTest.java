package com.twu.biblioteca;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    @Test
    public void testShouldPrintTheWelcomeMessage() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(1,5);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);
        bibliotecaApp.start();
        verify(console).display("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void testShouldBeAbleToPrintAllAvailableBooks() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(1,5);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();

        verify(console).display("Book1 Author1 1997");
        verify(console).display("Book2 Author2 1998");

    }

    @Test
    void testShouldPrintAllBooksDetailsWhenUserSelectListOfBooks() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(1,5);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();

        verify(console, times(2)).display("List of Books");
        verify(console).display("Book1 Author1 1997");
        verify(console).display("Book2 Author2 1998");
    }

    @Test
    void testShouldPrintInvalidOptionIfUserChooseInvalidOption() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(6,5);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();

        verify(console, times(1)).display("Please select a valid option!");
    }

    @Test
    void testShouldQuitTheApplicationWhenUserOptToQuit() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(5);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();

        verify(console).display("Thank you!");
    }

    @Test
    void testShouldCheckOutABookFromLibraryWhenUserCheckOut() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(2,1,5);
        when(console.readBook()).thenReturn(new Book("Book1", "Author1", "1997"));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();
        verify(console, times(0)).display("Book1 Author1 1997");
        verify(console, times(1)).display("Book2 Author2 1998");
    }

    @Test
    void testShouldPrintAnMessageToUserWhenUserCheckOutABook() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(2,5);
        when(console.readBook()).thenReturn(new Book("Book1", "Author1", "1997"));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();
        verify(console, times(1)).display("Thank you! Enjoy the Book");
    }

    @Test
    void testShouldNotifyWithAnMessageToUserWhenUserWantToCheckOutButBookNotAvailable() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(2,5);
        when(console.readBook()).thenReturn(new Book("Book5", "Author5", "1997"));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();
        verify(console, times(1)).display("Sorry, that book is not available");
    }
}