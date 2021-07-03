package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.UserTypePermissionTemplate;
import com.diagnocons.ris.domain.service.UserTypePermissionTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permissionsTemplates")
public class UserTypePermissionTemplateController {
    @Autowired
    private UserTypePermissionTemplateService service;

    @GetMapping("/all")
    public ResponseEntity<List<UserTypePermissionTemplate>> getAll(){
        Optional<List<UserTypePermissionTemplate>> templates = service.getAll();
        if(templates.isPresent()){
            return new ResponseEntity(templates, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/userType/{userType}")
    public ResponseEntity<List<UserTypePermissionTemplate>> getByIdUserType(@PathVariable("userType") Long idUserType){
        return service.getByIdUserType(idUserType).map(list -> new ResponseEntity(list, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/permission/{permission}")
    public ResponseEntity<List<UserTypePermissionTemplate>> getByIdPermission(@PathVariable("permission") Long idPermission){
        return service.getByIdPermission(idPermission).map(list -> new ResponseEntity(list, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserTypePermissionTemplate>> getByIdUserTypeIdPermission(@PathVariable("id") Long id){
        return service.getById(id).map(list -> new ResponseEntity(list, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<UserTypePermissionTemplate> save(@RequestBody UserTypePermissionTemplate template){
        return new ResponseEntity<>(service.save(template), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity delete(@PathVariable("id")Long id){
        if(service.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
