package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.Person;
import com.diagnocons.ris.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAll(){
        return personService.getAll().map(personas -> new ResponseEntity(personas, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{idPerson}")
    public ResponseEntity<Person> getById(@PathVariable("idPerson") Long idPerson){
        return personService.getById(idPerson).map(persona -> new ResponseEntity(persona, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/curp/{curp}")
    public ResponseEntity<Person> getByCurp(@PathVariable("curp") String curp){
        return personService.getByCurp(curp).map(person -> new ResponseEntity(person, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<Person> getByIdUser(@PathVariable("idUser")Long idUser){
        return personService.getByIdUser(idUser).map(person -> new ResponseEntity(person, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/billingData/{idBillingData}")
    public ResponseEntity<Person> getByIdBillingData(@PathVariable("idBillingData")Long idBillingData){
        return personService.getByBillingData(idBillingData).map(person -> new ResponseEntity(person, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/patientId/{pId}")
    public ResponseEntity<Person> getByPatientId(@PathVariable("pId") String pId){
        return personService.getByPatientId(pId).map(person -> new ResponseEntity(person, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Person> save(@RequestBody Person person){
        return new ResponseEntity(personService.save(person), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")Long id){
        if(personService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
