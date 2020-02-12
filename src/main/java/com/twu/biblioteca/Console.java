package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: no tests
public class Console {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public void display(String message) {
        System.out.println(message);
    }
    public String read() throws IOException {
        return bufferedReader.readLine();
    }

    public Integer readInteger() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public Book readBook() throws IOException {
        String bookName = read();
        String bookAuthor = read();
        String bookYear = read();
        return new Book(bookName, bookAuthor, bookYear);
    }

}
