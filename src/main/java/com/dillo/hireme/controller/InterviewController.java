package com.dillo.hireme.controller;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.entity.CandidateStatus;
import com.dillo.hireme.entity.Interview;
import com.dillo.hireme.entity.User;
import com.dillo.hireme.repository.InterviewRepository;
import com.dillo.hireme.repository.UserRepository;
import com.dillo.hireme.service.CandidateService;
import com.dillo.hireme.service.InterviewService;
import com.dillo.hireme.service.UserService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/interview")
public class InterviewController {
    private final InterviewService interviewService;
    private final InterviewRepository interviewRepository;
    private final CandidateService candidateService;
    private final UserService userService;
    private final UserRepository userRepository;


    public InterviewController(InterviewService interviewService,UserRepository userRepository, UserService userService, InterviewRepository interviewRepository, CandidateService candidateService) {
        this.interviewService = interviewService;
        this.interviewRepository = interviewRepository;
        this.candidateService= candidateService;
        this.userService = userService;
        this.userRepository = userRepository;
    }
    // Retrieve All Interviews
    @GetMapping("/")
    public String getAllInterviews(Model model) {
        List<Interview> interviews = interviewService.getAllInterviews();
        model.addAttribute("interviews", interviews);
        return "interviews";
    }

    @PostMapping("/")
    public String updateInterview(@ModelAttribute("interview") Interview interview) {
        interviewService.updateInterview(interview.getId(), interview);
        return "redirect:/interviews/";
    }

    // Retrieve a specific interview by id
    @GetMapping("/{id}")
    public ResponseEntity<Interview> getInterviewById(@PathVariable Long id) {
        Interview interview = interviewService.getInterviewById(id);
        if (interview == null) {
            throw new ResourceNotFoundException("Interview not found with ID: " + id);
        }
        return ResponseEntity.ok(interview);
    }
    @PostMapping("/new/{id}")
    public String scheduleInterview(@PathVariable Long id, @ModelAttribute("interview") Interview interview) {
        interviewService.saveInterview(interview);
        return "redirect:/interviews/";
    }
    @GetMapping("/new/{id}")
    public String showScheduleInterview(Model model, @PathVariable Long id) {
        Interview interview = new Interview(); // Assuming you have an Interview model class
        model.addAttribute("interview", interview);

        Candidate candidate = candidateService.getCandidateById(id);
        Long statusId = candidate.getCandidateStatus().getId();
        List<User> interviewers = userRepository.findByRoleId(statusId);
        model.addAttribute("candidate", candidate);
        model.addAttribute("interviewers", interviewers);
        return "scheduleInterview";
    }
    // Update existing interview
    @PutMapping("/update/{id}")
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

    @GetMapping("/without-notes")
    public List<Interview> getInterviewsWithoutNotes() {
        return interviewService.getInterviewsWithoutNotes();
    }

}
