package com.saurabh.servicedesk.comment.dto.response;

import com.saurabh.servicedesk.comment.enums.CommentAuthor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponse {
    private CommentAuthor author;
    private String message;
    private LocalDateTime createdAt;
}
