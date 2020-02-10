package com.twu.biblioteca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.PrintStream;
import java.util.List;
import static org.mockito.Mockito.*;

class MenuTest {
    Menu menu;
    PrintStream printStream;

    @BeforeEach
    public void setUp() {
        List<Book> bookList = List.of(new Book("Book1", "Author1", "1997"),
                new Book("Book2", "Author2", "1998"));
        List<String> menuList = List.of("List of Books", "Quit");
        Library library = new Library(bookList);
        menu = new Menu(library, menuList);
        printStream = mock(PrintStream.class);
        System.setOut(printStream);
    }

    @Test
    void testShouldPrintListOfMenus() {
        menu.show();
        verify(printStream).print("1. List of Books");
        verify(printStream).print("2. Quit");
    }

    @Test
    void testShouldPrintDetailsOfBooks() {
        menu.performOperation(1);
        verify(printStream).print("Book1");
        verify(printStream).print("Author1");
        verify(printStream).print("1997");
        verify(printStream).print("Book2");
        verify(printStream).print("Author2");
        verify(printStream).print("1998");
    }

    @Test
    void testShouldPrintAnMessageToUserForQuit() {
        menu.performOperation(2);
        verify(printStream, times(1)).println("Thank you!");
    }

    @Test
    void testShouldPrintAnMessageToUserWhenEnterWrongOption() {
        menu.performOperation(6);
        verify(printStream, times(1)).println("Please select a valid option!");
    }

}