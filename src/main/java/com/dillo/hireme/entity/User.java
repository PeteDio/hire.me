package com.dillo.hireme.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private Role role;
}