package com.example.mvctest.repositories;

import com.example.mvctest.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//WE define the functions the JPA will be creating or that we have in this file
//WE then use those that we defined here in the Service
//The Service can combine multiple functions like those in one big functions aka can use different queries to achieve a goal

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    // this method retrieves all the books from the database
    List<Book> findAll();
    // this method finds books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);



}
