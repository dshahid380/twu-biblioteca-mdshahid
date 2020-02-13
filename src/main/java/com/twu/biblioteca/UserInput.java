package com.twu.biblioteca;

import java.io.IOException;
import java.util.List;

public class UserInput {
    private boolean status = true;
    private List<MenuItem> menuItems;
    private Console console;

    public UserInput(List<MenuItem> menuItems, Console console) {
        this.console = console;
        this.menuItems = menuItems;

    }

    public void readInput() throws IOException {

        int userInput = console.readInteger();
        try{
            if(userInput==6) {
                console.display("Thank you!");
                status = false;
            }
            menuItems.get(userInput-1).performOperation();
        } catch (Exception e){
            console.display("Please select a valid option!");
        }
    }
    public boolean isExit() {
        return status;
    }
}
