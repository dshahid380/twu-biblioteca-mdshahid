package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private HashMap<Integer, String> menuList = new HashMap<>();
    private final int optionOne = 1;
    private final int optionTwo = 2;
    private final int optionThree = 3;
    private final int optionFour = 4;

    Menu() {
        menuList.put(1, "List of Books");
        menuList.put(4, "Quit");
    }

    public void show() {
        for (Map.Entry<Integer, String> entry : menuList.entrySet())
            System.out.print(entry.getKey() + ". " + entry.getValue());
        System.out.println("\nPlease choose an option : ");
    }


    public void performOperation(int input) {
        BookShelf bookShelf = new BookShelf();
        if(input==1)
            bookShelf.displayAllBooks();
    }
}
