package com.twu.biblioteca;

import java.io.IOException;
import java.util.HashMap;

public class UserInput {
    private boolean status = true;
    private HashMap<Integer, MenuItem> menuItems;
    private Console console;

    public UserInput(HashMap<Integer, MenuItem> menuItems, Console console) {
        this.console = console;
        this.menuItems = menuItems;

    }

    public void readInput() throws IOException {

        int userInput = console.readInteger();
        try {
            if (userInput == 6) {
                console.display("Thank you!");
                status = false;
            }
            menuItems.get(userInput).performOperation();
        } catch (Exception e) {
            console.display("Please select a valid option!");
        }
    }

    public boolean isExit() {
        return status;
    }
}
