package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.Permission;
import com.diagnocons.ris.domain.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    public Optional<List<Permission>> getAll(){
        return permissionRepository.getAll();
    }

    public Optional<Permission> getById(Long id){
        return permissionRepository.getById(id);
    }

    public Optional<Permission> getByPermission(String permission){
        return permissionRepository.getByPermission(permission);
    }

    public Permission save(Permission permission){
        return permissionRepository.save(permission);
    }

    public boolean delete(Long id){
        return permissionRepository.delete(id);
    }
}
