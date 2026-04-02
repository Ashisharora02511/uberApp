package com.java.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @ElementCollection(fetch=FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

}
