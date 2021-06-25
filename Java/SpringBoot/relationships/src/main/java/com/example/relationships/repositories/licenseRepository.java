package com.example.relationships.repositories;

import com.example.relationships.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface licenseRepository extends CrudRepository<License, Long> {
    List<License> findAll();
}
