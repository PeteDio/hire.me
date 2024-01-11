package com.dillo.hireme.controller;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.entity.CandidateStatus;
import com.dillo.hireme.repository.CandidateRepository;
import com.dillo.hireme.repository.CandidateStatusRepository;
import com.dillo.hireme.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Controller responsible for handling CRUD operations related to candidates.
 */
@Controller
@RequestMapping("/candidate")
public class CandidateController {
    // Inject required services and repositories
    private final CandidateService candidateService;
    private final CandidateStatusRepository candidateStatusRepository;
    private final CandidateRepository candidateRepository;

    public CandidateController(CandidateService candidateService, CandidateStatusRepository candidateStatusRepository, CandidateRepository candidateRepository) {
        this.candidateService = candidateService;
        this.candidateStatusRepository= candidateStatusRepository;
        this.candidateRepository= candidateRepository;
    }

    /**
     * Retrieves a list of all candidates and renders them in the "candidatesList" view.
     *
     * @param model The model to hold data for the view
     * @return String representing the name of the view to render
     */
    @GetMapping("/")
    public String getAllCandidates(Model model) {
        List<Candidate> candidates = candidateService.getAllCandidates();
        model.addAttribute("candidates",candidates);
        return "candidatesList";
    }

    // Retrieve a specific candidate by ID
    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return candidateService.getCandidateById(id);
    }

    // Add a new candidate
    @PostMapping("/add")
    public String addCandidate(@Valid @ModelAttribute("candidate") Candidate candidate, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("candidate", candidate); // Add candidate back to model for error display
            return "addCandidate"; // Return to the form view for correction
        }
        candidateService.saveCandidate(candidate); // Save valid candidate
        return "redirect:/candidate/"; // Redirect to a success page or display a success message
    }


    // Update an existing candidate
    @PutMapping("/{id}")
    public void updateCandidate(@PathVariable Long id, @RequestBody Candidate updatedCandidate) {
        candidateService.updateCandidate(id, updatedCandidate);
    }

    // Delete a candidate
    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
    }
    /**
     * Retrieves candidates based on a specific candidate status.
     *
     * @param name The name of the candidate status to filter by
     * @return List of candidates matching the specified status
     * @throws ResourceNotFoundException if the specified status is not found
     */
    @GetMapping("/status/{name}")
    public List<Candidate> getCandidateByStatus(@PathVariable String name) {
        // Retrieve CandidateStatus object by name
        CandidateStatus status = candidateStatusRepository.findByName(name);
        // Handle potential errors
        if (status == null) {
            throw new ResourceNotFoundException("CandidateStatus not found with name: " + name);
        }
        return candidateRepository.findByCandidateStatus(name);
    }
    @GetMapping("/add")
    public String showAddCandidate(Model model){
        Candidate candidate = new Candidate();
        model.addAttribute("candidate", candidate);
        return "addCandidate";
    }

}


