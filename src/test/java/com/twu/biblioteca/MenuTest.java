package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MenuTest {
    @Test
    void testShouldPrintListOfMenus() {
        Menu menu = new Menu();
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        menu.show();
        verify(printStream).print("1. List of Books");
        verify(printStream).print("4. Quit");
    }

    @Test
    void testShouldPrintDetailsOfBooks() {
        Menu menu = new Menu();
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        menu.performOperation(1);
        verify(printStream).print("Book1");
        verify(printStream).print("Author1");
        verify(printStream).print("1997");
        verify(printStream).print("Book2");
        verify(printStream).print("Author2");
        verify(printStream).print("1998");
    }
}