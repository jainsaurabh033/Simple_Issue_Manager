package com.saurabh.servicedesk.engineer.controller;

import com.saurabh.servicedesk.engineer.service.SupportEngineerService;
import com.saurabh.servicedesk.engineer.dto.CreateSupportEngineerRequest;
import com.saurabh.servicedesk.engineer.dto.CreateSupportEngineerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/support-engineers")
public class SupportEngineerController {

    private final SupportEngineerService supportEngineerService;

    public SupportEngineerController(SupportEngineerService supportEngineerService){
        this.supportEngineerService = supportEngineerService;
    }

    @PostMapping
    public CreateSupportEngineerResponse createSupportEngineer(@RequestBody CreateSupportEngineerRequest request){
        return supportEngineerService.createSupportEngineer(request);
    }
}
