package com.diagnocons.ris.persistence;

import com.diagnocons.ris.domain.dto.Permission;
import com.diagnocons.ris.domain.repository.PermissionRepository;
import com.diagnocons.ris.persistence.crud.PermisoCrudRepository;
import com.diagnocons.ris.persistence.entity.Permiso;
import com.diagnocons.ris.persistence.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PermisoRepository implements PermissionRepository {
    @Autowired
    PermisoCrudRepository permisoCrudRepository;

    @Autowired
    PermissionMapper mapper;

    @Override
    public Optional<List<Permission>> getAll(){
        return Optional.of(mapper.toPermissions((List<Permiso>) permisoCrudRepository.findAll()));
    }

    @Override
    public Optional<Permission> getById(Long id){
        return permisoCrudRepository.findById(id).map(perm -> mapper.toPermission(perm));
    }

    @Override
    public Optional<Permission> getByPermission(String permission){
        return permisoCrudRepository.findByPermiso(permission).map(perm -> mapper.toPermission(perm));
    }

    @Override
    public Permission save(Permission permission) {
        Permiso permiso = mapper.toPermiso(permission);
        return mapper.toPermission(permisoCrudRepository.save(permiso));
    }

    @Override
    public boolean delete(Long id) {
       if(getById(id).isPresent()){
           permisoCrudRepository.deleteById(id);
           return true;
       }
        return false;
    }


}
