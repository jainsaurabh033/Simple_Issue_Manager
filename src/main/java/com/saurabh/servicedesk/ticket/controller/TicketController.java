package com.saurabh.servicedesk.ticket.controller;

import com.saurabh.servicedesk.ticket.TicketService.TicketService;
import com.saurabh.servicedesk.ticket.dto.CreateTicketRequest;
import com.saurabh.servicedesk.ticket.dto.CreateTicketResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
