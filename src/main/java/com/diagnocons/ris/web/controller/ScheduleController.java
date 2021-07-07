package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.Schedule;
import com.diagnocons.ris.domain.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/all")
    public ResponseEntity<List<Schedule>> getAll(){
        Optional<List<Schedule>> schedules = scheduleService.getAll();
        if(schedules.isPresent()){
            return new ResponseEntity(schedules, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable("id") Long id){
        return scheduleService.getById(id).map(schedule -> new ResponseEntity(schedule, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/day/{day}")
    public ResponseEntity<Schedule> getByDay(@PathVariable("day")LocalDate day){
        return scheduleService.getByDay(day).map(schedule -> new ResponseEntity(schedule, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Schedule> save(@RequestBody Schedule schedule){
        return new ResponseEntity(scheduleService.save(schedule), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if(scheduleService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
