package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstadoCrudRepository extends CrudRepository<Estado, Long> {
    Optional<Estado> findByNombre(String nombre);
    Optional<Estado> findByAbreviatura(String abreviatura);
}
