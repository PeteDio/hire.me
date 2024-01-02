package com.dillo.hireme.repository;

import com.dillo.hireme.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
