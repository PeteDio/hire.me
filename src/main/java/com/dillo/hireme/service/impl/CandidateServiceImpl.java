package com.dillo.hireme.service.impl;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.repository.CandidateRepository;
import com.dillo.hireme.service.CandidateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {
    private

    final CandidateRepository candidateRepository;

    // TODO:Add repositories for related entities CandidateStatusRepository, InterviewRepository

    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
        // Inject other repositories if applicable
    }

    // Implement all methods from the CandidateService interface

    @Override


    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override


    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null); // Optional to handle potential NoSuchElementException
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public void updateCandidate(Long id, Candidate updatedCandidate) {
        // Implementation provided earlier (including firstName, lastName, email, bio, jobTitle)
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
}
