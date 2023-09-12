package com.example.academy.service;

import com.example.academy.entity.User;
import com.example.academy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void saveUser(User user) {
        userRepository.save(user);
    }
    public List<User> getAllUser(){

        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);

    }

    public User getUserByUsername(String username)
    {
        return (userRepository.findByUsername(username));
    }

    public void deleteUser(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            System.out.println("User not exist with this ID: "+id);
        }
        userRepository.deleteById(id);

    }
}
