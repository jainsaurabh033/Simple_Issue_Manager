package com.saurabh.servicedesk.engineer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSupportEngineerResponse {
    Long engineerId;
    String username;
    String password;
    String message;
}
