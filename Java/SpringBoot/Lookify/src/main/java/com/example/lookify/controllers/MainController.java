package com.example.lookify.controllers;


import com.example.lookify.models.Song;
import com.example.lookify.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    private final SongService songservice;

    public MainController(SongService songservice) {
        this.songservice = songservice;
    }


    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public String redirectSearch(@RequestParam("artistSearch") String artist) {
        return "redirect:/search/" + artist;
    }

    @RequestMapping("/search/{name}")
    public String renderSearch(@PathVariable("name") String artist, Model model) {
        model.addAttribute("artist", artist);
        model.addAttribute("songs", songservice.getSongsByArtist(artist));
        return "artistsongs.jsp";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String renderSearchSong(@RequestParam("songSearch") String artist, Model model) {
        return "redirect:/search/" + artist;
    }

    @RequestMapping("/dashboard")
    public String renderDashboard(Model model) {
        model.addAttribute("songs", songservice.getAllSongs());
        return "dashboard.jsp";
    }

    @RequestMapping("/search/topTen")
    public String renderTopTen(Model model) {
        model.addAttribute("songs", songservice.getTopTen());
        return "topten.jsp";
    }


    @RequestMapping(value = "/songs/new")
    public String renderNew(@ModelAttribute("song") Song song) {
        return "new.jsp";
    }

    @RequestMapping(value = "/songs/new", method = RequestMethod.POST)
    public String addNew(@Valid @ModelAttribute("song") Song song,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            songservice.addSong(song);
            return ("redirect:/dashboard");
        }
    }

    @RequestMapping("/delete/{id}")
    public String handleDelete(@PathVariable("id") Long id) {
        songservice.deleteSong(id);
        return "redirect:/dashboard";
    }


    @RequestMapping("/songs/{id}")
    public String renderInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", songservice.findSong(id));
        return "info.jsp";
    }


}
