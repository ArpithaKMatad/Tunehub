package com.example.TuneHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHub.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
public Users findByEmail(String email);
}
