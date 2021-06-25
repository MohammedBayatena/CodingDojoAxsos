package com.example.relationships.repositories;


import com.example.relationships.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface personRepository extends CrudRepository<Person, Long> {

    //Find Users who are not yet assigned to any other user
    @Query(value = "select * from persons as p where p.id not in (select licenses.person_id from licenses)", nativeQuery = true)
    List<Person> findAllNotHavingLicense();

    List<Person> findAll();

    Optional<Person> findById(Long id);


}
