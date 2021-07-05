package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.Movement;

import java.util.List;
import java.util.Optional;

public interface MovementRepository {
    Optional<List<Movement>> getAll();
    Optional<Movement> getById(Long idMovement);
    Optional<List<Movement>> getByIdCut(Long idCut);
    Movement save(Movement movement);
    boolean delete(Long idMovement);
}
