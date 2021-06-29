package com.example.eventbeltreviewer.services;

import com.example.eventbeltreviewer.repositories.EventRepository;
import com.example.eventbeltreviewer.models.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event e) {
        eventRepository.save(e);
        return e;
    }


    public List<Event> getinState(String state) {
        return eventRepository.findAllByStateEquals(state);
    }

    public List<Event> getnotinState(String state) {
        return eventRepository.findAllByStateIsNot(state);
    }

    public Event findEventById(Long id) {
        return eventRepository.findEventById(id);
    }

    public void deleteEvent(Long eventid) {
        eventRepository.delete(findEventById(eventid));
    }
}
