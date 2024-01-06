package com.dillo.hireme.controller;

import com.dillo.hireme.entity.User;
import com.dillo.hireme.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("User", user);
        return "register";
    }
    @PostMapping("/register/save")
    // Create a new user
    public String register(@Valid @ModelAttribute("User") User user, BindingResult result, Model model) {
        User existingUser = userService.getUserById(user.getEmail());
        if (existingUser != null) {
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }
        if (result.hasErrors()) { // Handle validation errors
            model.addAttribute("User", user);
            return "/register";
        }
        userService.saveUser(user); // Save the valid user
        return "register";
    }

}
