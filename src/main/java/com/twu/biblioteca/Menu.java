package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private List<String> menuList;
    private BookShelf bookShelf;

    Menu(BookShelf bookShelf, List<String> menuList) {
        this.menuList = menuList;
        this.bookShelf = bookShelf;
    }

    public void show() {
        for(int i = 0; i<this.menuList.size(); i++)
            System.out.print((i+1)+". "+this.menuList.get(i));
        System.out.println("\nPlease choose an option : ");
    }

    public void performOperation(int input) {
        if (input == 1)
            bookShelf.displayAllBooks();
        else if (input == 2)
            System.out.println("Thank you!");
        else
            System.out.println("Please select a valid option!");
    }
}
