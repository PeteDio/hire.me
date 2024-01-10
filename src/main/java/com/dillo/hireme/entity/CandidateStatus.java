package com.dillo.hireme.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a possible status for a candidate in the recruitment process.
 */
@Entity
@Table(name = "candidate_status")
@Data // Generates getters, setters, toString, equals, and hashCode
public class CandidateStatus {

    /**
     * Unique identifier for the candidate status.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the candidate status, which must be unique.
     */
    @Column(unique = true, nullable = false)
    private String name;
}