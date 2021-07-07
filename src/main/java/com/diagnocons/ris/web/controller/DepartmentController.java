package com.diagnocons.ris.web.controller;

import com.diagnocons.ris.domain.dto.Department;
import com.diagnocons.ris.domain.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAll(){
        Optional<List<Department>> departments = departmentService.getAll();
        if(departments.isPresent()){
            return new ResponseEntity(departments, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Department> getByName(@PathVariable("name") String name){
        return departmentService.getByName(name).map(department -> new ResponseEntity(department, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable("id") Long id){
        return departmentService.getById(id).map(department -> new ResponseEntity(department, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Department> save(@RequestBody Department department){
        return new ResponseEntity(departmentService.save(department), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if(departmentService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
