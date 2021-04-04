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

    public Book(String title, String author, Integer publishedYear, Double price, String description, Integer pageNumber) throws Exception {
        validateTitle(title);
        this.title = title;
        validateAuthor(author);
        this.author = author;
        validatePublishedYear(publishedYear);
        this.publishedYear = publishedYear;
        validatePrice(price);
        this.price = price;
        validateDescription(description);
        this.description = description;
        validatePageNumber(pageNumber);
        this.pageNumber = pageNumber;
    }

    private void validateTitle (String title) throws Exception {
        if (title.length() < 1) {
            throw new Exception("Invalid title length");
        }
    }

    private void validateAuthor (String author) throws Exception {
        Pattern pattern = Pattern.compile("[A-Za-z]+\\s[A-Za-z]+");
        Matcher matcher = pattern.matcher(author);
        if (!matcher.matches()) {
            throw new Exception("Invalid author");
        }
    }

    private void validatePrice (Double price) throws Exception {
        if (price <= 10000) {
            throw new Exception("Invalid price");
        }
        if (price % 1 != 0) {
            throw new Exception("Invalid price");
        }
    }

    private void validateDescription (String description) throws Exception {
        if (description.length() > 200) {
            throw new Exception("Invalid description");
        }
    }

    private void validatePublishedYear (Integer publishedYear) throws Exception {
        if (publishedYear < 1000) {
            throw new Exception("Invalid published year");
        }
        if (publishedYear > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new Exception("Invalid published year");
        }
    }

    private void validatePageNumber (int pageNumber) throws Exception {
        if (pageNumber < 1 || pageNumber > 1500) {
            throw new Exception("Invalid page number");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }
}
