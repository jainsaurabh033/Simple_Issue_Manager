package com.saurabh.servicedesk.comment.service;

import com.saurabh.servicedesk.comment.dto.request.AddCommentRequest;
import com.saurabh.servicedesk.comment.dto.response.CommentResponse;
import com.saurabh.servicedesk.comment.entity.Comment;
import com.saurabh.servicedesk.comment.repository.CommentRepository;
import com.saurabh.servicedesk.ticket.Repository.TicketRepository;
import com.saurabh.servicedesk.ticket.entity.Ticket;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private TicketRepository ticketRepository;

    public CommentService(CommentRepository commentRepository, TicketRepository ticketRepository){
        this.commentRepository = commentRepository;
        this.ticketRepository = ticketRepository;
    }

    public CommentResponse addComment(Long ticketId, AddCommentRequest request){
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        Comment comment = new Comment();

        comment.setTicketId(ticket.getId());
        comment.setAuthor(request.getAuthor());
        comment.setMessage(request.getMessage());
        comment.setCreatedAt(LocalDateTime.now());

        commentRepository.save(comment);

        CommentResponse response = new CommentResponse();

        response.setAuthor(comment.getAuthor());
        response.setMessage(comment.getMessage());
        response.setCreatedAt(comment.getCreatedAt());

        return response;
    }

    public List<CommentResponse> getComments(Long ticketId){
        ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        List<Comment> comments = commentRepository.findByTicketIdOrderByCreatedAtAsc(ticketId);

        List<CommentResponse> response = new ArrayList<>();

        for(Comment comment : comments){
            CommentResponse commentResponse = new CommentResponse();

            commentResponse.setAuthor(comment.getAuthor());
            commentResponse.setMessage(comment.getMessage());
            commentResponse.setCreatedAt(comment.getCreatedAt());

            response.add(commentResponse);
        }

        return response;
    }
}
