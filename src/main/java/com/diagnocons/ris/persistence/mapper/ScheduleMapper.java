package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.Schedule;
import com.diagnocons.ris.persistence.entity.Agenda;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    @Mappings({
            @Mapping(source = "id" , target = "idSchedule"),
            @Mapping(source = "dia" , target = "day"),
    })
    Schedule toSchedule(Agenda agenda);
    List<Schedule> toSchedules(List<Agenda> agendas);

    @InheritInverseConfiguration
    @Mapping(target = "citaList", ignore = true)
    @Mapping(target = "agendaEnDepartamentoList", ignore = true)
    Agenda toAgenda(Schedule schedule);


}
