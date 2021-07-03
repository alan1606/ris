package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.UserPermission;
import com.diagnocons.ris.domain.repository.UserPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPermissionService {
    @Autowired
    private UserPermissionRepository userPermissionRepository;

    public Optional<List<UserPermission>> getByIdPermission(Long idPermission){
        return userPermissionRepository.getByIdPermission(idPermission);
    }

    public Optional<List<UserPermission>> getByIdUser(Long idUser){
        return userPermissionRepository.getByIdUser(idUser);
    }

    public Optional<UserPermission> getById(Long id){
        return userPermissionRepository.getById(id);
    }

    public Optional<List<UserPermission>> getAll(){
        return userPermissionRepository.getAll();
    }

    public UserPermission save(UserPermission userPermission){
        return userPermissionRepository.save(userPermission);
    }

    public boolean delete(Long id){
        return userPermissionRepository.delete(id);
    }
}
