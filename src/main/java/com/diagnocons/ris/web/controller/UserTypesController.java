package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.UserType;
import com.diagnocons.ris.domain.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userTypes")
public class UserTypesController {
    @Autowired
    private UserTypeService userTypeService;

    @GetMapping("/all")
    public ResponseEntity<List<UserType>> getAll(){
        return new ResponseEntity(userTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserType> getById(@PathVariable("id") Long id){
         return userTypeService.getById(id).map(userType -> new ResponseEntity<>(userType, HttpStatus.OK)).
                 orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<UserType> getByType(@PathVariable("type") String type){
        return userTypeService.getByType(type).map(types -> new ResponseEntity(types, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<UserType> save(@RequestBody UserType userType){
        return new ResponseEntity<>(userTypeService.save(userType), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long idUserType){
        if(userTypeService.delete(idUserType)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
