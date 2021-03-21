package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookRepository {
    List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        //books.add(new Book("1984", "George Orwell", 1949, 20d));
    }
}
