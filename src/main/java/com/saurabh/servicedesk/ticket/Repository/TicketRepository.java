package com.saurabh.servicedesk.ticket.Repository;

import com.saurabh.servicedesk.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
