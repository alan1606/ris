package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.ScheduleDepartment;
import com.diagnocons.ris.domain.repository.ScheduleDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleDepartamentService {
    @Autowired
        private ScheduleDepartmentRepository scheduleDepartamentService;

    public Optional<List<ScheduleDepartment>> getAll(){
        return scheduleDepartamentService.getAll();
    }

    public Optional<List<ScheduleDepartment>> getByIdSchedule(Long idSchedule){
        return scheduleDepartamentService.getAll();
    }

    public Optional<List<ScheduleDepartment>> getByIdDepartment(Long idDepartment){
        return scheduleDepartamentService.getByIdDepartment(idDepartment);
    }

    public Optional<ScheduleDepartment> getById(Long id){
        return scheduleDepartamentService.getById(id);
    }

    public Optional<ScheduleDepartment> getByIdScheduleIdDeparment(Long idSchedule, Long idDepartment){
        return scheduleDepartamentService.getByIdScheduleIdDeparment(idSchedule, idDepartment);
    }

    public ScheduleDepartment save(ScheduleDepartment scheduleDepartment){
        return scheduleDepartamentService.save(scheduleDepartment);
    }

    public boolean delete (Long idScheduleDeparment){
        return scheduleDepartamentService.delete(idScheduleDeparment);
    }

}
