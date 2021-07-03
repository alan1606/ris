package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Turno;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TurnoCrudRepository  extends CrudRepository<Turno, Long> {
    Optional<Turno> findByDescripcion(String descripcion);
}
