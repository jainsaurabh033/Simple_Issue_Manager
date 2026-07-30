package com.saurabh.servicedesk.engineer.service;

import com.saurabh.servicedesk.engineer.repository.SupportEngineerRepository;
import com.saurabh.servicedesk.engineer.dto.CreateSupportEngineerRequest;
import com.saurabh.servicedesk.engineer.dto.CreateSupportEngineerResponse;
import com.saurabh.servicedesk.engineer.entity.SupportEngineer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SupportEngineerService {
    private final SupportEngineerRepository supportEngineerRepository;

    public SupportEngineerService(SupportEngineerRepository supportEngineerRepository){
        this.supportEngineerRepository = supportEngineerRepository;
    }


    public CreateSupportEngineerResponse createSupportEngineer(CreateSupportEngineerRequest request){
        SupportEngineer engineer = new SupportEngineer();

        engineer.setName(request.getName());
        engineer.setEmail(request.getEmail());
        engineer.setCreatedAt(LocalDateTime.now());
        engineer.setUsername(UUID.randomUUID().toString().substring(0,8));
        engineer.setPassword(UUID.randomUUID().toString().substring(0,8));

        engineer = supportEngineerRepository.save(engineer);

        engineer.setEngineerId("Eng-" + (1000 + engineer.getId()));

        supportEngineerRepository.save(engineer);

        CreateSupportEngineerResponse response = new CreateSupportEngineerResponse();
        response.setEngineerId(engineer.getId());
        response.setUsername(engineer.getUsername());
        response.setPassword(engineer.getPassword());
        response.setMessage("SupportEngineer credential created Successfully");

        return response;
    }
}
