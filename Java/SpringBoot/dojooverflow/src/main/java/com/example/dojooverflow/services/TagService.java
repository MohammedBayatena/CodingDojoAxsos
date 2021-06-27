package com.example.dojooverflow.services;

import com.example.dojooverflow.models.Tag;
import com.example.dojooverflow.repositories.TagsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {

    private final TagsRepository tagsRepo;

    public TagService(TagsRepository tagsRepo) {
        this.tagsRepo = tagsRepo;
    }

    public Tag createTag(Tag t) {

        Optional<Tag> taglist = tagsRepo.findBySubject(t.getSubject());
        if (taglist.isPresent()) {
            System.out.println("Tag Already added!");
            t = null;
        } else {
            tagsRepo.save(t);
        }
        return t;
    }


}
