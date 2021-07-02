package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Permiso;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PermisoCrudRepository extends CrudRepository<Permiso, Long> {

    Optional<Permiso> findByPermiso(String permiso);

}
