package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonaCrudRepository extends CrudRepository<Persona, Long> {

    @Query("select p from Persona p where p.usuario.id = ?1")
    Optional<Persona> getByIdUsuario(Long idUsuario);

    Optional<Persona> findByCurp(String curp);

    @Query("select p from Persona p where p.datosFacturacion.id = ?1")
    Optional<Persona> findByIdDatosFacturacion(Long idDatosFacturacion);

    Optional<Persona> findByPatientId(String patientId);



}
