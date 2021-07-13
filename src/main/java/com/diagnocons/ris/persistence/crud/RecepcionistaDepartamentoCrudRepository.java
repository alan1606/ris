package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.RecepcionistaDepartamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecepcionistaDepartamentoCrudRepository extends CrudRepository<RecepcionistaDepartamento, Long> {
    @Query("Select r from RecepcionistaDepartamento r where r.recepcionista.id = ?1")
    List<RecepcionistaDepartamento> findByIdRecepcionsta(Long idRecepcionista);

    @Query("Select r from RecepcionistaDepartamento r where r.departamento.id = ?1")
    List<RecepcionistaDepartamento> findByIdDepartamento(Long idDepartamento);

    @Query("Select r from RecepcionistaDepartamento r where r.recepcionista.id = ?1 and r.departamento.id = ?2")
    Optional<RecepcionistaDepartamento> findByIdRecepcionstaIdDepartamento(Long idRecepcionista, Long idDepartamento);
}
