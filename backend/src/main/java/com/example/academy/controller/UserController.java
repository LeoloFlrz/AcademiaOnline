package com.example.academy.controller;

import com.example.academy.entity.User;
import com.example.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> AllUsers() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        try{
            userService.saveUser(user);
            return ResponseEntity.ok("User Created Successully");
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this id does not exist" + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editUser(@RequestBody User user, @PathVariable Long id) {
        if (userService.getUserById(id).isPresent()) {
            userService.saveUser(user);
            System.out.println("Updated user with ID: " + id);
        }
        return ResponseEntity.ok("User not updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User Successfully Deleted");
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}
