package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.Movement;
import com.diagnocons.ris.domain.repository.MovementRepository;
import com.diagnocons.ris.persistence.crud.MovimientoCrudRepository;
import com.diagnocons.ris.persistence.entity.Movimiento;
import com.diagnocons.ris.persistence.mapper.MovementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovimientoRepository implements MovementRepository {
    @Autowired
    private MovimientoCrudRepository movimientoCrudRepository;

    @Autowired
    private MovementMapper mapper;


    @Override
    public Optional<List<Movement>> getAll() {
        List<Movimiento> movimientos = (List<Movimiento>) movimientoCrudRepository.findAll();
        return Optional.of(mapper.toMovements(movimientos));
    }

    @Override
    public Optional<Movement> getById(Long idMovement) {
        return movimientoCrudRepository.findById(idMovement).map(movement -> mapper.toMovement(movement));
    }

    @Override
    public Optional<List<Movement>> getByIdCut(Long idCut) {
        return movimientoCrudRepository.findByIdCorte(idCut).map(movimientos -> mapper.toMovements(movimientos));
    }

    @Override
    public Movement save(Movement movement) {
        Movimiento movimiento = mapper.toMovimiento(movement);
        return mapper.toMovement(movimientoCrudRepository.save(movimiento));
    }

    @Override
    public boolean delete(Long idMovement) {
        if(getById(idMovement).isPresent()){
            movimientoCrudRepository.deleteById(idMovement);
            return true;
        }
        return false;
    }
}
