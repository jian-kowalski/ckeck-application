package com.jiankowalski.application.domain.service;

import com.jiankowalski.application.domain.model.App;

public interface AppEventGateway{
    void sendAppCreatedEvent(App app);
    void sendAppUpdatedEvent(App app);
}
