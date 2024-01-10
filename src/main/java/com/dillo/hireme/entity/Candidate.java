package com.dillo.hireme.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity representing a candidate in the recruitment process.
 */
@Entity
@Data
@Table(name = "candidate")
public class Candidate {
    /**
     * Unique identifier for the candidate.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Candidate's first name.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * Candidate's last name.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * Candidate's email address, which must be unique.
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * Candidate's current or desired job title.
     */
    @Column
    private String jobTitle;

    /**
     * Candidate's professional bio or summary.
     */
    @Column
    private String bio;

    /**
     * The current status of the candidate in the recruitment process.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_status_id")
    private CandidateStatus candidateStatus;
}
