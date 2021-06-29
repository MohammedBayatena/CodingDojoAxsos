package com.example.eventbeltreviewer.services;

import com.example.eventbeltreviewer.models.Message;
import com.example.eventbeltreviewer.repositories.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message m) {
        messageRepository.save(m);
        return m;
    }

}
