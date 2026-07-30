package com.saurabh.servicedesk.ticket.controller;

import com.saurabh.servicedesk.ticket.TicketService.TicketService;
import com.saurabh.servicedesk.ticket.dto.AssignTicketRequest;
import com.saurabh.servicedesk.ticket.dto.CreateTicketRequest;
import com.saurabh.servicedesk.ticket.dto.CreateTicketResponse;
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
}
