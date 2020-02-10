package com.twu.biblioteca;

import java.util.List;

public class Menu {
    private List<String> menuList;
    Menu(List<String> menuList) {
        this.menuList = menuList;
    }

    public void show() {
        for (int i = 0; i < this.menuList.size(); i++)
            System.out.print((i + 1) + ". " + this.menuList.get(i));
        System.out.println("\nPlease choose an option : ");
    }

}
