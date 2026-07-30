package com.saurabh.servicedesk.ticket.TicketService;

import com.saurabh.servicedesk.ticket.Repository.TicketRepository;
import com.saurabh.servicedesk.ticket.dto.CreateTicketRequest;
import com.saurabh.servicedesk.ticket.dto.CreateTicketResponse;
import com.saurabh.servicedesk.ticket.entity.Ticket;
import com.saurabh.servicedesk.ticket.enums.TicketStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public CreateTicketResponse createTicket(CreateTicketRequest request){
        Ticket ticket = new Ticket();

        ticket.setName(request.getName());
        ticket.setEmail(request.getEmail());
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setPriority(request.getPriority());

        ticket.setStatus(TicketStatus.OPEN);
        ticket.setPublicToken(UUID.randomUUID().toString());
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());

        ticket = ticketRepository.save(ticket);

        ticket.setTicketId("TKT-" + (1000 + ticket.getId()));

        ticketRepository.save(ticket);

        CreateTicketResponse response = new CreateTicketResponse();

        response.setTicketId(ticket.getTicketId());
        response.setTrackingLink("http://localhost:3000/ticket/" + ticket.getPublicToken());

        response.setMessage("Ticket created Successfully");
        return response;
    }
}
