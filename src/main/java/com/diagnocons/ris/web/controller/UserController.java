package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.User;
import com.diagnocons.ris.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Optional<List<User>> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getById(id);
    }

    public  Optional<User> getByNickname(String nickname){
        return userService.getByNickname(nickname);
    }

    public Optional<User> getByEmail(String email){
        return userService.getByEmail(email);
    }

    public Optional<User> getByPhoneNumber(String phoneNumber){
        return userService.getByPhoneNumber(phoneNumber);
    }

    public Optional<User> getByString(String string){
        return userService.getByString(string);
    }

    public Optional<List<User>> getByUserType(Long idUserType){
        return userService.getByUserType(idUserType);
    }

    public User save(User user){
        return userService.save(user);
    }

    public boolean delete(User user){
        return userService.delete(user);
    }

    public boolean delete(Long userId){
        return userService.delete(userId);
    }


}
