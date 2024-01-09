package com.dillo.hireme.repository;

import com.dillo.hireme.entity.CandidateStatus;
import com.dillo.hireme.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByEmail(String id);

    User findByEmail(String email);

    List<User> findByRoleId(Long roleId);

}
