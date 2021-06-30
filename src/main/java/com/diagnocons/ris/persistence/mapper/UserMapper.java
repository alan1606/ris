package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.User;
import com.diagnocons.ris.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserTypeMapper.class)
public interface UserMapper {
    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "tipoUsuario", target = "userType"),
            @Mapping(source = "nick", target = "nickname"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
            @Mapping(source = "activeUser", target = "active"),
            @Mapping(source = "replaceId", target = "string"),
            @Mapping(source = "validated", target = "validated")
    })
    User toUser (Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    @Mapping(target = "pass", ignore = true)
    @Mapping(target = "nip", ignore = true)
    @Mapping(target = "permisoUsuario", ignore = true)
    @Mapping(target = "fotoUsuario", ignore = true)
    @Mapping(target = "personaList", ignore = true)
    @Mapping(target = "medicoRadiologoList", ignore = true)
    @Mapping(target = "tecnicoList", ignore = true)
    @Mapping(target = "recepcionistaList", ignore = true)
    @Mapping(target = "idTipoUsuario", ignore = true)
    Usuario toUsuario(User user);
}
