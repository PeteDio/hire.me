package com.dillo.hireme.service.impl;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.entity.Interview;
import com.dillo.hireme.repository.InterviewRepository;
import com.dillo.hireme.service.CandidateService;
import com.dillo.hireme.service.InterviewService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterviewServiceImpl implements InterviewService {
    private final InterviewRepository interviewRepository;

    private final CandidateService candidateService;
    public InterviewServiceImpl(InterviewRepository interviewRepository, CandidateService candidateService){
        this.interviewRepository = interviewRepository;
        this.candidateService = candidateService;
    }
    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public Interview getInterviewById(Long id) {
        return interviewRepository.findById(id).orElse(null);
    }

    @Override
    public Interview saveInterview(Interview interview) {
        interviewRepository.save(interview);
        return interview;
    }

    @Override
    public Interview updateInterview(Long id, Interview updatedInterview) {
        Interview existingInterview = getInterviewById(id);
        if(existingInterview != null){
            existingInterview.setCandidate(updatedInterview.getCandidate());
            existingInterview.setDatetime(updatedInterview.getDatetime());
            existingInterview.setNotes(updatedInterview.getNotes());
            existingInterview.setEmployee(updatedInterview.getEmployee());
        }
        else {
            throw new ResourceNotFoundException("Interview not found with ID: " + id);
        }
        return existingInterview;
    }

    @Override
    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }

    @Override
    public Interview changeStatus(Long id, String updatedStatus) {
        // Check for interview existence
        Interview interview = interviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Interview not found with ID: " + id));

        // Update candidate status
        Candidate candidate = interview.getCandidate();
        candidateService.updateCandidateStatus(candidate, updatedStatus);

        return interview;
    }

    @Override
    public List<Interview> getInterviewsWithoutNotes() {
        return interviewRepository.findByNotesIsNull();
    }

    @Override
    public List<Interview> getInterviewsByEmployeeId(Long employeeId) {
        return interviewRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<Interview> getInterviewsByCandidateId(Long candidateId) {
        return interviewRepository.findByCandidateId(candidateId);
    }
}
