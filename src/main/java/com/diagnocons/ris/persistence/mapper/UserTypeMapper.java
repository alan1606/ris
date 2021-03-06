package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.UserType;
import com.diagnocons.ris.persistence.entity.TipoUsuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserTypeMapper {

    @Mappings({
            @Mapping(source = "id", target = "idUserType"),
            @Mapping(source = "tipo", target = "type")
    })
    UserType toUserType(TipoUsuario tipoUsuario);
    List<UserType> toUsersTypes(List<TipoUsuario> tiposUsuarios);

    @InheritInverseConfiguration
    @Mapping(target = "usuarios", ignore = true)
    //@Mapping(target = "plantillaPermisosTipoUsuarios", ignore = true)

    TipoUsuario toTipoUsuario(UserType userType);
    List<TipoUsuario> toTiposUsuarios(List<UserType> userTypes);
}
