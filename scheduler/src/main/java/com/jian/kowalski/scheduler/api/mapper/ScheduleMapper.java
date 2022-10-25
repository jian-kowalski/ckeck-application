package com.jian.kowalski.scheduler.api.mapper;

import com.jian.kowalski.scheduler.api.model.ScheduleModel;
import com.jian.kowalski.scheduler.api.model.input.ScheduleCreate;
import com.jian.kowalski.scheduler.api.model.input.ScheduleUpdate;
import com.jian.kowalski.scheduler.domain.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    Schedule inputToDomain(ScheduleCreate request);

    ScheduleModel domainToModel(Schedule schedule);

    void update(@MappingTarget Schedule schedule, ScheduleUpdate request);

    List<ScheduleModel> domainsToModels(List<Schedule> all);
}
