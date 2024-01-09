package com.dillo.hireme.service.impl;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.entity.CandidateStatus;
import com.dillo.hireme.repository.CandidateRepository;
import com.dillo.hireme.repository.CandidateStatusRepository;
import com.dillo.hireme.service.CandidateService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Implementation of the CandidateService interface, providing CRUD operations for candidates.
 */
@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;
    private final CandidateStatusRepository candidateStatusRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository, CandidateStatusRepository candidateStatusRepository) {
        this.candidateRepository = candidateRepository;
        this.candidateStatusRepository = candidateStatusRepository;
    }

    /**
     * Retrieves a list of all candidates.
     *
     * @return List of all candidates
     */
    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }


    /**
     * Retrieves a candidate by its ID.
     *
     * @param id The ID of the candidate to retrieve
     * @return The candidate, or null if not found
     */
    @Override
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }
    /**
     * Saves a new candidate to the database.
     *
     * @param candidate The candidate to save
     */
    @Override
    public void saveCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    /**
     * Updates an existing candidate with new information.
     *
     * @param id         The ID of the candidate to update
     * @param updatedCandidate The updated candidate information
     */
    @Override
    public void updateCandidate(Long id, Candidate updatedCandidate) {
        Candidate existingCandidate = getCandidateById(id);
        if (existingCandidate != null) {
            existingCandidate.setFirstName(updatedCandidate.getFirstName());
            existingCandidate.setLastName(updatedCandidate.getLastName());
            existingCandidate.setEmail(updatedCandidate.getEmail());
            existingCandidate.setJobTitle(updatedCandidate.getJobTitle());
            existingCandidate.setBio(updatedCandidate.getBio());
            candidateRepository.save(existingCandidate);
        } else {
            // Handle "candidate not found"
            throw new ResourceNotFoundException("Candidate not found with ID: " + id);
        }
    }
    /**
     * Deletes a candidate by its ID.
     *
     * @param id The ID of the candidate to delete
     */
    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
    /**
     * Updates the status of a candidate.
     *
     * @param candidate  The candidate whose status needs to be updated
     * @param updatedStatus The new status for the candidate
     * @return The updated CandidateStatus object
     */
    @Override
    public CandidateStatus updateCandidateStatus(Candidate candidate, String updatedStatus) {
        // Check for status existence
        CandidateStatus newStatus = candidateStatusRepository.findByName(updatedStatus);

        // Update candidate status
        candidate.setCandidateStatus(newStatus);
        candidateRepository.save(candidate);
        return newStatus;
    }



}
