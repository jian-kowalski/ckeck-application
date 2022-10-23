package com.jiankowalski.application.infrasture;

import com.jiankowalski.application.api.message.StreamEvent;
import com.jiankowalski.application.api.model.AppModel;
import com.jiankowalski.application.core.AppProperties;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class StreamBridgeImpl implements StreamEvent {

    private final StreamBridge streamBridge;
    private final AppProperties appProperties;


    public StreamBridgeImpl(StreamBridge streamBridge, AppProperties appProperties) {
        this.streamBridge = streamBridge;
        this.appProperties = appProperties;
    }


    @Override
    public void sendAppCreated(AppModel appModel) {
        streamBridge.send(appProperties.getAppCreatedChannel(), appModel);
    }

    @Override
    public void sendAppUpdate(AppModel appModel) {
        streamBridge.send(appProperties.getAppUpdatedChannel(), appModel);
    }
}
