package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.ReceptionistDepartment;
import com.diagnocons.ris.persistence.entity.RecepcionistaDepartamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecepcionistDepartmentMapper {

    @Mappings({
            @Mapping(source = "id", target = "idReceptionistDepartment"),
            @Mapping(source = "recepcionista.id", target = "idReceptionist"),
            @Mapping(source = "departamento.id", target = "idDepartment"),
            @Mapping(source = "activo", target = "active")
    })
    ReceptionistDepartment toRecepcionistDepartment(RecepcionistaDepartamento recepcionistaDepartamento);
    List<ReceptionistDepartment> toReceptionistsDepartments(List<RecepcionistaDepartamento> recepcionistaDepartamentoList);


}
