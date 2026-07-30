package com.saurabh.servicedesk.engineer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class SupportEngineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String engineerId;
    String name;
    String email;
    String username;
    String password;
    LocalDateTime createdAt;
}
