package com.dillo.hireme.service;

import com.dillo.hireme.entity.Interview;


import java.util.List;


public interface InterviewService {

    List<Interview> getAllInterviews();

    Interview getInterviewById(Long id);

    Interview saveInterview(Interview interview);

    Interview updateInterview(Long id, Interview updatedInterview);

    void deleteInterview(Long id);

    // Methods for managing candidate and employee relationships

    List<Interview> getInterviewsByCandidateId(Long candidateId);

    List<Interview> getInterviewsByEmployeeId(Long employeeId);

    List<Interview> getInterviewsWithoutNotes();


    Interview changeStatus(Long id, String updatedStatus);
}
