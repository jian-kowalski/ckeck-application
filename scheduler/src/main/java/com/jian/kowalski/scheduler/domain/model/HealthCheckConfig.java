package com.jian.kowalski.scheduler.domain.model;


import javax.persistence.Embeddable;

@Embeddable
public class HealthCheckConfig {
    private HealthTypeEnum type;
    private Integer timeout;

    protected HealthCheckConfig() {
        //JPA Hibernate
    }

    public HealthCheckConfig(HealthTypeEnum type, Integer timeout) {
        this.type = type;
        this.timeout = timeout;
    }

    public HealthTypeEnum getType() {
        return type;
    }

    public Integer getTimeout() {
        return timeout;
    }
}


