package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User createUser(User user);
    User readUser(Long userId);
    User updateUser(Long userId, User user);
    boolean deleteUser(Long userId);
}