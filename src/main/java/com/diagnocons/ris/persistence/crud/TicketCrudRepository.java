package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TicketCrudRepository extends CrudRepository<Ticket, Long> {
    @Query("select t from Ticket t where t.datosFacturacion.id = ?1")
    Optional<List<Ticket>> getByIdDatosFacturacion(Long idDatosFacturacion);

    Optional<List<Ticket>> findByFecha(LocalDate fecha);

    Optional<List<Ticket>> findByEstado(char estado);

    @Query("select t from Ticket t where t.datosFacturacion.id = ?1 and t.fecha = ?2")
    Optional<List<Ticket>> getByIdDatosFacturacionFecha(Long idDatosFacturacion, LocalDate fecha);

    @Query("select t from Ticket t where t.estado = ?1 and t.fecha = ?2")
    Optional<List<Ticket>> findByEstadoFecha(Character estado, LocalDate fecha);

}
