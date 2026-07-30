package com.saurabh.servicedesk.ticket.dto;

public class AssignTicketRequest {

    private Long engineerId;

    public Long getEngineerId(){
        return engineerId;
    }

    public void setEngineerId(Long engineerId){
        this.engineerId = engineerId;
    }
}
