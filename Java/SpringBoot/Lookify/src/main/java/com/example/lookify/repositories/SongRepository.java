package com.example.lookify.repositories;

import com.example.lookify.models.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findAll();
    List<Song> findTop10ByOrderByRatingDesc();
    List<Song> findSongByArtistContaining(String artist);
}
