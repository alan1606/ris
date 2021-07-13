package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.State;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface StateRepository {
    Optional<List<State>> getAll();
    Optional<State> getById(Long id);
    Optional<State> getByName(String name);
    Optional<State> getByByNomenclature(String nomenclature);
    State save(State state);
    boolean delete(Long id);
}
