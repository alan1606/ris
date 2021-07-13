package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.BillingData;
import com.diagnocons.ris.domain.service.BillingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billingsDatas")
public class BillingDataController {
    @Autowired
    private BillingDataService billingDataService;

    @GetMapping("/all")
    public ResponseEntity<List<BillingData>> getAll(){
        return billingDataService.getAll().map(datos -> new ResponseEntity(datos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillingData> getById(@PathVariable("id")Long id){
        return billingDataService.getById(id).map(datos -> new ResponseEntity(datos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/businessName/{businessName}")
    public ResponseEntity<BillingData> getByBusinessName(@PathVariable("businessName")String businessName){
        return billingDataService.getByBusinessName(businessName).map(datos -> new ResponseEntity(datos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/rfc/{rfc}")
    public ResponseEntity<BillingData> getByRfc(@PathVariable("rfc")String rfc){
        return billingDataService.getByRfc(rfc).map(datos -> new ResponseEntity(datos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<BillingData> save(@RequestBody BillingData billingData){
        return new ResponseEntity(billingDataService.save(billingData), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")Long id){
        if(billingDataService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
