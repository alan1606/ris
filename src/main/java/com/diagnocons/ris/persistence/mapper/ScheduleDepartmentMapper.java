package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.ScheduleDepartment;
import com.diagnocons.ris.persistence.entity.AgendaEnDepartamento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleDepartmentMapper {

    @Mappings({
            @Mapping(source = "id", target = "idScheduleDepartment"),
            @Mapping(source = "agenda.id", target = "idSchedule"),
            @Mapping(source = "departamento.id", target = "idDepartment"),
            @Mapping(source = "horaInicio", target = "startHour"),
            @Mapping(source = "horaFin", target = "endHour")
    })
    ScheduleDepartment toScheduleDepartment(AgendaEnDepartamento agendaEnDepartamento);
    List<ScheduleDepartment> toSchedulesDeparments(List<AgendaEnDepartamento> agendasEnDepartamentos);

    @InheritInverseConfiguration
    AgendaEnDepartamento toAgendaEnDepartamento(ScheduleDepartment scheduleDepartment);
}
