package com.example.crudapi.services;

import com.example.crudapi.entity.User;

import java.util.List;

//Define Stucture
public interface UserService {
    User save(User user); // save user info
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
}
