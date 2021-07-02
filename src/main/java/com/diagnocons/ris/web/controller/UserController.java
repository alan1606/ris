package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.User;
import com.diagnocons.ris.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        Optional<List<User>> usuarios = userService.getAll();
        if(usuarios.isPresent()){
            return new ResponseEntity(usuarios, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        return userService.getById(id).map(user -> new ResponseEntity(user, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<User> getByNickname(@PathVariable("nickname") String nickname){
        return userService.getByNickname(nickname).map(user -> new ResponseEntity(user, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email){
        return userService.getByEmail(email).map(user -> new ResponseEntity(user, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<User> getByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
        return userService.getByPhoneNumber(phoneNumber).map(user -> new ResponseEntity(user, HttpStatus.OK) )
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/string/{string}")
    public ResponseEntity<User> getByString(@PathVariable("string") String string){
        return userService.getByString(string).map(user -> new ResponseEntity(user, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/type/{idUserType}")
    public ResponseEntity getByUserType(@PathVariable("idUserType") Long idUserType){
        Optional<List<User>> usuarios = userService.getByUserType(idUserType);
        if(usuarios.isPresent()){
            return new ResponseEntity(usuarios, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity(userService.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long userId){
        if (userService.delete(userId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
