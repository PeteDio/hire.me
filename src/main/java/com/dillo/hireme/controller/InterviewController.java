package com.dillo.hireme.controller;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.entity.Interview;
import com.dillo.hireme.repository.CandidateRepository;
import com.dillo.hireme.repository.InterviewRepository;
import com.dillo.hireme.service.CandidateService;
import com.dillo.hireme.service.InterviewService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/interview")
public class InterviewController {
    private final InterviewService interviewService;
    private final InterviewRepository interviewRepository;
    private final CandidateRepository candidateRepository;
    private final CandidateService candidateService;


    public InterviewController(InterviewService interviewService, InterviewRepository interviewRepository,CandidateRepository candidateRepository, CandidateService candidateService) {
        this.interviewService = interviewService;
        this.interviewRepository = interviewRepository;
        this.candidateRepository=candidateRepository;
        this.candidateService=candidateService;
    }
    // Retrieve All Interviews
    @GetMapping
    public ResponseEntity<List<Interview>> getAllInterviews() {
        List<Interview> interviews = interviewService.getAllInterviews();
        return ResponseEntity.ok(interviews);
    }

    // Retrieve a specific interview by id
    @GetMapping("/{id}")


    public ResponseEntity<Interview> getInterviewById(@PathVariable Long id)

    {
        Interview interview = interviewService.getInterviewById(id);
        if (interview == null) {
            throw new ResourceNotFoundException("Interview not found with ID: " + id);
        }
        return ResponseEntity.ok(interview);
    }

    // Add a new interview
    @PostMapping
    public ResponseEntity<Interview> saveInterview(@RequestBody Interview interview) {
        Interview newInterview = interviewService.saveInterview(interview);
        return ResponseEntity.ok(newInterview);
    }

    // Update existing interview
    @PutMapping("/{id}")
    public ResponseEntity<Interview> updateInterview(@PathVariable Long id, @RequestBody Interview updatedInterview) {
        Interview existingInterview = interviewService.updateInterview(id, updatedInterview);
        return ResponseEntity.ok(existingInterview);
    }

    // Delete an interview
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterview(@PathVariable Long id) {
        interviewService.deleteInterview(id);
        return ResponseEntity.noContent().build();
    }

    // Interview by candidate_id
    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity<List<Interview>> getInterviewsByCandidateId(@PathVariable Long candidateId) {
        List<Interview> interviews = interviewService.getInterviewsByCandidateId(candidateId);
        return ResponseEntity.ok(interviews);
    }

    // Interview by employee_id
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Interview>> getInterviewsByEmployeeId(@PathVariable Long employeeId) {
        List<Interview> interviews = interviewService.getInterviewsByEmployeeId(employeeId);
        return ResponseEntity.ok(interviews);
    }

    // Endpoint to add notes and change candidate_status_id to '3', 'Hiring Manager Screen'
    @PutMapping("/{id}/notes")
    public ResponseEntity<Interview> addNotesAndChangeStatus(@PathVariable Long id, @RequestBody Interview updatedInterview) {
        Interview interview = interviewService.getInterviewById(id);
        interview.setNotes(updatedInterview.getNotes());
        interviewRepository.save(interview);

        Candidate candidate = candidateService.getCandidateById(updatedInterview.getCandidate().getId());
        String updatedStatus = "Hiring Manager Screen";
        candidate.setCandidateStatus(candidateService.updateCandidateStatus(interview.getCandidate(), updatedStatus));

        return ResponseEntity.ok(interview);
    }

    // Endpoint to change candidate_status_id to '4' (Hired) or '5' (Rejected)
    @PutMapping("/{id}/status/{statusId}")
    public ResponseEntity<Interview> changeStatus(@PathVariable Long id, @PathVariable Integer statusId) {
        String updatedStatus = "";
        if(statusId == 4){
            updatedStatus = "Hired";
        }
        if(statusId== 5){
            updatedStatus= "Rejected";
        }
        else {
            throw new ResourceNotFoundException("Status not found with ID: " + statusId);
        }
        Interview interview = interviewService.changeStatus(id, updatedStatus);
        return ResponseEntity.ok(interview);
    }

}
