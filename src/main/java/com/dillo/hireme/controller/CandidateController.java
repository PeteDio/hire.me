package com.dillo.hireme.controller;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.service.CandidateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/candidate")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    // Retrieve all candidates
    @GetMapping("/")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    // Retrieve a specific candidate by ID
    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return candidateService.getCandidateById(id);
    }

    // Add a new candidate
    @PostMapping("/")
    public void addCandidate(@RequestBody Candidate candidate) {
        candidateService.saveCandidate(candidate);
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
}
