package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.Cut;
import com.diagnocons.ris.persistence.entity.Corte;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CutMapper {
    @Mappings({
            @Mapping(source = "id", target = "idCut"),
            @Mapping(source = "turno.id", target = "idTurn"),
            @Mapping(source = "recepcionista.id", target = "idReceptionist"),
            @Mapping(source = "dia", target = "day"),
            @Mapping(source = "fondoCaja", target = "cashFound")
    })
    Cut toCut(Corte corte);
    List<Cut> toCuts(List<Corte> cortes);

    @InheritInverseConfiguration
    @Mappings(
            @Mapping(target = "movimientoList", ignore = true)
    )
    Corte toCorte(Cut cut);
}
