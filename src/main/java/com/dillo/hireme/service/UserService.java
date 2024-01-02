package com.dillo.hireme.service;

import com.dillo.hireme.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> getAllUsers();

    User getUserById(String id);

    void updateUser(String id, User updatedUser);

    void deleteUser(String id);
}
