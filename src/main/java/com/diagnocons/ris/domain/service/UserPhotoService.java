package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.UserPhoto;
import com.diagnocons.ris.domain.repository.UserPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPhotoService {
    @Autowired
    private UserPhotoRepository userPhotoRepository;

    public Optional<List<UserPhoto>> getAll(){
        return userPhotoRepository.getAll();
    }

    public Optional<UserPhoto> getById(Long id){
        return userPhotoRepository.getById(id);
    }

    public Optional<List<UserPhoto>> getByIdUser(Long idUser){
        return userPhotoRepository.getByIdUser(idUser);
    }

    public Optional<UserPhoto> getByPath(String path){
        return userPhotoRepository.getByPath(path);
    }

    public UserPhoto save(UserPhoto userPhoto){
        return userPhotoRepository.save(userPhoto);
    }

    public boolean delete(Long id){
        return userPhotoRepository.delete(id);
    }

}
