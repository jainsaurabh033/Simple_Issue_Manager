package com.saurabh.servicedesk.ticket.controller;

import com.saurabh.servicedesk.ticket.TicketService.TicketService;
import com.saurabh.servicedesk.ticket.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping
    public CreateTicketResponse createTicket(@RequestBody CreateTicketRequest request){
        return ticketService.createTicket(request);
    }

    @PutMapping("/{ticketId}/assign")
    public String assignTicket(@PathVariable Long ticketId, @RequestBody AssignTicketRequest request){
        ticketService.assignTicket(ticketId, request);
        return "Ticket assigned successfully";
    }

    @GetMapping("/track/{publicToken}")
    public TrackTicketResponse trackTicket(@PathVariable String publicToken){
        return ticketService.trackTicket(publicToken);
    }

    @PutMapping("/{ticketId}/status")
    public UpdateTicketStatusResponse updateTicketStatus(@PathVariable Long ticketId, @RequestBody UpdateTicketStatusRequest request){
        return ticketService.updateTicketStatus(ticketId, request);
    }
}