package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.Turn;
import com.diagnocons.ris.domain.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnService {
    @Autowired
    TurnRepository turnRepository;

    public Optional<List<Turn>> getAll(){
        return turnRepository.getAll();
    }

    public Optional<Turn> getById(Long id){
        return turnRepository.getById(id);
    }

    public Optional<Turn> getByDescripction(String description){
        return turnRepository.getByDescripction(description);
    }

    public Turn save(Turn turn){
        return turnRepository.save(turn);
    }

    public boolean delete(Long id){
        return turnRepository.delete(id);
    }
}
