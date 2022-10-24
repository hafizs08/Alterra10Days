package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        try {
            log.info("Get all user");
            List<User> user = userRepository.findAll();
            if (user.isEmpty()) {
                log.info("user is empty");
                throw new Exception("USER IS EMPTY");
            }
            return user;
        } catch (Exception e) {
            log.error("Get an error by get all user, Error : {}", e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    public User create(User payload) {
        try {
            log.info("Create user");
            User user = userRepository.save(payload);
            return user;
        } catch (Exception e) {
            log.error("Get an error by create user, Error : {}", e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    public User update(User payload) {
        try {
            log.info("Update user");
            User user = userRepository.save(payload);
            return user;
        } catch (Exception e) {
            log.error("Get an error by update user, Error : {}", e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    public void delete(Long id) {
        try {
            log.info("Delete user");
            userRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Get an error by delete user, Error : {}", e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}