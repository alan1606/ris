package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.Receptionist;
import com.diagnocons.ris.domain.service.RecepcionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("recepcionists")
public class RecepcionistController {

    @Autowired
    private RecepcionistService recepcionistService;

    @GetMapping("/all")
    public ResponseEntity<List<Receptionist>> getAll() {
        Optional<List<Receptionist>> receptionistList = recepcionistService.getAll();
        if (receptionistList.isPresent()) {
            return new ResponseEntity(receptionistList, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receptionist> getById(@PathVariable("id") Long id) {
        return recepcionistService.getById(id).map(rec -> new ResponseEntity(rec, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Receptionist> getByIdUser(@PathVariable("id") Long idUser) {
        return recepcionistService.getByIdUser(idUser).map(rec -> new ResponseEntity(rec, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Receptionist> save(@RequestBody Receptionist receptionist){
        return new ResponseEntity(recepcionistService.save(receptionist), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if (recepcionistService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
