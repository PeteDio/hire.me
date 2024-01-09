package com.dillo.hireme.controller;

import com.dillo.hireme.entity.User;
import com.dillo.hireme.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }
    @PostMapping("/register/save")
    // Create a new user
    public String register(@Valid @ModelAttribute("User") User user, BindingResult result, Model model) {
        User existingUser = userService.getUserByEmail(user.getEmail());
        if (existingUser != null) {
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }
        if (result.hasErrors()) { // Handle validation errors
            model.addAttribute("User", user);
            return "register";
        }
        userService.saveUser(user); // Save the valid user
        return "register";
    }

    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        return new ModelAndView("login"); // Name of the login form view
    }

    @PostMapping("/login")
    public ModelAndView handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        User user;
        if (userService.authenticateUser(username, password)) {
            user = userService.getUserByEmail(username);
            // Authentication successful
            model.addAttribute("User", user); // Store user object in session
            return new ModelAndView("dashboard") ; // Redirect to protected area
        } else {
            // Authentication failed
            model.addAttribute("error", "Invalid username or password");
            return new ModelAndView("login"); // Re-render login form with error message
        }
    }
    @GetMapping("/")
    public ModelAndView showLandingPage ()  {
        return new ModelAndView("index");
    }
}
