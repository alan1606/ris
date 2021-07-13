package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.ReceptionistDepartment;
import com.diagnocons.ris.domain.service.ReceptionistDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receptionistsDepartments")
public class ReceptionistDepartmentController {
    @Autowired
    private ReceptionistDepartmentService receptionistDepartmentService;

    @GetMapping("/all")
    public ResponseEntity<List<ReceptionistDepartment>> getAll(){
        return  receptionistDepartmentService.getAll().map(lista -> new ResponseEntity(lista, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceptionistDepartment> getById(@PathVariable("id") Long id){
        return receptionistDepartmentService.getById(id).map(receptionistDepartment -> new ResponseEntity(receptionistDepartment, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/receptionist/{idReceptionist}")
    public ResponseEntity<List<ReceptionistDepartment>> getByIdReceptionist(@PathVariable("idReceptionist")Long idReceptionist){
        return receptionistDepartmentService.getByIdReceptionist(idReceptionist).map(receptionistDepartments -> new ResponseEntity(receptionistDepartments, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/department/{idDepartment}")
    public ResponseEntity<List<ReceptionistDepartment>> getByIdDepartment(@PathVariable("idDepartment")Long idDepartment){
        return receptionistDepartmentService.getByIdDeparment(idDepartment).map(receptionistDepartments -> new ResponseEntity(receptionistDepartments, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/receptionist/{idReceptionist}/department/{idDepartment}")
    public ResponseEntity<ReceptionistDepartment> getByIdReceptionistIdDepartment(@PathVariable("idReceptionist")Long idReceptionist, @PathVariable("idDepartment")Long idDepartment){
        return receptionistDepartmentService.getByIdReceptionistsIdDepartment(idReceptionist, idDepartment).map(receptionistDepartment -> new ResponseEntity(receptionistDepartment, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/save")
    public ResponseEntity<ReceptionistDepartment> save(@RequestBody ReceptionistDepartment receptionistDepartment){
        return new ResponseEntity(receptionistDepartmentService.save(receptionistDepartment), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if(receptionistDepartmentService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
