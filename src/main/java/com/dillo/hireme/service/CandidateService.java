package com.dillo.hireme.service;

import com.dillo.hireme.entity.Candidate;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface CandidateService {

    List<Candidate> getAllCandidates();

    Candidate getCandidateById(Long id);

    void saveCandidate(Candidate candidate);

    void updateCandidate(Long id, Candidate updatedCandidate);

    void deleteCandidate(Long id);

    // TODO:Additional methods for related entities
    
}