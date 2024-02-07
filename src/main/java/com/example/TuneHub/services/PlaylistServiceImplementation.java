package com.example.TuneHub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TuneHub.entities.Playlist;
import com.example.TuneHub.repositories.PlayListRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService {
	@Autowired
	PlayListRepository repo;
	@Override
	public void addPlaylist(Playlist playlist) {
		repo.save(playlist);
	}
	@Override
	public List<Playlist> fetchAllPlaylists() {
		return repo.findAll();
	}

}
