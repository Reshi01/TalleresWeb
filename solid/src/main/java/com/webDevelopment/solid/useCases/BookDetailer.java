package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDetailer {
    private BookRepository repository;

    @Autowired
    public BookDetailer(BookRepository repository){
        this.repository = repository;
    }

    public String execute(int id) throws Exception {
        Book book = this.repository.getBook(id);
        if (book == null) {
            throw new Exception("BookDetailer.execute Cause: Book not found");
        }
        return book.getBookDetails();
    }
}
