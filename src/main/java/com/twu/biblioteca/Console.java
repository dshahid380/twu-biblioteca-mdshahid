package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public Movie readMovie() throws IOException {
        String movieName = read();
        String movieYear = read();
        String movieDirector = read();
        String movieRating = read();
        return new Movie(movieName, movieYear, movieDirector, movieRating);
    }

}
