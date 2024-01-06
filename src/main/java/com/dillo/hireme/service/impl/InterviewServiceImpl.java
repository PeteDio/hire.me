package com.dillo.hireme.service.impl;

import com.dillo.hireme.entity.Interview;
import com.dillo.hireme.service.InterviewService;

import java.util.List;

public class InterviewServiceImpl implements InterviewService {
    @Override
    public List<Interview> getAllInterviews() {
        return null;
    }

    @Override
    public Interview getInterviewById(Long id) {
        return null;
    }

    @Override
    public void saveInterview(Interview interview) {

    }

    @Override
    public void updateInterview(Long id, Interview updatedInterview) {

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
