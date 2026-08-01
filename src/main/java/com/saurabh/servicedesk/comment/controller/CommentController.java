package com.saurabh.servicedesk.comment.controller;

import com.saurabh.servicedesk.comment.dto.request.AddCommentRequest;
import com.saurabh.servicedesk.comment.dto.response.CommentResponse;
import com.saurabh.servicedesk.comment.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/{ticketId}/comments")
    public CommentResponse addComment(@PathVariable Long ticketId, @RequestBody AddCommentRequest request){
        return commentService.addComment(ticketId, request);
    }
}
