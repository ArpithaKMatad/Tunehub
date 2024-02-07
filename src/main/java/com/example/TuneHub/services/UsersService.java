package com.example.TuneHub.services;

import com.example.TuneHub.entities.Users;

public interface UsersService {
public String addUsers(Users user);
public boolean emailExists(String email);
public boolean validateUser(String email, String password);
public String getRole(String email);
public Users getUser(String email);
public void updateUser(Users user);
}
