package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBooksFinder {
    private BookRepository repository;

    @Autowired
    public AuthorBooksFinder(BookRepository repository){
        this.repository = repository;
    }

    public List<Book> execute(String author) {
        return this.repository.getByAuthor(author);
    }
}
