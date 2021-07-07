package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    Optional<List<Department>> getAll();
    Optional<Department> getById(Long idDepartment);
    Optional<Department> getByName(String name);
    Department save(Department department);
    boolean delete(Long idDepartment);
 }
