package com.saurabh.servicedesk.comment.controller;

import com.saurabh.servicedesk.comment.dto.request.AddCommentRequest;
import com.saurabh.servicedesk.comment.dto.response.CommentResponse;
import com.saurabh.servicedesk.comment.service.CommentService;
import com.saurabh.servicedesk.ticket.Repository.TicketRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{ticketId}/comments")
    public List<CommentResponse> getComments(@PathVariable Long ticketId){
        return commentService.getComments(ticketId);
    }
}
