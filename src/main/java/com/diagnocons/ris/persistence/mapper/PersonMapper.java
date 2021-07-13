package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.Person;
import com.diagnocons.ris.persistence.entity.Persona;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.swing.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mappings({
            @Mapping(source = "id", target = "idPerson"),
            @Mapping(source = "usuario.id", target = "idUser"),
            @Mapping(source = "estado.id", target = "idState"),
            @Mapping(source = "datosFacturacion.id", target = "idBillingData"),
            @Mapping(source = "patientId", target = "patientId"),
            @Mapping(source = "primerNombre", target = "firstName"),
            @Mapping(source = "segundoNombre", target = "secondName"),
            @Mapping(source = "apellidoPaterno", target = "lastName"),
            @Mapping(source = "apellidoMaterno", target = "motherLastName"),
            @Mapping(source = "fechaNacimiento", target = "birthDay"),
            @Mapping(source = "sexo", target = "gender"),
            @Mapping(source = "curp", target = "curp")
    })
    Person toPerson(Persona persona);
List<Person> toPersons(List<Persona> personas);

    @InheritInverseConfiguration
    @Mapping(target = "estudioList", ignore = true)
    Persona toPersona(Person person);
}
