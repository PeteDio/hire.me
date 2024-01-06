package com.dillo.hireme.service.impl;

import com.dillo.hireme.entity.Interview;
import com.dillo.hireme.repository.InterviewRepository;
import com.dillo.hireme.service.InterviewService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

public class InterviewServiceImpl implements InterviewService {
    private final InterviewRepository interviewRepository;
    public InterviewServiceImpl(InterviewRepository interviewRepository){
        this.interviewRepository = interviewRepository;
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
    public void saveInterview(Interview interview) {
        interviewRepository.save(interview);
    }

    @Override
    public void updateInterview(Long id, Interview updatedInterview) {
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
    }

    @Override
    public void deleteInterview(Long id) {

    }

    @Override
    public List<Interview> getInterviewsByCandidateId(Long candidateId) {
        return null;
    }

    @Override
    public List<Interview> getInterviewsWithoutNotes() {
        return null;
    }

    @Override
    public List<Interview> getInterviewsByEmployeeId(Long employeeId) {
        return null;
    }
}
