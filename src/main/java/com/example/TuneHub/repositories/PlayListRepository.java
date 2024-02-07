package com.example.TuneHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHub.entities.Playlist;

public interface PlayListRepository  extends JpaRepository<Playlist,Integer>{

}
