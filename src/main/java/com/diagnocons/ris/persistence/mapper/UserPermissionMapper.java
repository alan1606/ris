package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.UserPermission;
import com.diagnocons.ris.persistence.entity.PermisoUsuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PermissionMapper.class})
public interface UserPermissionMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "idUsuario" , target = "idUser"),
            @Mapping(source = "idPermiso" , target = "idPermission")
    })
    UserPermission toUserPermission(PermisoUsuario permisoUsuario);
    List<UserPermission> toUsersPermissions(List<PermisoUsuario> permisoUsuarioList);

    @InheritInverseConfiguration
    PermisoUsuario toPermisoUsuario (UserPermission userPermission);
}
