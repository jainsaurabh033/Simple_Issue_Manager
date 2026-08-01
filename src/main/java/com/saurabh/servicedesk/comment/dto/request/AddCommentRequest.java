package com.saurabh.servicedesk.comment.dto.request;

import com.saurabh.servicedesk.comment.enums.CommentAuthor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCommentRequest {
    private CommentAuthor author;
    private String message;
}
