package com.dillo.hireme.repository;


import com.dillo.hireme.entity.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateStatusRepository extends JpaRepository<CandidateStatus, Long> {
    @Query("SELECT cs FROM CandidateStatus cs WHERE cs.name = :name")
    CandidateStatus findByName(@Param("name") String name);
}
