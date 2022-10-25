package com.jian.kowalski.scheduler.domain.service;

import com.jian.kowalski.scheduler.domain.exception.ScheduleNotFoundException;
import com.jian.kowalski.scheduler.domain.model.Schedule;
import com.jian.kowalski.scheduler.domain.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScheduleManagementService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleManagementService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public void delete(Schedule schedule) {
        scheduleRepository.delete(schedule);
    }

    public Schedule create(Schedule schedule) {
        return save(schedule);
    }

    public Schedule update(Schedule schedule) {
        return save(schedule);
    }

    private Schedule save(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public Schedule getById(UUID scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(ScheduleNotFoundException::new);
    }

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }
}
