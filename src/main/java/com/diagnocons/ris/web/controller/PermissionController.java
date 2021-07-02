package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.Permission;
import com.diagnocons.ris.domain.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping("/all")
    public ResponseEntity<List<Permission>> getAll(){
        Optional<List<Permission>> permissions = permissionService.getAll();
        if(permissions.isPresent()){
            return new ResponseEntity(permissions, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> getById(@PathVariable("id") Long id){
        return permissionService.getById(id).map(perm -> new ResponseEntity(perm, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/permission/{permission}")
    public ResponseEntity<Permission> getByPermission(@PathVariable("permission") String permission){
        return permissionService.getByPermission(permission).map(perm -> new ResponseEntity(perm, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Permission> save(@RequestBody Permission permission){
        return new ResponseEntity(permissionService.save(permission), HttpStatus.CREATED);
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity delete (@PathVariable("id") Long id){
        if(permissionService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
