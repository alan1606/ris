package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.User;
import com.diagnocons.ris.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<List<User>> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getById(Long id){
        return userRepository.getById(id);
    }

    public  Optional<User> getByNickname(String nickname){
        return userRepository.getByNickname(nickname);
    }

    public Optional<User> getByEmail(String email){
        return userRepository.getByEmail(email);
    }

    public Optional<User> getByPhoneNumber(String phoneNumber){
        return userRepository.getByPhoneNumber(phoneNumber);
    }

    public Optional<User> getByString(String string){
        return userRepository.getByString(string);
    }

    public Optional<List<User>> getByUserType(Long idUserType){
        return userRepository.getByUserType(idUserType);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean delete(User user){
        return userRepository.delete(user);
    }

    public boolean delete(Long userId){
        return userRepository.delete(userId);
    }





}
