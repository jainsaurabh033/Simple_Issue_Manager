package com.saurabh.servicedesk.ticket.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

@Getter
@Setter
public class UpdateTicketStatusResponse {
    private String message;
}
