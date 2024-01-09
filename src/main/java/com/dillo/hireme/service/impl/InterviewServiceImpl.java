package com.dillo.hireme.service.impl;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.entity.Interview;
import com.dillo.hireme.repository.InterviewRepository;
import com.dillo.hireme.service.CandidateService;
import com.dillo.hireme.service.InterviewService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Implementation of the InterviewService interface, providing CRUD operations for interviews.
 */
@Service
public class InterviewServiceImpl implements InterviewService {
    private final InterviewRepository interviewRepository;

    private final CandidateService candidateService;
    public InterviewServiceImpl(InterviewRepository interviewRepository, CandidateService candidateService){
        this.interviewRepository = interviewRepository;
        this.candidateService = candidateService;
    }
    /**
     * Retrieves a list of all interviews.
     *
     * @return List of all interviews
     */
    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }
    /**
     * Retrieves an interview by its ID.
     *
     * @param id The ID of the interview to retrieve
     * @return The interview, or null if not found
     */
    @Override
    public Interview getInterviewById(Long id) {
        return interviewRepository.findById(id).orElse(null);
    }
    /**
     * Saves a new interview to the database.
     *
     * @param interview The interview to save
     * @return The saved interview
     */
    @Override
    public Interview saveInterview(Interview interview) {
        interviewRepository.save(interview);
        return interview;
    }
    /**
     * Updates an existing interview with new information.
     *
     * @param id         The ID of the interview to update
     * @param updatedInterview The updated interview information
     * @return The updated interview
     */
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
    /**
     * Deletes an interview by its ID.
     *
     * @param id The ID of the interview to delete
     */
    @Override
    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }

    /**
     * Changes the status of a candidate associated with an interview.
     *
     * @param id       The ID of the interview
     * @param updatedStatus The new status for the candidate
     * @return The interview
     */
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

    /**
     * Retrieves interviews conducted by a specific employee.
     *
     * @param employeeId The ID of the employee
     * @return List of interviews conducted by the employee
     */
    @Override
    public List<Interview> getInterviewsByEmployeeId(Long employeeId) {
        return interviewRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<Interview> getInterviewsByCandidateId(Long candidateId) {
        return interviewRepository.findByCandidateId(candidateId);
    }
}
