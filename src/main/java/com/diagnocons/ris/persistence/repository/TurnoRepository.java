package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.Turn;
import com.diagnocons.ris.domain.repository.TurnRepository;
import com.diagnocons.ris.persistence.crud.TurnoCrudRepository;
import com.diagnocons.ris.persistence.entity.Turno;
import com.diagnocons.ris.persistence.mapper.TurnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TurnoRepository implements TurnRepository {
    @Autowired
    TurnoCrudRepository turnoCrudRepository;

    @Autowired
    TurnMapper mapper;


    @Override
    public Optional<List<Turn>> getAll() {
        List<Turno> turnos = (List<Turno>) turnoCrudRepository.findAll();
        return Optional.of(mapper.toTurns(turnos));
    }

    @Override
    public Optional<Turn> getById(Long id) {
        return turnoCrudRepository.findById(id).map(turno -> mapper.toTurn(turno));
    }

    @Override
    public Optional<Turn> getByDescripction(String description) {
        return turnoCrudRepository.findByDescripcion(description).map(turn -> mapper.toTurn(turn));
    }

    @Override
    public Turn save(Turn turn) {
        Turno turno = mapper.toTurno(turn);
        return mapper.toTurn(turnoCrudRepository.save(turno));
    }

    @Override
    public boolean delete(Long id) {
        if(getById(id).isPresent()){
            turnoCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
