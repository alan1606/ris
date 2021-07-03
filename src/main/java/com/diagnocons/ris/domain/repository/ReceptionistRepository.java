package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.Receptionist;

import java.util.List;
import java.util.Optional;

public interface ReceptionistRepository {
    Optional<List<Receptionist>> getAll();

    Optional<Receptionist> getById(Long id);

    Optional<Receptionist> getByIdUser(Long idUser);

    Receptionist save(Receptionist receptionist );

    boolean delete (Long id);
}
