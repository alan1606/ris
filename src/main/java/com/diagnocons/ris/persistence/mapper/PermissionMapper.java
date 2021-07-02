package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.Permission;
import com.diagnocons.ris.persistence.entity.Permiso;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface  PermissionMapper {
    @Mappings({
            @Mapping(source = "id", target = "idPermission"),
            @Mapping(source = "permiso", target = "permission")
    })
    Permission toPermission (Permiso permiso);
    List<Permission> toPermissions(List<Permiso> permisos);

    @InheritInverseConfiguration
    Permiso toPermiso(Permission permission);

}
