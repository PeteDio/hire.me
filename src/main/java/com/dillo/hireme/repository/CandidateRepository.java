package com.dillo.hireme.repository;

import com.dillo.hireme.entity.Candidate;
import com.dillo.hireme.entity.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT c FROM Candidate c JOIN c.candidateStatus cs WHERE cs.name = :statusName")
    List<Candidate> findByCandidateStatus(@Param("statusName") String statusName);
}
