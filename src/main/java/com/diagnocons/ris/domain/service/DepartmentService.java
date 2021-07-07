package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.Department;
import com.diagnocons.ris.domain.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Optional<List<Department>> getAll(){
        return departmentRepository.getAll();
    }

    public Optional<Department> getById(Long idDepartment){
        return departmentRepository.getById(idDepartment);
    }

    public Optional<Department> getByName(String name){
        return departmentRepository.getByName(name);
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public boolean delete(Long idDepartment){
        return departmentRepository.delete(idDepartment);
    }

}
