package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.Schedule;
import com.diagnocons.ris.domain.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public Optional<List<Schedule>> getAll(){
        return scheduleRepository.getAll();
    }

    public Optional<Schedule> getById(Long idSchedule){
        return scheduleRepository.getById(idSchedule);
    }

    public Optional<Schedule> getByDay(LocalDate day){
        return scheduleRepository.getByDay(day);
    }

    public  Schedule save(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public boolean delete(Long idSchedule){
        return scheduleRepository.delete(idSchedule);
    }

}
