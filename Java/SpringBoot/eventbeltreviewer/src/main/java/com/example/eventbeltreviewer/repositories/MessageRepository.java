package com.example.eventbeltreviewer.repositories;

import com.example.eventbeltreviewer.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}