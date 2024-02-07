package com.example.TuneHub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TuneHub.entities.Playlist;
import com.example.TuneHub.entities.Song;
import com.example.TuneHub.services.PlaylistService;
import com.example.TuneHub.services.SongService;


@Controller
public class PlaylistController {
	@Autowired
	SongService songservice;
	
	@Autowired
	PlaylistService playlistService;
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model)
	{
		List<Song>songList=songservice.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createPlaylist";
	}

	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		//updating the play list table
		playlistService.addPlaylist(playlist);
		//updating song table
		List<Song>songList=playlist.getSongs();
		for(Song s: songList)
		{
			s.getPlaylist().add(playlist);
			songservice.updateSong(s);//updating songs in database
			
		}
		
		return "adminHome";
	}
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model)
	{
		List<Playlist>allPlaylists=playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylists",allPlaylists);
		return "displayPlaylist";
	}
}
