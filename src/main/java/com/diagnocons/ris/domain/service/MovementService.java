package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.Movement;
import com.diagnocons.ris.domain.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService {
    @Autowired
    private MovementRepository movementRepository;

    public Optional<List<Movement>> getAll(){
        return movementRepository.getAll();
    }

    public Optional<Movement> getById(Long idMovement){
        return movementRepository.getById(idMovement);
    }

    public Optional<List<Movement>> getByIdCut(Long idCut){
        return movementRepository.getByIdCut(idCut);
    }

    public Movement save(Movement movement){
        return movementRepository.save(movement);
    }

    public boolean delete(Long idMovement){
        return movementRepository.delete(idMovement);
    }

}
