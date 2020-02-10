package com.twu.biblioteca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.PrintStream;
import java.util.ArrayList;
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

}