package com.mepemproject.mepemproject.controller;

import com.mepemproject.mepemproject.model.Usermodel;
import com.mepemproject.mepemproject.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Logincontroller {

    @Autowired
    private Userservice userService;

    // POST Method: Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usermodel loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Example logic: authenticate user
        if (userService.authenticate(username, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    // GET Method: Get all users
    @GetMapping("/users")
    public ResponseEntity<List<Usermodel>> getAllUsers() {
        List<Usermodel> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // GET Method: Get user details by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<Usermodel> getUserById(@PathVariable Long id) {
        Usermodel user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT Method: Update user details
    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody Usermodel updatedUser) {
        boolean updated = userService.updateUser(id, updatedUser);
        if (updated) {
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST Method: Create a new user
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody Usermodel newUser) {
        boolean created = userService.createUser(newUser);
        if (created) {
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user");
        }
    }

    // DELETE Method: Delete user by ID
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
