package com.jiankowalski.application.core;

import org.springframework.stereotype.Component;

@Component
public class AppProperties {
    private static final String APP_CREATED_CHANNEL = "appCreatedSupplier-out-0";
    private static final String APP_UPDATED_CHANNEL = "appUpdatedSupplier-out-0";

    public String getAppCreatedChannel() {
        return APP_CREATED_CHANNEL;
    }

    public String getAppUpdatedChannel() {
        return APP_UPDATED_CHANNEL;
    }
}
