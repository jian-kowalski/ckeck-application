package com.jiankowalski.application.domain.service;

import com.jiankowalski.application.domain.model.App;
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

    public App save(App app){
        return  applicationRepository.save(app);

    }

    public App findById(UUID appId) {
        return applicationRepository.findById(appId).orElseThrow(RuntimeException::new);
    }

    public List<App> getAll() {
        return applicationRepository.findAll();
    }
}
