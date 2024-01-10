package com.dillo.hireme.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entity representing a scheduled interview with a candidate.
 */
@Entity
@Table(name = "interview")
@Data // Generates getters, setters, toString, equals, and hashCode
public class Interview {

    /**
     * Unique identifier for the interview.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The candidate who is participating in the interview.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    /**
     * The employee who is conducting the interview.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private User employee;

    /**
     * The date and time when the interview is scheduled to take place.
     */
    @Column(nullable = false)
    private LocalDateTime datetime;

    /**
     * Any notes or feedback about the interview.
     */
    @Column(length = 140)
    private String notes;

    /**
     * Indicates whether the interview has been completed.
     */
    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean completed = false;
}
