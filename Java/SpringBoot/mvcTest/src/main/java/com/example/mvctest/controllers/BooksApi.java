package com.example.mvctest.controllers;

import com.example.mvctest.models.Book;
import com.example.mvctest.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is the view and the controller mapping. We use the methods inside the Service File here like we used the models.py methods in python
@RestController
public class BooksApi {
    private final BookService bookService;

    public BooksApi(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }

    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }

    //The update is done via a put request
    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, @RequestParam(value = "title") String title, @RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }

    //The delete is done via a delete request
    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
