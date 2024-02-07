package com.example.TuneHub.services;

import java.util.List;

import com.example.TuneHub.entities.Playlist;

public interface PlaylistService {

  public void addPlaylist(Playlist playlist);

public List<Playlist> fetchAllPlaylists();

}
