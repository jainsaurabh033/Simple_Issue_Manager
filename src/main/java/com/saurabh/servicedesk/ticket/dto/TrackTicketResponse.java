package com.saurabh.servicedesk.ticket.dto;

import com.saurabh.servicedesk.ticket.enums.Priority;
import com.saurabh.servicedesk.ticket.enums.TicketStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackTicketResponse {
    private String title;
    private String description;
    private Priority priority;
    private TicketStatus status;
    private String assignedEngineerName;
}
