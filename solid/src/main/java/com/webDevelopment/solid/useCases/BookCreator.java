package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCreator {
    private BookRepository repository;

    @Autowired
    public BookCreator(BookRepository repository){
        this.repository = repository;
    }

    public Integer execute(Book book) {
        return this.repository.save(book);
    }
}
