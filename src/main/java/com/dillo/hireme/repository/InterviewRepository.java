package com.dillo.hireme.repository;

import com.dillo.hireme.entity.Interview;
import com.dillo.hireme.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
