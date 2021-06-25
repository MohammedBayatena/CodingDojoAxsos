package com.example.relationships.services;

import com.example.relationships.models.License;
import com.example.relationships.repositories.licenseRepository;
import org.springframework.stereotype.Service;

@Service
public class licenseService {

    private final licenseRepository licenseRepo;

    public licenseService(licenseRepository licenseRepo) {
        this.licenseRepo = licenseRepo;
    }

    public License createLicense(License l) {
        licenseRepo.save(l);
        return l;
    }

    public void updateLicense(License l) {
        licenseRepo.save(l);
    }




}
