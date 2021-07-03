package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.UserTypePermissionTemplate;
import com.diagnocons.ris.persistence.entity.PlantillaPermisosTipoUsuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserTypeMapper.class, PermissionMapper.class})
public interface UserTypePermissionTemplateMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "idTipoUsuario" , target = "idUserType"),
            @Mapping(source = "idPermiso" , target = "idPermission")
    })
    UserTypePermissionTemplate toUserTypePermissionTemplate(PlantillaPermisosTipoUsuario plantillaPermisosTipoUsuario);
    List<UserTypePermissionTemplate> toUsersTypesPermissionsTemplates(Iterable<PlantillaPermisosTipoUsuario> plantillaPermisosTipoUsuarioList);

    @InheritInverseConfiguration
    PlantillaPermisosTipoUsuario toPlantillaPermisosTipoUsuario (UserTypePermissionTemplate userTypePermissionTemplate);

}
