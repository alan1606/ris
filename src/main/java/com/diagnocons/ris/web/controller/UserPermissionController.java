package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.UserPermission;
import com.diagnocons.ris.domain.service.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userPermissions")
public class UserPermissionController {
    @Autowired
    private UserPermissionService service;

    @GetMapping("/all")
    public ResponseEntity<List<UserPermission>> getAll(){
        Optional<List<UserPermission>> permissions = service.getAll();
        if(permissions.isPresent()){
            return new ResponseEntity(permissions, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<UserPermission>> getByIdUser(@PathVariable("user") Long idUser){
        return service.getByIdUser(idUser).map(list -> new ResponseEntity(list, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/permission/{permission}")
    public ResponseEntity<List<UserPermission>> getByIdPermission(@PathVariable("permission") Long idPermission){
        return service.getByIdPermission(idPermission).map(list -> new ResponseEntity(list, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserPermission>> getById(@PathVariable("id") Long id){
        return service.getById(id).map(list -> new ResponseEntity(list, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<UserPermission> save(@RequestBody UserPermission permission){
        return new ResponseEntity<>(service.save(permission), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")Long id){
        if(service.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
