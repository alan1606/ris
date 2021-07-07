package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.ScheduleDepartment;
import com.diagnocons.ris.domain.repository.ScheduleDepartmentRepository;
import com.diagnocons.ris.persistence.crud.AgendaDepartamentoCrudRepository;
import com.diagnocons.ris.persistence.entity.AgendaEnDepartamento;
import com.diagnocons.ris.persistence.mapper.ScheduleDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AgendaEnDepartamentoRepository implements ScheduleDepartmentRepository {
    @Autowired
    private AgendaDepartamentoCrudRepository agendaDepartamentoCrudRepository;

    @Autowired
    private ScheduleDepartmentMapper mapper;

    @Override
    public Optional<List<ScheduleDepartment>> getAll() {
        List<AgendaEnDepartamento> lista = (List<AgendaEnDepartamento>) agendaDepartamentoCrudRepository.findAll();
        return Optional.of(mapper.toSchedulesDeparments(lista));
    }

    @Override
    public Optional<List<ScheduleDepartment>> getByIdSchedule(Long idSchedule) {
        return agendaDepartamentoCrudRepository.findByIdDepartamento(idSchedule).map(agenda -> mapper.toSchedulesDeparments(agenda));
    }

    @Override
    public Optional<List<ScheduleDepartment>> getByIdDepartment(Long idDepartment) {
        return agendaDepartamentoCrudRepository.findByIdDepartamento(idDepartment).map(agenda -> mapper.toSchedulesDeparments(agenda));
    }

    @Override
    public Optional<ScheduleDepartment> getById(Long id) {
        return agendaDepartamentoCrudRepository.findById(id).map(agenda -> mapper.toScheduleDepartment(agenda));
    }

    @Override
    public Optional<ScheduleDepartment> getByIdScheduleIdDeparment(Long idSchedule, Long idDepartment) {
        return agendaDepartamentoCrudRepository.findByIdAgendaIdDepartamento(idSchedule, idDepartment).map(agenda -> mapper.toScheduleDepartment(agenda));
    }

    @Override
    public ScheduleDepartment save(ScheduleDepartment scheduleDepartment) {
        AgendaEnDepartamento agenda = mapper.toAgendaEnDepartamento(scheduleDepartment);
        return mapper.toScheduleDepartment(agendaDepartamentoCrudRepository.save(agenda));
    }

    @Override
    public boolean delete(Long idScheduleDeparment) {
        if(getById(idScheduleDeparment).isPresent()){
            agendaDepartamentoCrudRepository.deleteById(idScheduleDeparment);
            return true;
        }
        return false;
    }
}
