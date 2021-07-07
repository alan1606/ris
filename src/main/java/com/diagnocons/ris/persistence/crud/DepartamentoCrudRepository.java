package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Departamento;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartamentoCrudRepository extends CrudRepository<Departamento, Long> {
    Optional<Departamento> findByNombre(String nombre);
}
