package com.saurabh.servicedesk.ticket.dto;

import com.saurabh.servicedesk.ticket.enums.Priority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTicketRequest {
    private String name;
    private String email;
    private String title;
    private String description;
    private Priority priority;
}
