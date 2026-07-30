package com.saurabh.servicedesk.ticket.dto;

import com.saurabh.servicedesk.ticket.enums.Priority;

public class CreateTicketRequest {
    private String name;
    private String email;
    private String title;
    private String description;
    private Priority priority;
}
