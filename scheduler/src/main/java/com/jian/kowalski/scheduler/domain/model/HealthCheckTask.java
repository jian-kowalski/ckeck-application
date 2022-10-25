package com.jian.kowalski.scheduler.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;


public class HealthCheckTask {
    private UUID id;
    private App app;
    private HealthCheckConfig checkConfig;
    private OffsetDateTime createdAt;
    private UUID scheduleId;

    public HealthCheckTask(UUID id, App app, HealthCheckConfig checkConfig, OffsetDateTime createdAt, UUID scheduleId) {
        this.id = id;
        this.app = app;
        this.checkConfig = checkConfig;
        this.createdAt = createdAt;
        this.scheduleId = scheduleId;
    }

    public static HealthCheckTask of(Schedule schedule) {

        return new HealthCheckTask(UUID.randomUUID(),
                schedule.getApp(),
                schedule.getCheckConfig(),
                OffsetDateTime.now(),
                schedule.getId() );
    }
}
