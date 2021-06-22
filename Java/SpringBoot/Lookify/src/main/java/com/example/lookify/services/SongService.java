package com.example.lookify.services;

import com.example.lookify.models.Song;
import com.example.lookify.repositories.SongRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song addSong(Song s) {
        songRepository.save(s);
        return s;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getTopTen() {
        return songRepository.findTop10ByOrderByRatingDesc();
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    public List<Song> getSongsByArtist(String artist) {
        return songRepository.findSongByArtistContaining(artist);
    }

    // retrieves a Song
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }


}
