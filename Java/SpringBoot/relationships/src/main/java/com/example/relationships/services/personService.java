package com.example.relationships.services;

import com.example.relationships.models.Person;
import com.example.relationships.repositories.personRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class personService {

    private final personRepository personRepo;

    public personService(personRepository personRepo) {
        this.personRepo = personRepo;
    }

    public Person createPerson(Person p) {
        personRepo.save(p);
        return p;
    }

    public List<Person> getAll() {
        return personRepo.findAllNotHavingLicense();
    }

    public Person getPerson(Long id) {
        Optional<Person> person = personRepo.findById(id);
        if (person.isPresent()) {
            return person.get();
        } else {
            return null;
        }
    }

}
