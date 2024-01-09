package com.dillo.hireme.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * Entity representing a role that can be assigned to users.
 */
@Entity
@Table(name = "role")
@NoArgsConstructor
@Data // Generates getters, setters, toString, equals, and hashCode
public class Role {

    /**
     * Unique identifier for the role.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the role, which must be unique.
     */
    @Column(unique = true, nullable = false)
    private String name;
}
