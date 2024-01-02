package com.dillo.hireme.controller;

import com.dillo.hireme.entity.User;
import com.dillo.hireme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/")
    public void add(@RequestBody User user){
        userService.saveUser(user);
    }

}
