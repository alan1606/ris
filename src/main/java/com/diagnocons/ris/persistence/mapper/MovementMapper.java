package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.Movement;
import com.diagnocons.ris.persistence.entity.Movimiento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {

    @Mappings({
            @Mapping(source = "id", target = "idMovement"),
            @Mapping(source = "corte.id", target = "idCut"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "hora", target = "hour"),
            @Mapping(source = "entrada", target = "entry")
    })
    Movement toMovement(Movimiento movimiento);
    List<Movement> toMovements(List<Movimiento> movimientos);

    @InheritInverseConfiguration
    Movimiento toMovimiento(Movement movement);
}
