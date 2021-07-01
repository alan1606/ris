package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.UserType;
import com.diagnocons.ris.domain.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {
    @Autowired
    UserTypeRepository userTypeRepository;

    public Optional<List<UserType>> getAll(){
        return userTypeRepository.getAll();
    }

    public Optional<UserType> getById(Long id){
        return userTypeRepository.getById(id);
    }

    public Optional<UserType> getByType(String type){
        return userTypeRepository.getByType(type);
    }

    public UserType save(UserType userType){
        return userTypeRepository.save(userType);
    }

    public boolean delete(Long idUserType){
        return userTypeRepository.delete(idUserType);
    }
}
