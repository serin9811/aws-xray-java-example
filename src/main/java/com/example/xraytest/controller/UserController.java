package com.example.xraytest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok("user");
    }

    @PostMapping("/users/{name}/{email}")
    public ResponseEntity<?> createUser(@PathVariable String name, @PathVariable String email) {
        return ResponseEntity.ok("name : " + name + ", email " + email + "was created!");
    }

    @DeleteMapping("/users/{name}")
    public ResponseEntity<?> deleteUser(@PathVariable String name) {
        return ResponseEntity.ok("name : " + name +" was deleted!");
    }

    @PutMapping("/user/{name}")
    public ResponseEntity<?> updateUser(@PathVariable String name) {
        return ResponseEntity.ok("name: " + name + " was updated" );
    }
}
