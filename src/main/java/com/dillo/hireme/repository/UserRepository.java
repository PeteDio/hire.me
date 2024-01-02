package com.dillo.hireme.repository;

import com.dillo.hireme.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByEmail(String id);

    User findByEmail(String id);
}
