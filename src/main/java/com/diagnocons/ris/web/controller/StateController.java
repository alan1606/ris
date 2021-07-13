package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.State;
import com.diagnocons.ris.domain.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/all")
    public ResponseEntity<List<State>> getAll(){
        return stateService.getAll().map(estados -> new ResponseEntity(estados, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/{id}")
    public ResponseEntity<State> getById(@PathVariable("id")Long id){
        return stateService.getById(id).map(estado -> new ResponseEntity(estado, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.OK));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<State> getByName(@PathVariable("name") String name){
        return stateService.getByName(name).map(estado -> new ResponseEntity(estado, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nomenclature/{nomenclature}")
    public ResponseEntity<String > getByNomenclature(@PathVariable("nomenclature")String nomenclature){
        return stateService.getByByNomenclature(nomenclature).map(state -> new ResponseEntity(state, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<State> save(@RequestBody State state){
        return new ResponseEntity(stateService.save(state),HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")Long id){
        if(stateService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
