package com.example.dojooverflow.repositories;

import com.example.dojooverflow.models.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagsRepository extends CrudRepository<Tag, Long> {

    Optional<Tag> findBySubject(String subject);


}
