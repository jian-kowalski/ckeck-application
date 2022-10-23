package com.jiankowalski.application.domain.service;

import com.jiankowalski.application.domain.model.Application;
import com.jiankowalski.application.domain.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppManagementService {

    private final ApplicationRepository applicationRepository;

    public AppManagementService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application save(Application app){
        return  applicationRepository.save(app);

    }

    public Application findById(UUID appId) {
        return applicationRepository.findById(appId).orElseThrow(() -> new RuntimeException());
    }

    public List<Application> getAll() {
        return applicationRepository.findAll();
    }
}
