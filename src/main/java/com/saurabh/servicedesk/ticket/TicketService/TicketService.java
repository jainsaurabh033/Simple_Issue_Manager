package com.saurabh.servicedesk.ticket.TicketService;

import com.saurabh.servicedesk.engineer.entity.SupportEngineer;
import com.saurabh.servicedesk.engineer.repository.SupportEngineerRepository;
import com.saurabh.servicedesk.ticket.Repository.TicketRepository;
import com.saurabh.servicedesk.ticket.dto.*;
import com.saurabh.servicedesk.ticket.entity.Ticket;
import com.saurabh.servicedesk.ticket.enums.TicketStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final SupportEngineerRepository supportEngineerRepository;

    public TicketService(TicketRepository ticketRepository, SupportEngineerRepository supportEngineerRepository){
        this.ticketRepository = ticketRepository;
        this.supportEngineerRepository = supportEngineerRepository;
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

    public void assignTicket(Long ticketId, AssignTicketRequest request){
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        SupportEngineer engineer = supportEngineerRepository.findById(request.getEngineerId())
                .orElseThrow(() -> new RuntimeException("Support Engineer not found"));

        ticket.setAssigned_engineer_id(engineer.getEngineerId());
        ticket.setAssigned_engineer_name(engineer.getName());
        ticket.setStatus(TicketStatus.IN_PROGRESS);

        ticketRepository.save(ticket);
    }

    public TrackTicketResponse trackTicket(String publicToken){
        Ticket ticket = ticketRepository.findByPublicToken(publicToken)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        TrackTicketResponse response = new TrackTicketResponse();

        response.setTitle(ticket.getTitle());
        response.setDescription(ticket.getDescription());
        response.setPriority(ticket.getPriority());
        response.setStatus(ticket.getStatus());
        response.setAssignedEngineerName(ticket.getAssigned_engineer_name());

        return response;
    }

    public UpdateTicketStatusResponse updateTicketStatus(Long ticketId, UpdateTicketStatusRequest request){
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setStatus(request.getStatus());

        ticketRepository.save(ticket);

        UpdateTicketStatusResponse response = new UpdateTicketStatusResponse();
        response.setMessage("Ticket status updated successfully");

        return response;
    }
}
