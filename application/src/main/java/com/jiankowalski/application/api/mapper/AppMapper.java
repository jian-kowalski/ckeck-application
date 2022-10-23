package com.jiankowalski.application.api.mapper;

import com.jiankowalski.application.api.model.AppModel;
import com.jiankowalski.application.api.model.input.AppCreate;
import com.jiankowalski.application.api.model.input.AppUpdate;
import com.jiankowalski.application.domain.model.App;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AppMapper {
    App inputToDomain(AppCreate appCreate);

    AppModel domainToModel(App app);

    void update(@MappingTarget App byId, AppUpdate app);

    List<AppModel> domainsToModels(List<App> apps);
}
