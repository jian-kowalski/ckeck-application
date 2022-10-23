package com.jiankowalski.application.domain.service;

import com.jiankowalski.application.domain.model.App;
import com.jiankowalski.application.domain.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppManagementService {

    private final ApplicationRepository applicationRepository;
    private final AppEventGateway eventGateway;

    public AppManagementService(ApplicationRepository applicationRepository, AppEventGateway eventGateway) {
        this.applicationRepository = applicationRepository;
        this.eventGateway = eventGateway;
    }

    public App create(App app){
        var appCreated = save(app);
        eventGateway.sendAppCreatedEvent(appCreated);
        return appCreated;
    }
    private App save(App app){
        return applicationRepository.save(app);
    }

    public App findById(UUID appId) {
        return applicationRepository.findById(appId).orElseThrow(RuntimeException::new);
    }

    public List<App> getAll() {
        return applicationRepository.findAll();
    }

    public App update(App app) {
        var appUpdated = save(app);
        eventGateway.sendAppUpdatedEvent(appUpdated);
        return appUpdated;
    }
}
