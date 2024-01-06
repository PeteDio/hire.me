package com.dillo.hireme.controller;

import com.dillo.hireme.entity.User;
import com.dillo.hireme.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
    }
    @GetMapping("/index")
    public String home() {
        return "index";
    }
    @GetMapping("/login")
    public String landingPage() {
        return "login";
    }

    // Retrieve all users
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Retrieve a specific user by ID
    @GetMapping("/{id}")
    public User getById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody User updatedUser) {
        userService.updateUser(id, updatedUser);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
