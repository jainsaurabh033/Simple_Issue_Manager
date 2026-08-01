package com.saurabh.servicedesk.comment.entity;

import com.saurabh.servicedesk.comment.enums.CommentAuthor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long ticketId;

    @Enumerated(EnumType.STRING)
    CommentAuthor author;
    String message;
    LocalDateTime createdAt;
}
