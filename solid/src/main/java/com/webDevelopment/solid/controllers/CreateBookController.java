package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.useCases.BookCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateBookController {

    private BookCreator bookCreator;

    @Autowired
    public CreateBookController(BookCreator bookCreator) {
        this.bookCreator = bookCreator;
    }

    @RequestMapping("/healthCheck")
    public String createBook() {
        return "Not yet implemented!";
    }
}
