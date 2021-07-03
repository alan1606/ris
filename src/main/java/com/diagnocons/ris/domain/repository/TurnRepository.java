package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.Turn;

import java.util.List;
import java.util.Optional;

public interface TurnRepository {
    Optional<List<Turn>> getAll();
    Optional<Turn> getById(Long id);
    Optional<Turn> getByDescripction(String description);
    Turn save(Turn turn);
    boolean delete(Long id);
}
