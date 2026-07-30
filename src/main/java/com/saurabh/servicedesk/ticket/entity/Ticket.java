package com.saurabh.servicedesk.ticket.entity;

import com.saurabh.servicedesk.ticket.enums.Priority;
import com.saurabh.servicedesk.ticket.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticketId;
    private String publicToken;
    private String name;
    private String email;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    private String assigned_engineer_id;
    private String assigned_engineer_name;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
