package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.TicketDTO;
import com.diagnocons.ris.domain.service.TicketDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketDTOService ticketDTOService;

    @GetMapping("/all")
    public ResponseEntity<List<TicketDTO>> getAll(){
        return ticketDTOService.getAll().map(ticketDTOS -> new ResponseEntity(ticketDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/billingData/{idBillingData}")
    public ResponseEntity<List<TicketDTO>> getByIdBillingData(@PathVariable("idBillingData")Long idBillingData){
        return ticketDTOService.getByIdBillingData(idBillingData).map(ticketDTOS -> new ResponseEntity(ticketDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<TicketDTO>> getByIdDate(@PathVariable("date")LocalDate date){
        return ticketDTOService.getByDate(date).map(ticketDTOS -> new ResponseEntity(ticketDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/sate/{state}")
    public ResponseEntity<List<TicketDTO>> getByState(@PathVariable("state")char state){
        return ticketDTOService.getByState(state).map(ticketDTOS -> new ResponseEntity(ticketDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/billingData/{idBillingData}/date/{date}")
    public ResponseEntity<List<TicketDTO>> getByIdBillingDataDate(@PathVariable("idBillingData")Long idBillingData, @PathVariable("date")LocalDate date){
        return ticketDTOService.getByIdBillingDataDate(idBillingData, date).map(ticketDTOS -> new ResponseEntity(ticketDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/sate/{state}/date/{date}")
    public ResponseEntity<List<TicketDTO>> getByStateDate(@PathVariable("state")char state, @PathVariable("date")LocalDate date){
        return ticketDTOService.getByStateDate(state, date).map(ticketDTOS -> new ResponseEntity(ticketDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<TicketDTO> save(@RequestBody TicketDTO ticket){
        return new ResponseEntity(ticketDTOService.save(ticket), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")Long id){
        if(ticketDTOService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
