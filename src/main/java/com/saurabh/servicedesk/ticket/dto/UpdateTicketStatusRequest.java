package com.saurabh.servicedesk.ticket.dto;

import com.saurabh.servicedesk.ticket.enums.TicketStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTicketStatusRequest {
    private TicketStatus status;
}
