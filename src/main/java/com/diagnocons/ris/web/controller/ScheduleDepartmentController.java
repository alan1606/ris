package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.ScheduleDepartment;
import com.diagnocons.ris.domain.service.ScheduleDepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedulesDepartments")
public class ScheduleDepartmentController {
    @Autowired
    ScheduleDepartamentService scheduleDepartamentService;

    @GetMapping("/all")
    public ResponseEntity<List<ScheduleDepartment>> getAll(){
        return scheduleDepartamentService.getAll().map(todo -> new ResponseEntity(todo, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDepartment> getById(@PathVariable("id") Long id){
        return scheduleDepartamentService.getById(id).map(schedule -> new ResponseEntity(schedule, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/schedule/{idSchedule}")
    public ResponseEntity<List<ScheduleDepartment>> getByIdSchedule(@PathVariable("idSchedule") Long idSchedule){
        return scheduleDepartamentService.getByIdSchedule(idSchedule).map(list -> new ResponseEntity(list, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/department/{idDepartment}")
    public ResponseEntity<List<ScheduleDepartment>> getByIdDeparment(@PathVariable("idDeparment") Long idDepartment){
        return scheduleDepartamentService.getByIdDepartment(idDepartment).map(list -> new ResponseEntity(list, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/schedule/{idSchedule}/department/{idDepartment}")
    public ResponseEntity<ScheduleDepartment> getByIdScheduleIdDepartment(@PathVariable("idSchedule") Long idSchedule, @PathVariable("idDepartment") Long idDepartment){
        return scheduleDepartamentService.getByIdScheduleIdDeparment(idSchedule, idDepartment).map(agenda -> new ResponseEntity(agenda, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ScheduleDepartment> save(@RequestBody ScheduleDepartment scheduleDepartment){
        return new ResponseEntity(scheduleDepartamentService.save(scheduleDepartment), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if(scheduleDepartamentService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
