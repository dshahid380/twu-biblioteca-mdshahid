package com.twu.biblioteca;

import java.util.Scanner;

public class UserInput {
    private Library library;

    public UserInput(Library library) {
        this.library = library;
    }

    public void readInput() {
        int input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        if (input != 1 && input != 2 && input != 3) {
            System.out.println("Please select a valid option!");
            return;
        }
        switch (input) {
            case 1:
                this.library.displayAllBooks();
                break;
            case 2:
                System.out.println("Please Enter book name");
                String bookName = scanner.next();
                System.out.println("Please Enter book author name");
                String bookAuthor = scanner.next();
                System.out.println("Please Enter book year");
                String bookYear = scanner.next();
                Book book = new Book(bookName, bookAuthor, bookYear);
                this.library.checkOut(book);
                System.out.println("Thank you! Enjoy the Book");
                break;
            case 3:
                System.out.println("Thank you!");
                System.exit(0);
        }
    }
}
