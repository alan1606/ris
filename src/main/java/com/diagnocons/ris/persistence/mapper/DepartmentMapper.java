package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.Department;
import com.diagnocons.ris.persistence.entity.Departamento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mappings({
            @Mapping(source = "id", target = "idDepartment"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "duracionMinutos", target = "durationInMinutes"),
            @Mapping(source = "horaInicio", target = "startHour"),
            @Mapping(source = "horaFin", target = "endHour")
    })
    Department toDeparment(Departamento departamento);
    List<Department> toDepartments(List<Departamento> departamentos);

    @InheritInverseConfiguration
    @Mappings({
            //@Mapping(target = "conceptoList" , ignore = true),
            @Mapping(target = "limiteEstudiosDiariosList" , ignore = true),
            @Mapping(target = "conceptoList" , ignore = true),
            @Mapping(target = "agendaEnDepartamentoList" , ignore = true),
            @Mapping(target = "citaList" , ignore = true),
            @Mapping(target = "recepcionistaDepartamentoList" , ignore = true)
    })
    Departamento toDepartamento(Department department);
}
