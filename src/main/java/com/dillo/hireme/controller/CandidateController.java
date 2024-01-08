package com.dillo.hireme.controller;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.entity.CandidateStatus;
import com.dillo.hireme.repository.CandidateRepository;
import com.dillo.hireme.repository.CandidateStatusRepository;
import com.dillo.hireme.service.CandidateService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/candidate")
public class CandidateController {
    private final CandidateService candidateService;
    private final CandidateStatusRepository candidateStatusRepository;
    private final CandidateRepository candidateRepository;

    public CandidateController(CandidateService candidateService, CandidateStatusRepository candidateStatusRepository, CandidateRepository candidateRepository) {
        this.candidateService = candidateService;
        this.candidateStatusRepository= candidateStatusRepository;
        this.candidateRepository= candidateRepository;
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
    //Candidate by Status
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

}


