package com.example.studentroaster.repositories;

import com.example.studentroaster.models.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findAll();

    Optional<Contact> getContactById(Long id);


}
