package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.Turn;
import com.diagnocons.ris.domain.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turns")
public class TurnController {

    @Autowired
    private TurnService turnService;

    @GetMapping("/all")
    public ResponseEntity<List<Turn>> getAll(){
        Optional<List<Turn>> turnos = turnService.getAll();
        if(turnos.isPresent()){
            return new ResponseEntity(turnos, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turn> getById(@PathVariable("id") Long id){
        return turnService.getById(id).map(turn -> new ResponseEntity(turn, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<Turn> getByDescription(@PathVariable("description") String description){
        return turnService.getByDescripction(description).map(turrn -> new ResponseEntity( turrn, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Turn> save(@RequestBody Turn turn){
        return new ResponseEntity(turnService.save(turn), HttpStatus.CREATED);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        if(turnService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
