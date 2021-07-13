package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.State;
import com.diagnocons.ris.persistence.entity.Estado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StateMapper {

    @Mappings({
            @Mapping(source = "id", target = "idState"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "abreviatura", target = "nomenclature"),
            @Mapping(source = "activo", target = "active"),
    })
    State toState(Estado estado);
    List<State> toStates(List<Estado> estados);

    @InheritInverseConfiguration
    @Mapping(target="personaList", ignore = true)
    Estado toEstado(State state);
}
