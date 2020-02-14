package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {
    Console console;
    BibliotecaApp bibliotecaApp;
    int DISPLAY_BOOKS = 1;
    int CHECKOUT_BOOK = 2;
    //int RETURN_BOOK = 3;
    int DISPLAY_MOVIES = 4;
    //int CHECKOUT_MOVIES =5;
    int QUIT = 6;
    int INVALID = 9;

    @BeforeEach
    void setUp() {
        console = mock(Console.class);
        bibliotecaApp = new BibliotecaApp(console);
    }

    @Test
    public void testShouldPrintTheWelcomeMessage() throws IOException {
        when(console.readInteger()).thenReturn(DISPLAY_BOOKS, QUIT);

        bibliotecaApp.start();
        verify(console).display("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void testShouldBeAbleToPrintAllAvailableBooks() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(DISPLAY_BOOKS, QUIT);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();

        verify(console).display("Book1 Author1 1997");
        verify(console).display("Book2 Author2 1998");

    }

    @Test
    void testShouldPrintAllBooksDetailsWhenUserSelectListOfBooks() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(DISPLAY_BOOKS, QUIT);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();

        verify(console, times(2)).display("List of Books");
        verify(console).display("Book1 Author1 1997");
        verify(console).display("Book2 Author2 1998");
    }

    @Test
    void testShouldPrintInvalidOptionIfUserChooseInvalidOption() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(INVALID, QUIT);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();

        verify(console, times(1)).display("Please select a valid option!");
    }

    @Test
    void testShouldQuitTheApplicationWhenUserOptToQuit() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(QUIT);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();

        verify(console).display("Thank you!");
    }

    @Test
    void testShouldCheckOutABookFromLibraryWhenUserCheckOut() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(CHECKOUT_BOOK, DISPLAY_BOOKS, QUIT);
        when(console.readBook()).thenReturn(new Book("Book1", "Author1", "1997"));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();
        verify(console, times(0)).display("Book1 Author1 1997");
        verify(console, times(1)).display("Book2 Author2 1998");
    }

    @Test
    void testShouldPrintAnMessageToUserWhenUserCheckOutABook() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(CHECKOUT_BOOK, QUIT);
        when(console.readBook()).thenReturn(new Book("Book1", "Author1", "1997"));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();
        verify(console, times(1)).display("Thank you! Enjoy the Book");
    }

    @Test
    void testShouldNotifyWithAnMessageToUserWhenUserWantToCheckOutButBookNotAvailable() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(CHECKOUT_BOOK, QUIT);
        when(console.readBook()).thenReturn(new Book("Book6", "Author6", "1997"));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();
        verify(console, times(1)).display("Sorry, that book is not available");
    }

    @Test
    void testShouldDisplayListOfMovie() throws IOException {
        Console console = mock(Console.class);
        when(console.readInteger()).thenReturn(DISPLAY_MOVIES, QUIT);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);

        bibliotecaApp.start();

        verify(console).display("Movie1 2000 Director1 10");
        verify(console).display("Movie2 2001 Director2 9");
    }

}