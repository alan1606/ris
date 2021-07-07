package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.ScheduleDepartment;

import java.util.List;
import java.util.Optional;

public interface ScheduleDepartmentRepository {
    Optional<List<ScheduleDepartment>> getAll();
    Optional<List<ScheduleDepartment>> getByIdSchedule(Long idSchedule);
    Optional<List<ScheduleDepartment>> getByIdDepartment(Long idDepartment);
    Optional<ScheduleDepartment> getById(Long id);
    Optional<ScheduleDepartment> getByIdScheduleIdDeparment(Long idSchedule, Long idDepartment);
    ScheduleDepartment save(ScheduleDepartment scheduleDepartment);
    boolean delete (Long idScheduleDeparment);

}
