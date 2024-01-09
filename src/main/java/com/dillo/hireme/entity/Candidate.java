package com.dillo.hireme.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String jobTitle;

    @Column
    private String bio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_status_id")
    private CandidateStatus candidateStatus;
}
