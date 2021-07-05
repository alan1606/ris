package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.Cut;
import com.diagnocons.ris.domain.service.CutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cuts")
public class CutController {
    @Autowired
    CutService cutService;

    @GetMapping("/all")
    public ResponseEntity<List<Cut>> getAll() {
        Optional<List<Cut>> cortes = cutService.getAll();
        if (cortes.isPresent()) {
            return new ResponseEntity(cortes, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cut> getById(@PathVariable("id") Long idCut) {
        return cutService.getById(idCut).map(corte -> new ResponseEntity(corte, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/turn/{idTurn}")
    public ResponseEntity<List<Cut>> getByIdCut(@PathVariable("idTurn") Long idTurn) {
        return cutService.getByTurn(idTurn).map(cortes -> new ResponseEntity(cortes, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/turn/{idTurn}/day/{day}")
    public ResponseEntity<List<Cut>> getByTurnDay(@PathVariable("idTurn") Long idTurn, @PathVariable("day") LocalDate day) {
        return cutService.getByTurnDay(idTurn, day).map(cortes -> new ResponseEntity(cortes, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/turn/{idTurn}/day/{day}/receptionist/{idReceptionist}")
    public ResponseEntity<Cut> getByTurnDay(@PathVariable("idTurn") Long idTurn, @PathVariable("day") LocalDate day, @PathVariable("idReceptionist") Long idReceptionist) {
        return cutService.getByTurnDayReceptionist(idTurn, day, idReceptionist).map(cortes -> new ResponseEntity(cortes, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/receptionist/{idReceptionist}/startDay/{startDay}/endDay/{endDay}")
    public ResponseEntity<List<Cut>> getInRangeReceptionist(@PathVariable("idReceptionist") Long idReceptionist, @PathVariable("startDay") LocalDate startDay, @PathVariable("endDay") LocalDate endDay){
        return cutService.getInRangeByReceptionist(idReceptionist, startDay, endDay).map(cortes -> new ResponseEntity(cortes , HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Cut> save(@RequestBody Cut corte){
        return new ResponseEntity(cutService.save(corte), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if(cutService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
