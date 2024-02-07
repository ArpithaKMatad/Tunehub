package com.example.TuneHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHub.entities.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{
	public Song findByName(String song);

}
