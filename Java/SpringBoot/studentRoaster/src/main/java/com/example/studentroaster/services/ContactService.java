package com.example.studentroaster.services;

import com.example.studentroaster.models.Contact;
import com.example.studentroaster.repositories.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepo;

    public ContactService(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }


    public Contact createContact(Contact c) {
        contactRepo.save(c);
        return c;
    }


}
