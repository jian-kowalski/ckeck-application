package com.jiankowalski.application.api.controller;


import com.jiankowalski.application.api.mapper.AppMapper;
import com.jiankowalski.application.api.model.AppModel;
import com.jiankowalski.application.api.model.input.AppCreate;
import com.jiankowalski.application.api.model.input.AppUpdate;
import com.jiankowalski.application.domain.service.AppManagementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/apps")
public class AppController {
    private final AppManagementService appManagementService;

    private final AppMapper appMapper;

    public AppController(AppManagementService appManagementService, AppMapper appMapper) {
        this.appManagementService = appManagementService;
        this.appMapper = appMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppModel create(@RequestBody @Valid AppCreate appCreate) {
        var app = appManagementService.save(appMapper.inputToDomain(appCreate));
        return appMapper.domainToModel(app);
    }

    @PutMapping("/{appId}")
    public AppModel update(@PathVariable UUID appId,
                           @RequestBody @Valid AppUpdate appUpdate) {
        var appSalved = appManagementService.findById(appId);
        appMapper.update(appSalved, appUpdate);
        return appMapper.domainToModel(appManagementService.save(appSalved));
    }

    @GetMapping("/{appId}")
    public AppModel getById(@PathVariable UUID appId) {
        return appMapper.domainToModel(appManagementService.findById(appId));
    }

    @GetMapping
    public List<AppModel> getAll() {
        return appMapper.domainsToModels(appManagementService.getAll());
    }
}
