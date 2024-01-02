package com.dillo.hireme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dillo.hireme.entity.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
