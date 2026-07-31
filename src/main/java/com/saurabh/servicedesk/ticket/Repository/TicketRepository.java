package com.saurabh.servicedesk.ticket.Repository;

import com.saurabh.servicedesk.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByPublicToken(String publicToken);
}
