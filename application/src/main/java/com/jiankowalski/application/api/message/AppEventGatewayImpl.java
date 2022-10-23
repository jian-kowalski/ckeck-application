package com.jiankowalski.application.api.message;

import com.jiankowalski.application.api.mapper.AppMapper;
import com.jiankowalski.application.domain.model.App;
import com.jiankowalski.application.domain.service.AppEventGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppEventGatewayImpl implements AppEventGateway {

    private static Logger logger =LoggerFactory.getLogger(AppEventGatewayImpl.class);
    private final AppMapper mapper;
    private final StreamEvent streamEvent;

    public AppEventGatewayImpl(AppMapper mapper, StreamEvent streamEvent) {
        this.mapper = mapper;
        this.streamEvent = streamEvent;
    }

    @Override
    public void sendAppCreatedEvent(App app) {
        logger.info("App criado {} ", app.getId());

        streamEvent.sendAppCreated(mapper.domainToModel(app));
    }

    @Override
    public void sendAppUpdatedEvent(App app) {
        logger.info("App atualizado {}", app.getId());
        streamEvent.sendAppUpdate(mapper.domainToModel(app));
    }
}
