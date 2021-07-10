package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.RecepcionistaDepartamento;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecepcionistaDepartamentoCrudRepository {
    @Query("Select r from RecepcionistaDepartamento r where r.recepcionista.id = ?1")
    List<RecepcionistaDepartamento> findByIdRecepcionsta(Long idRecepcionista);

    @Query("Select r from RecepcionistaDepartamento r where r.departamento.id = ?1")
    List<RecepcionistaDepartamento> findByIdDepartamento(Long idDepartamento);

    @Query("Select r from RecepcionistaDepartamento r where r.recepcionista.id = ?1 and r.departamento.id = ?2")
    List<RecepcionistaDepartamento> findByIdRecepcionstaIdDepartamento(Long idRecepcionista, Long idDepartamento);
}
