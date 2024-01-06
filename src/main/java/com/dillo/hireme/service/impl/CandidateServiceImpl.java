package com.dillo.hireme.service.impl;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.entity.CandidateStatus;
import com.dillo.hireme.repository.CandidateRepository;
import com.dillo.hireme.repository.CandidateStatusRepository;
import com.dillo.hireme.service.CandidateService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;
    private final CandidateStatusRepository candidateStatusRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository, CandidateStatusRepository candidateStatusRepository) {
        this.candidateRepository = candidateRepository;
        this.candidateStatusRepository = candidateStatusRepository;
    }


    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }



    @Override
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

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

    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

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
