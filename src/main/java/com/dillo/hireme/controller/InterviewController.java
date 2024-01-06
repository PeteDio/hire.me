package com.dillo.hireme.controller;

import com.dillo.hireme.repository.CandidateRepository;
import com.dillo.hireme.repository.InterviewRepository;
import com.dillo.hireme.service.InterviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interview")
public class InterviewController {
    private final InterviewService interviewService;
    private final InterviewRepository interviewRepository;
    private final CandidateRepository candidateRepository;


    public InterviewController(InterviewService interviewService, InterviewRepository interviewRepository,CandidateRepository candidateRepository) {
        this.interviewService = interviewService;
        this.interviewRepository = interviewRepository;
        this.candidateRepository=candidateRepository;
    }
    //TODO:Retrieve All Interviews
    //TODO:Retrieve a specific interview by id
    //TODO:add a new interview
    //TODO:update existing interview
    //TODO:delete an interview
    //TODO:interview by candidate_id
    //TODO:interview by employee_id
    //for the following we can use
    //TODO:an endpoint use to add notes and change the candidate_status_id to '3', 'Hiring Manager Screen'
    //TODO:an endpoint to change the change the candidate_status_id to either '4', 'Hired' or '5', 'Rejected'

}
