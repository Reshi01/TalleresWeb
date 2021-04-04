package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCases.AuthorBooksFinder;
import com.webDevelopment.solid.useCases.BookCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FindAuthorBooksController {
    private AuthorBooksFinder authorBooksFinder;

    @Autowired
    public FindAuthorBooksController(AuthorBooksFinder authorBooksFinder) {
        this.authorBooksFinder = authorBooksFinder;
    }

    @GetMapping (value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> createBook(@RequestParam(name = "author") String author) {
        HttpStatus codigo = HttpStatus.OK;
        List<Book> books = authorBooksFinder.execute(author);
        return ResponseEntity.status(codigo).body(books);
    }
}