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
}