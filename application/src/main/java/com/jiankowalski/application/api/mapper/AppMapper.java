package com.jiankowalski.application.api.mapper;

import com.jiankowalski.application.api.model.AppModel;
import com.jiankowalski.application.api.model.input.AppCreate;
import com.jiankowalski.application.api.model.input.AppUpdate;
import com.jiankowalski.application.domain.model.Application;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AppMapper {
    Application inputToDomain(AppCreate appCreate);

    AppModel domainToModel(Application app);

    void update(@MappingTarget Application byId, AppUpdate app);

    List<AppModel> domainsToModels(List<Application> apps);
}
