package com.example.crudapi.controllers;

import com.example.crudapi.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api") // กำหนด endpoint หลัก (/api)
public class UserController {
    //send java object (class User)
    @GetMapping("/users")
    public List<User> getUser(){
        List<User> data = new ArrayList<User>();
        data.add(new User("Peter","Pan"));
        data.add(new User("Harry","Potter"));
        return data;
    }


}
