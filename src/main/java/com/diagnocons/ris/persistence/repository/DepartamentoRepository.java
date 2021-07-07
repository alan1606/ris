package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.Department;
import com.diagnocons.ris.domain.repository.DepartmentRepository;
import com.diagnocons.ris.persistence.crud.DepartamentoCrudRepository;
import com.diagnocons.ris.persistence.entity.Departamento;
import com.diagnocons.ris.persistence.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DepartamentoRepository implements DepartmentRepository {
    @Autowired
    private DepartamentoCrudRepository derpartamentoCrudRepository;

    @Autowired
    private DepartmentMapper mapper;


    @Override
    public Optional<List<Department>> getAll() {
        List<Departamento> departamentos = (List<Departamento>) derpartamentoCrudRepository.findAll();
        return Optional.of(mapper.toDepartments(departamentos));
    }

    @Override
    public Optional<Department> getById(Long idDepartment) {
        return derpartamentoCrudRepository.findById(idDepartment).map(departamento -> mapper.toDeparment(departamento));
    }

    @Override
    public Optional<Department> getByName(String name) {
        return derpartamentoCrudRepository.findByNombre(name).map(departamento -> mapper.toDeparment(departamento));
    }

    @Override
    public Department save(Department department) {
        Departamento departamento = mapper.toDepartamento(department);
        return mapper.toDeparment(derpartamentoCrudRepository.save(departamento));
    }

    @Override
    public boolean delete(Long idDepartment) {
        if(getById(idDepartment).isPresent()){
            derpartamentoCrudRepository.deleteById(idDepartment);
            return true;
        }
        return false;
    }
}
