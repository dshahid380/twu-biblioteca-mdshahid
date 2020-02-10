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
        List<String> menuList = List.of("List of Books", "Quit");
        menu = new Menu(menuList);
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