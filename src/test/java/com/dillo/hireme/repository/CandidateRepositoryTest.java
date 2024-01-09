package com.dillo.hireme.repository;

import com.dillo.hireme.entity.Candidate;
import org.junit.jupiter.api.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.dillo.hireme.repository.CandidateRepository;
public class CandidateRepositoryTest {
    @Test
    public void testSaveCandidate() {
        Candidate candidate = new Candidate("John Doe", "johndoe@example.com", "Software Engineer");

        Candidate savedCandidate = candidateRepository.save(candidate);

        assertNotNull(savedCandidate.getId());
        assertEquals(candidate.getFirstName(), savedCandidate.getFirstName());
        assertEquals(candidate.getLastName(), savedCandidate.getLastName());
        assertEquals(candidate.getEmail(), savedCandidate.getEmail());
        assertEquals(candidate.getJobTitle(), savedCandidate.getJobTitle());
    }
}
