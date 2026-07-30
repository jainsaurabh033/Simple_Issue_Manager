package com.saurabh.servicedesk.ticket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTicketResponse {

    private String ticketId;
    private String trackingLink;
    private String message;
}
