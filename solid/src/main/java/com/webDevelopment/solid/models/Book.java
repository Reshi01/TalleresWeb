package com.webDevelopment.solid.models;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    private String title;
    private String author;
    private Integer publishedYear;
    private Double price;
    private String description;
    private Integer pageNumber;

    public Book(String title, String author, Integer publishedYear, Double price, String description, Integer pageNumber) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
        this.description = description;
        this.pageNumber = pageNumber;
    }

    private boolean validateTitle (String title) {
        //TODO
        this.title = title;
        return true;
    }

    private boolean validateAuthor (String author) {
        Pattern pattern = Pattern.compile("[A-Za-z]+\\s[A-Za-z]+");
        Matcher matcher = pattern.matcher(author);
        if (matcher.matches()) {
            this.author = author;
            return true;
        }
        return false;
    }

    private boolean validatePrice (Double price) {
        if (price <= 10000) {
            return false;
        }
        if (price % 1 != 0) {
            return false;
        }
        this.price = price;
        return true;
    }

    private boolean validateDescription (String description) {
        if (description.length() > 200) {
            return false;
        }
        this.description = description;
        return true;
    }

    private boolean validatePublishedYear (Integer publishedYear) {
        if (publishedYear < 1000) {
            return false;
        }
        if (publishedYear > Calendar.YEAR) {
            return false;
        }
        this.publishedYear = publishedYear;
        return true;
    }

    public String createBookCard()
    {
        return "The book " + this.title + " has benn written by " + this.author + " and was " +
                "published in " + this.publishedYear + ". The book's price is " + this.price;
    }
}
