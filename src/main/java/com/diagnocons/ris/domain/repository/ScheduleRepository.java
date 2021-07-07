package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.Schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    Optional<List<Schedule>> getAll();
    Optional<Schedule> getById(Long idSchedule);
    Optional<Schedule> getByDay(LocalDate day);
    Schedule save(Schedule schedule);
    boolean delete(Long idShedule);
}
