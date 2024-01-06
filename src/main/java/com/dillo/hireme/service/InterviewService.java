package com.dillo.hireme.service;

import com.dillo.hireme.entity.Interview;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InterviewService {

    List<Interview> getAllInterviews();

    Interview getInterviewById(Long id);

    void saveInterview(Interview interview);

    void updateInterview(Long id, Interview updatedInterview);

    void deleteInterview(Long id);

    // Methods for managing candidate and employee relationships

    List<Interview> getInterviewsByCandidateId(Long candidateId);

    List<Interview> getInterviewsByEmployeeId(Long employeeId);

    List<Interview> getInterviewsWithoutNotes();
}
