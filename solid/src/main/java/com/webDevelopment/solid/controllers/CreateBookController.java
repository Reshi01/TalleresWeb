package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCases.BookCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateBookController {
    private BookCreator bookCreator;

    @Autowired
    public CreateBookController(BookCreator bookCreator) {
        this.bookCreator = bookCreator;
    }

    @PostMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        HttpStatus codigo = HttpStatus.INTERNAL_SERVER_ERROR;
        try {
            book = bookCreator.execute(book);
            codigo = HttpStatus.OK;
        } catch (Exception e) {
            //TODO
        }
        return ResponseEntity.status(codigo).body(book);
    }
}
