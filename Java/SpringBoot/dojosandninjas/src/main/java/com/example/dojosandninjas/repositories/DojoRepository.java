package com.example.dojosandninjas.repositories;

import com.example.dojosandninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {

    List<Dojo> findAll();

    Optional<Dojo> findById(Long id);


}