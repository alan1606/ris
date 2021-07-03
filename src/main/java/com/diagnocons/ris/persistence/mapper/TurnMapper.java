package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.Turn;
import com.diagnocons.ris.persistence.entity.Turno;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurnMapper {

    @Mappings({
            @Mapping(source = "id", target = "idTurn"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "horaInicio", target = "startTime"),
            @Mapping(source = "horaFin", target = "endTime")
    })
    Turn toTurn(Turno turno);
    List<Turn> toTurns(List<Turno> turnos);

    @InheritInverseConfiguration
    @Mapping(target = "corteList", ignore = true)
    Turno toTurno(Turn turn);
}
