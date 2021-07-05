package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Corte;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CorteCrudRepository extends CrudRepository<Corte, Long> {
    @Query("Select c from Corte c where c.turno.id = ?1")
    Optional<List<Corte>> findByIdTurno(Long idTurno);

    @Query("Select c from Corte c where c.turno.id = ?1 and c.dia = ?2")
    Optional<List<Corte>> findByIdTurnoDia(Long idTurno, LocalDate dia);

    @Query("Select c from Corte c where c.turno.id = ?1 and c.dia = ?2 and c.recepcionista.id = ?3")
    Optional<Corte> findByIdTurnoDiaIdRecepcionistaResponsable(Long idTurno, LocalDate dia, Long idReceptionista);

    @Query("Select c from Corte c where c.recepcionista.id = ?1 and c.dia between ?2 and ?3")
    Optional<List<Corte>> findByIdRecepcionistaDiaBetween(Long idReceptionist, LocalDate startDate, LocalDate endDate);




}
