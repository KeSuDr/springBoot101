package com.example.crudapi.services;
import com.example.crudapi.entity.User;
import com.example.crudapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Define actions
@Service
public class UserServiceAction implements UserService{

    private UserRepository userRepository;

    @Autowired //use repository in service action
    public UserServiceAction(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    //save user to database
    public User save(User user) {
        //return saved user to service
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> result = userRepository.findById(id);
        User data=null;
        if(result.isPresent()){
            data=result.get();
        }else{
            throw new RuntimeException("id does not exist");
        }
        return data;
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


}
