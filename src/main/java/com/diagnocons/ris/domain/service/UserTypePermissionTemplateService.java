package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.UserTypePermissionTemplate;
import com.diagnocons.ris.domain.repository.UserTypePermissionTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypePermissionTemplateService {
    @Autowired
    private UserTypePermissionTemplateRepository userTypePermissionTemplateRepository;

    public Optional<List<UserTypePermissionTemplate>> getByIdPermission(Long idPermission){
        return userTypePermissionTemplateRepository.getByIdPermission(idPermission);
    }

    public Optional<List<UserTypePermissionTemplate>> getByIdUserType(Long idUserType){
        return userTypePermissionTemplateRepository.getByIdUserType(idUserType);
    }

    public Optional<UserTypePermissionTemplate> getById(Long id){
        return userTypePermissionTemplateRepository.getById(id);
    }

    public Optional<List<UserTypePermissionTemplate>> getAll(){
        return userTypePermissionTemplateRepository.getAll();
    }

    public UserTypePermissionTemplate save(UserTypePermissionTemplate userTypePermissionTemplate){
        return userTypePermissionTemplateRepository.save(userTypePermissionTemplate);
    }

    public boolean delete(Long id){
        return userTypePermissionTemplateRepository.delete(id);
    }
}
