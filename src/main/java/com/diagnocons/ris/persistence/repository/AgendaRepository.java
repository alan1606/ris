package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.Schedule;
import com.diagnocons.ris.domain.repository.ScheduleRepository;
import com.diagnocons.ris.persistence.crud.AgendaCrudRepository;
import com.diagnocons.ris.persistence.entity.Agenda;
import com.diagnocons.ris.persistence.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class AgendaRepository implements ScheduleRepository {
    @Autowired
    private AgendaCrudRepository agendaCrudRepository;

    @Autowired
    private ScheduleMapper mapper;


    @Override
    public Optional<List<Schedule>> getAll() {
        List<Agenda> agendas = (List<Agenda>) agendaCrudRepository.findAll();
        return Optional.of(mapper.toSchedules(agendas));
    }

    @Override
    public Optional<Schedule> getById(Long idSchedule) {
        return agendaCrudRepository.findById(idSchedule).map(agenda -> mapper.toSchedule(agenda));
    }

    @Override
    public Optional<Schedule> getByDay(LocalDate day) {
        return agendaCrudRepository.findByDia(day).map(agenda -> mapper.toSchedule(agenda));
    }

    @Override
    public Schedule save(Schedule schedule) {
        Agenda agenda = mapper.toAgenda(schedule);
        return mapper.toSchedule(agendaCrudRepository.save(agenda));
    }

    @Override
    public boolean delete(Long idShedule) {
        if (getById(idShedule).isPresent()) {
            agendaCrudRepository.deleteById(idShedule);
            return true;
        }
        return false;
    }
}
