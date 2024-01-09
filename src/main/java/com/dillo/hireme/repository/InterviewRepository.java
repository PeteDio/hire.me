package com.dillo.hireme.repository;

import com.dillo.hireme.entity.Interview;
import com.dillo.hireme.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByNotesIsNull();

    List<Interview> findByEmployeeId(Long employeeId);

    List<Interview> findByCandidateId(Long candidateId);

    long countByCompleted(boolean b);
}
