package com.jiankowalski.application.api.message;

import com.jiankowalski.application.api.model.AppModel;

public interface StreamEvent {
    void sendAppCreated(AppModel appModel);
    void sendAppUpdate(AppModel appModel);
}
