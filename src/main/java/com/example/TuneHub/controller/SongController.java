package com.example.TuneHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TuneHub.entities.Song;
import com.example.TuneHub.services.SongService;

@Controller
public class SongController {
	@Autowired
	SongService service;
	@PostMapping("/addSong")
    public String addSong(@ModelAttribute Song song)
    {
		boolean songStatus=service.songExists(song.getName());
		if (songStatus == false)
		{
			service.addSong(song);
			return "songSuccess";
		}
		else
		{
			System.out.println("Song already exists");
		}
		return "songExist";
    }
	 @GetMapping("/viewSong")
	    public String viewSongs(Model model)
	    {
	    	List<Song> songsList=service.fetchAllSongs();
	    	
	    	model.addAttribute("songs", songsList);
	    	return "displaySongs";
	    }
	
	@GetMapping("/playSong")
    public String playSong(Model model)
    {
		boolean premiumUser=false;
		if(premiumUser == true)
		{
			List<Song>songList=service.fetchAllSongs();
			model.addAttribute("songs", songList);
			return "displaySongs";
		}
		else
		{
			return "makePayment";
		}
    }
}
