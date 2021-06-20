package com.example.languages.services;

import com.example.languages.models.Language;
import com.example.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    //Created a class that we will access crud commands from , constructor is for initialization purposes
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    /*
     * This Method adds a Language object passed from a form or something else
     * */
    public Language addLanguage(Language language) {
        languageRepository.save(language);
        return language;
    }

    /**
     * This method find a language by id and returns null if not found , the object if found
     */

    public Language findLanguage(Long id) {
        Optional<Language> optional = languageRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    /*
     * This method edits an object and return the newly edited object
     * */

    public Language editLanguage(Language language) {
        languageRepository.save(language);
        return language;
    }

    /*
     * This method Deletes a Language given the language ID
     * */
    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }

    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }


}
