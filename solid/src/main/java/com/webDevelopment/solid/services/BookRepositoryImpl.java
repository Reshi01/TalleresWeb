package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookRepositoryImpl implements BookRepository{
    private Map<Integer, Book> books;
    private int nextId;

    public BookRepositoryImpl() throws Exception {
        books = new HashMap<>();
        nextId = 1;
        this.save(new Book("Cien Anos De Soledad","Gabriel Garcia",1960,65000.00,"Largo",266));
        this.save(new Book("Oliver Twist","Charles Dickens",1880,35000.00,"Viejo",295));
        this.save(new Book("Tiempos Dificiles","Charles Dickens",1877,67000.00,"Dificil",178));
        this.save(new Book("La Caida del Angel","Carlos Zafon",2007,58000.00,"Libre",304));
        this.save(new Book("Lo que fue de ella","Gale Forman",2010,53000.00,"Se fue",201));
        this.save(new Book("El Discurso del Metodo","Jean Rousseau",1781,28000.00,"Metodico",155));
        this.save(new Book("Marina","Carlos Ruiz",2001,40000.00,"Magic",452));
        this.save(new Book("La Ciudad de los Perros","Mario Vargas",1963,23000.00,"Desastrosa",856));
        this.save(new Book("El Coronel no tiee quien le escriba","Gabriel Garcia",1968,22000.00,"Sad",487));
        this.save(new Book("Cronica de una muerte anunciada","Gabriel Garcia",1956,22000.00,"No lo vi venir",221));
    }

    @Override
    public void save(Book book) {
        books.put(nextId, book);
        nextId++;
    }

    @Override
    public List<Book> getByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books.values()) {
            if (b.getAuthor().equals(author)) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public Book getBook(int id) {
        return books.get(id);
    }
}
