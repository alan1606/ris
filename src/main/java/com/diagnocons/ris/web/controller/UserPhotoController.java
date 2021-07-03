package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.UserPhoto;
import com.diagnocons.ris.domain.service.UserPhotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usersPhotos")
public class UserPhotoController {
    @Autowired
    private UserPhotoService service;

    @GetMapping("/all")
    public ResponseEntity<List<UserPhoto>>  getAll(){
        Optional<List<UserPhoto>> fotos = service.getAll();
        return fotos.map(f -> new ResponseEntity(f, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPhoto> getById(@PathVariable("id") Long id){
        return service.getById(id).map(foto -> new ResponseEntity(foto, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<UserPhoto>> getByIdUser(@PathVariable("idUser") Long idUser){
        return  service.getByIdUser(idUser).map(fotos -> new ResponseEntity(fotos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/path/{path}")
    public ResponseEntity<UserPhoto> getByPath(@PathVariable("path") String path){
        return  service.getByPath(path).map(fotos -> new ResponseEntity(fotos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<UserPhoto> save(@RequestBody UserPhoto photo){
        return new ResponseEntity(service.save(photo),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if(service.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
