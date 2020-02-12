package com.twu.biblioteca;

import java.util.List;

public class Menu {
    private List<String> menuList;
    private Console console;

    Menu(List<String> menuList, Console console) {
        this.menuList = menuList;
        this.console = console;
    }

    public void show() {
        for (String menu : menuList) console.display(menu);
        console.display("Please choose an option : ");
    }

}
