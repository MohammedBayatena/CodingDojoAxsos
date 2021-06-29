package com.example.eventbeltreviewer.repositories;

import com.example.eventbeltreviewer.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findAllByStateEquals(String state);

    List<Event> findAllByStateIsNot(String state);

    Event findEventById(Long id);


}