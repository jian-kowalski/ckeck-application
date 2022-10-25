package com.jian.kowalski.scheduler.domain.model;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "ttr_schedule")
public class Schedule {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @Embedded
    private HealthCheckConfig checkConfig;

    private Integer runInterval;

    @ManyToOne(optional = false)
    @JoinColumn(name = "app_id", columnDefinition = "char(36)")
    private App app;

    protected Schedule() {
        //For JPA/Hibernate
    }

    public Schedule(UUID id, HealthCheckConfig checkConfig, Integer runInterval, App app) {
        this.id = id;
        this.checkConfig = checkConfig;
        this.runInterval = runInterval;
        this.app = app;
    }

//    public void update(Schedule schedule) {
//
//        this.checkConfig = schedule.getCheckConfig();
//        this.runInterval = schedule.getRunInterval();
//    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HealthCheckConfig getCheckConfig() {
        return checkConfig;
    }

    public Integer getRunInterval() {
        return runInterval;
    }

    public App getApp() {
        return app;
    }
}
