package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.Movement;
import com.diagnocons.ris.domain.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movements")
public class MovementController {
    @Autowired
    MovementService movementService;

    @GetMapping("/all")
    public ResponseEntity<List<Movement>> getAll(){
        Optional<List<Movement>> movements = movementService.getAll();
        if(movements.isPresent()){
            return new ResponseEntity(movements, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movement> getById(@PathVariable("id") Long idMovement){
        return movementService.getById(idMovement).map(movement -> new ResponseEntity(movement, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/cut/{idCut}")
    public ResponseEntity<List<Movement>> getByIdCut(@PathVariable("idCut") Long idCut){
        return movementService.getByIdCut(idCut).map(movements -> new ResponseEntity(movements, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Movement> save(@RequestBody Movement movement){
        return new ResponseEntity(movementService.save(movement), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if(movementService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
