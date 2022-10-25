package com.jian.kowalski.scheduler.api.controller;

import com.jian.kowalski.scheduler.api.mapper.ScheduleMapper;
import com.jian.kowalski.scheduler.api.model.ScheduleModel;
import com.jian.kowalski.scheduler.api.model.input.ScheduleCreate;
import com.jian.kowalski.scheduler.api.model.input.ScheduleUpdate;
import com.jian.kowalski.scheduler.domain.model.Schedule;
import com.jian.kowalski.scheduler.domain.service.ScheduleManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/schedules")
public class ScheduleController {

    private final ScheduleManagementService scheduleManagementService;
    private final ScheduleMapper mapper;

    public ScheduleController(ScheduleManagementService scheduleManagementService, ScheduleMapper mapper) {
        this.scheduleManagementService = scheduleManagementService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleModel create(@RequestBody @Valid ScheduleCreate request) {
        Schedule schedule =  mapper.inputToDomain(request);
        return mapper.domainToModel(scheduleManagementService.create(schedule));
    }

    @PutMapping("/{scheduleId}")
    public ScheduleModel update(@PathVariable UUID scheduleId,
                                @RequestBody @Valid ScheduleUpdate request) {
        Schedule schedule = scheduleManagementService.getById(scheduleId);
        mapper.update(schedule, request);
        return mapper.domainToModel(scheduleManagementService.update(schedule));
    }

    @DeleteMapping("/{scheduleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID scheduleId) {
        Schedule schedule = scheduleManagementService.getById(scheduleId);
        scheduleManagementService.delete(schedule);
    }

    @GetMapping("/{scheduleId}")
    public ScheduleModel getById(@PathVariable UUID scheduleId) {
        return mapper.domainToModel(scheduleManagementService.getById(scheduleId));
    }

    @GetMapping
    public List<ScheduleModel> getAll() {
        return mapper.domainsToModels(scheduleManagementService.getAll());
    }

//    private Schedule toDomain(ScheduleCreate request) {
//        HealthCheckConfigModel checkConfig = request.getCheckConfig();
//        return Schedule.builder()
//                .runInterval(request.getRunInterval())
//                .app(findAppById(request.getAppId()))
//                .checkConfig(HealthCheckConfig.builder()
//                        .type(checkConfig.getType())
//                        .timeout(checkConfig.getTimeout())
//                        .build())
//                .build();
//    }
//
//    private Schedule toDomain(UUID scheduleId, ScheduleUpdateRequest request) {
//        HealthCheckConfigModel checkConfig = request.getCheckConfig();
//        return Schedule.builder()
//                .id(scheduleId)
//                .app(findAppById(request.getAppId()))
//                .runInterval(request.getRunInterval())
//                .checkConfig(HealthCheckConfig.builder()
//                        .type(checkConfig.getType())
//                        .timeout(checkConfig.getTimeout())
//                        .build())
//                .build();
//    }

//    private App findAppById(UUID appId) {
//        return apps.findById(appId).orElseThrow(AppNotFoundException::new);
//    }

}

