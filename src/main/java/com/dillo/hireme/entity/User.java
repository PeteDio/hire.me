package com.dillo.hireme.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity representing a user within the system.
 */
@Entity
@Table(name = "user")
@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a no-argument constructor
public class User {
    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * User's email address, which must be unique.
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * User's first name.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * User's last name.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * User's password (hashed and securely stored).
     */
    @Column(nullable = false)
    private String password;

    /**
     * The role assigned to the user.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private Role role;
}
