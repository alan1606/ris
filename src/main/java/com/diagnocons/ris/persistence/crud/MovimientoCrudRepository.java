package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Movimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovimientoCrudRepository extends CrudRepository<Movimiento, Long> {

    @Query("Select m from Movimiento m where m.corte.id = ?1")
    Optional<List<Movimiento>> findByIdCorte(Long idCorte);

}
