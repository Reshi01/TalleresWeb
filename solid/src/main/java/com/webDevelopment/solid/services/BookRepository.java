package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface BookRepository {
    public void save(Book book);
    public List<Book> getByAuthor(String author);
    public Book getBook(int id);
}
