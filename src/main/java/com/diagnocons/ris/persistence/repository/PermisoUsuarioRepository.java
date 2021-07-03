package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.UserPermission;
import com.diagnocons.ris.domain.repository.UserPermissionRepository;
import com.diagnocons.ris.persistence.crud.PermisoUsuarioCrudRepository;
import com.diagnocons.ris.persistence.entity.PermisoUsuario;
import com.diagnocons.ris.persistence.mapper.UserPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PermisoUsuarioRepository implements UserPermissionRepository {
    @Autowired
    PermisoUsuarioCrudRepository permisoUsuarioCrudRepository;

    @Autowired
    UserPermissionMapper mapper;

    @Override
    public Optional<List<UserPermission>> getByIdPermission(Long idPermission) {
        return permisoUsuarioCrudRepository.findByIdPermiso(idPermission).map(list -> mapper.toUsersPermissions(list));
    }

    @Override
    public Optional<List<UserPermission>> getByIdUser(Long idUserType) {
        Optional<List<PermisoUsuario>> encontrados = permisoUsuarioCrudRepository.findByIdUsuario(idUserType);
        return encontrados.map(list -> mapper.toUsersPermissions(list));
    }

    public Optional<UserPermission> getById(Long id) {
        return permisoUsuarioCrudRepository.findById(id).map(plant -> mapper.toUserPermission(plant));
    }

    @Override
    public Optional<List<UserPermission>> getAll() {
        List<PermisoUsuario> todos = (List<PermisoUsuario>) permisoUsuarioCrudRepository.findAll();
        return Optional.of(mapper.toUsersPermissions(todos));
    }

    @Override
    public UserPermission save(UserPermission userPermission) {
        PermisoUsuario plantilla = mapper.toPermisoUsuario(userPermission);
        return mapper.toUserPermission(permisoUsuarioCrudRepository.save(plantilla));
    }

    @Override
    public boolean delete(Long id) {
        if(getById(id).isPresent()){
            permisoUsuarioCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
