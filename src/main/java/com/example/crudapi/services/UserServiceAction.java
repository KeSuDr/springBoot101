package com.example.crudapi.services;
import com.example.crudapi.entity.User;
import com.example.crudapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Define actions
@Service
public class UserServiceAction implements UserService{

    private UserRepository userRepository;

    @Autowired //use repository in service action
    public UserServiceAction(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
