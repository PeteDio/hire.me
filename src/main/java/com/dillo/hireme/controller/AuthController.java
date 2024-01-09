package com.dillo.hireme.controller;


import com.dillo.hireme.entity.User;
import com.dillo.hireme.repository.CandidateStatusRepository;
import com.dillo.hireme.repository.InterviewRepository;
import com.dillo.hireme.repository.UserRepository;
import com.dillo.hireme.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private CandidateStatusRepository candidateStatusRepository;
    @Autowired
    private InterviewRepository interviewRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * Handles GET requests to the "/register" endpoint, rendering the registration form.
     *
     * @return ModelAndView object containing the registration form view
     */
    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    /**
     * Handles POST requests to the "/register/save" endpoint, processing user registration.
     *
     * @param user     The user object to be registered
     * @param result   BindingResult object to capture validation errors
     * @param model    The model to hold data for the view
     * @return String representing the view name to render
     */
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
    @GetMapping("/dashboard")
    public ModelAndView showDashboard(Model model) {

        List<Object[]> roleCounts = userRepository.getRoleCounts();
        List<Map<String, Long>> candidateStatusCounts = candidateStatusRepository.getStatusCounts();
        long rejectedCandidateCount = candidateStatusRepository.countByCandidateStatus("Rejected");
        long hiredCandidateCount = candidateStatusRepository.countByCandidateStatus("Hired");
        long completedInterviewCount = interviewRepository.countByCompleted(true);

        // Add data to the model
        model.addAttribute("roleCounts", roleCounts);
        model.addAttribute("candidateStatusCounts", candidateStatusCounts);
        model.addAttribute("rejectedCandidateCount", rejectedCandidateCount);
        model.addAttribute("hiredCandidateCount", hiredCandidateCount);
        model.addAttribute("completedInterviewCount", completedInterviewCount);

        return new ModelAndView("dashboard");
    }
}
