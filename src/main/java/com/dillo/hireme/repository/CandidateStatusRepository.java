package com.dillo.hireme.repository;


import com.dillo.hireme.entity.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface CandidateStatusRepository extends JpaRepository<CandidateStatus, Long> {
    @Query("SELECT cs FROM CandidateStatus cs WHERE cs.name = :name")
    CandidateStatus findByName(@Param("name") String name);
    @Query("SELECT c.candidateStatus, COUNT(c) FROM Candidate c GROUP BY c.candidateStatus")
    List<Map<String, Long>> getStatusCounts();
    @Query("SELECT COUNT(c) FROM Candidate c WHERE c.candidateStatus.name = :status")
    long countByCandidateStatus(@Param("status") String status);
}
