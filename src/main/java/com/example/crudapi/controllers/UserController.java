package com.example.crudapi.controllers;

import com.example.crudapi.entity.User;
import com.example.crudapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api") // กำหนด endpoint หลัก (/api)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        user.setId(0); //make new ID
        return userService.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}") // id is parameter
    public User getUser(@PathVariable int id){
        User myUser = userService.findById(id);
        if(myUser==null){
            throw new RuntimeException(id+"id does not exit");
        }
        return myUser;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        User myUser = userService.findById(id);
        if(myUser==null){
            throw new RuntimeException("id does not exist");
        }
        userService.deleteById(id);
        return "user with corresponding id removed";
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User myUser = userService.findById(id);
        if (myUser == null) {
            throw new RuntimeException(id + "does not exist");
        }

        return userService.save(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return userService.save(user);
    }

//    //send java object (class User)
//    @GetMapping("/users")
//    public List<User> getUser(){
//        List<User> data = new ArrayList<User>();
//        data.add(new User("Peter","Pan"));
//        data.add(new User("Harry","Potter"));
//        return data;
//    }


}
