package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void testShouldPrintAnMessageToUserForQuit() {
        Menu menu = new Menu();
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        menu.performOperation(4);
        verify(printStream,times(1)).println("Thank you!");
    }

    @Test
    void testShouldPrintAnMessageToUserWhenEnterWrongOption() {
        Menu menu = new Menu();
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        menu.performOperation(6);
        verify(printStream,times(1)).println("Please select a valid option!");
    }

}