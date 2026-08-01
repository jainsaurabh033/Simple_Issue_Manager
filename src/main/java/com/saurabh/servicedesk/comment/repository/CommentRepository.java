package com.saurabh.servicedesk.comment.repository;

import com.saurabh.servicedesk.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
