package com.example.dojosandninjas.services;


import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {

    private final DojoRepository dojoRepo;

    public DojoService(DojoRepository dojoRepo) {
        this.dojoRepo = dojoRepo;
    }

    public Dojo createDojo(Dojo d) {
        dojoRepo.save(d);
        return d;
    }

    public List<Dojo> getAllDojos() {
        return dojoRepo.findAll();
    }

    public Dojo findDojoById(Long id) {

        Optional<Dojo> dojo = dojoRepo.findById(id);
        if (dojo.isPresent()) {
            return dojo.get();
        } else {
            return null;
        }

    }
}
