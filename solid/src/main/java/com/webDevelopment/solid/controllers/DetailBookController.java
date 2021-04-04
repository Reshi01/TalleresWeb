package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCases.BookCreator;
import com.webDevelopment.solid.useCases.BookDetailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetailBookController {
    private BookDetailer bookDetailer;

    @Autowired
    public DetailBookController(BookDetailer bookDetailer) {
        this.bookDetailer = bookDetailer;
    }

    @GetMapping(value = "/books/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> createBook(@PathVariable(value = "bookId") String id) {
        HttpStatus codigo = HttpStatus.OK;
        Book book = bookDetailer.execute(Integer.valueOf(id));
        if (book == null) {
            codigo = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(codigo).body(book);
    }
}
