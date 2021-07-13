package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.DatosFacturacion;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DatosFacturacionCrudRepository extends CrudRepository<DatosFacturacion, Long> {
    Optional<DatosFacturacion> findByRazonSocial(String razonSocial);
    Optional<DatosFacturacion> findByRfc(String rfc);
}
