package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetailer {
    private BookRepository repository;

    @Autowired
    public BookDetailer(BookRepository repository){
        this.repository = repository;
    }

    public Book execute(int id) {
        return this.repository.getBook(id);
    }
}
