package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.User;
import com.diagnocons.ris.domain.dto.UserPhoto;
import com.diagnocons.ris.persistence.entity.FotoUsuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UserPhotoMapper {
    @Mappings({
            @Mapping(source = "id", target = "idUserPhoto"),
            @Mapping(source = "usuario.id", target = "idUser"),
            @Mapping(source = "ruta", target = "path")
    })
    UserPhoto toUserPhoto(FotoUsuario fotoUsuario);
    List<UserPhoto> toUsersPhotos(List<FotoUsuario> fotoUsuarioList);

    @InheritInverseConfiguration
    FotoUsuario toFotoUsuario(UserPhoto userPhoto);
}
