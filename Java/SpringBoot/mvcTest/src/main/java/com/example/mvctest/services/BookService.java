package com.example.mvctest.services;

import com.example.mvctest.models.Book;
import com.example.mvctest.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//WE write the logic using the jpa queries here
//Combine multiple queries
//or just as models in python , this is the functions part of the models.py file while the repo is the orm built in functions


@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
        Book b = findBook(id);
        b.setTitle(title);
        b.setLanguage(lang);
        b.setDescription(desc);
        b.setNumberOfPages(numOfPages);
        bookRepository.save(b);
        return b;
    }

    public void deleteBook(Long id){
        Book b = findBook(id);
        bookRepository.delete(b);
    }

    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}