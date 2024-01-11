package com.dillo.hireme.controller;

import com.dillo.hireme.entity.Role;
import com.dillo.hireme.entity.User;
import com.dillo.hireme.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
/**
 * Controller responsible for handling CRUD operations related to users.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    // Inject user service
    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
    }
    /**
     * Retrieves a list of all users and renders them in the "userList" view.
     *
     * @param model The model to hold data for the view
     * @return String representing the name of the view to render
     */
    @GetMapping("/getAll")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }

    /**
     * Retrieves a specific user by ID.
     *
     * @param id The ID of the user to retrieve
     * @return The User object if found, otherwise null
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * Prepares the "userEdit" view for editing an existing user.
     *
     * @param userId The ID of the user to edit
     * @param model The model to hold data for the view
     * @return String representing the name of the view to render
     */
    @GetMapping("/edit/{userId}")
    public String editUser(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);


        // Add list of roles for selection
        model.addAttribute("roles", userService.getAllUserRoles());
        return "userEdit";
    }
    /**
     * Deletes a user by ID.
     *
     * @param id The ID of the user to delete
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @PostMapping("/update/{userId}/{roleName}")
    public String updateUserRole(@PathVariable Long userId, @PathVariable String roleName){
        userService.updateUserRole(userId,roleName);
        return "redirect:/user/getAll";
    }
}
