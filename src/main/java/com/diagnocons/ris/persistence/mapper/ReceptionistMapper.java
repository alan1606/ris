package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.Receptionist;
import com.diagnocons.ris.persistence.entity.Recepcionista;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface ReceptionistMapper {

    @Mappings({
            @Mapping(source = "id", target = "idRecepcionist"),
            @Mapping(source = "usuario.id", target = "idUser"),
            @Mapping(source = "primerNombre", target = "firstName"),
            @Mapping(source = "segundoNombre", target = "secondName"),
            @Mapping(source = "apellidoPaterno", target = "lastName"),
            @Mapping(source = "apellidoMaterno", target = "motherLastName"),
            @Mapping(source = "sexo", target = "gender"),
            @Mapping(source = "fechaNacimiento", target= "birthDay")
    })
    Receptionist toRecepcionist(Recepcionista recepcionista);
    List<Receptionist> toRecepcionists(List<Recepcionista> recepcionistas);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "usuario", ignore = true),
            @Mapping(target = "corteList", ignore = true),
            @Mapping(target = "recepcionistaDepartamentoList", ignore = true),
            @Mapping(target = "citaList", ignore = true)
    })
    Recepcionista toRecepcionista(Receptionist receptionist);
}
