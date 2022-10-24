package com.example.demo.controller;

import java.util.List;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
   
@RequestMapping(value = "/user")
    

   

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "")
    public ResponseEntity<?> getAll() {
        try {
            List<User> user = userService.getAll();
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping(value = "/add")
    public User createUser(@RequestBody User payload) {
        return userRepository.save(payload);
    }
    @PostMapping(value = "/add2")
    public ResponseEntity<?> create(@RequestBody User payload) {
        try {
            User user = userService.create(payload);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<?> update(@RequestBody User payload) {
        try {
            User user = userService.update(payload);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable (value = "id") Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok("Delete success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
