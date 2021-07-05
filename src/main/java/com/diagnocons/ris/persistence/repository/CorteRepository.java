package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.Cut;
import com.diagnocons.ris.domain.repository.CutRepository;
import com.diagnocons.ris.persistence.crud.CorteCrudRepository;
import com.diagnocons.ris.persistence.entity.Corte;
import com.diagnocons.ris.persistence.mapper.CutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class CorteRepository implements CutRepository {
    @Autowired
    private CorteCrudRepository corteCrudRepository;

    @Autowired
    private CutMapper mapper;


    @Override
    public Optional<Cut> getById(Long idCut) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Cut>> getAll() {
        List<Corte> cortes = (List<Corte>) corteCrudRepository.findAll();
        return Optional.of(mapper.toCuts(cortes));
    }

    @Override
    public Optional<List<Cut>> getByTurn(Long idTurn) {
        Optional<List<Corte>> cortes = corteCrudRepository.findByIdTurno(idTurn);
        return Optional.of(mapper.toCuts(cortes.orElse(null)));
    }

    @Override
    public Optional<List<Cut>> getByTurnDay(Long idTurn, LocalDate day) {
        Optional<List<Corte>> cortes = corteCrudRepository.findByIdTurnoDia(idTurn, day);
        return Optional.of(mapper.toCuts(cortes.orElse(null)));
    }

    @Override
    public Optional<Cut> getByTurnDayReceptionist(Long idTurn, LocalDate day, Long idReceptionist) {
        return corteCrudRepository.findByIdTurnoDiaIdRecepcionistaResponsable(idTurn, day, idReceptionist).map(corte -> mapper.toCut(corte));
    }

    @Override
    public Optional<List<Cut>> getInRangeByReceptionist(Long idReceptionist, LocalDate startDate, LocalDate endDate) {
        Optional<List<Corte>> cortes = corteCrudRepository.findByIdRecepcionistaDiaBetween(idReceptionist, startDate, endDate);
        return Optional.of(mapper.toCuts(cortes.orElse(null)));
    }

    @Override
    public Cut save(Cut cut) {
        Corte corte = mapper.toCorte(cut);
        return mapper.toCut(corteCrudRepository.save(corte));
    }

    @Override
    public boolean delete(Long idCut) {
        if(getById(idCut).isPresent()){
            corteCrudRepository.deleteById(idCut);
            return true;
        }
        return false;
    }
}
