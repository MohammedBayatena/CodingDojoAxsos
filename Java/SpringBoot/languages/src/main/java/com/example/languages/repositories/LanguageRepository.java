package com.example.languages.repositories;

import com.example.languages.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

    //here Goes the methods that we will use in servers
    Optional<Language> findById(Long id);
    List<Language> findAll(); // Need to put this here so it casts from iterable type to list type or error in Service


}
