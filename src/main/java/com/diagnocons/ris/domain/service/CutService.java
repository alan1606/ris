package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.Cut;
import com.diagnocons.ris.domain.repository.CutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CutService {
    @Autowired
    CutRepository cutRepository;

    public Optional<List<Cut>> getAll(){
        return cutRepository.getAll();
    }

    public Optional<Cut> getById(Long idCut){
        return cutRepository.getById(idCut);
    }

    public Optional<List<Cut>> getByTurn(Long idTurn){
        return cutRepository.getByTurn(idTurn);
    }

    public Optional<List<Cut>> getByTurnDay(Long idTurn, LocalDate day){
        return cutRepository.getByTurnDay(idTurn, day);
    }

    public Optional<Cut> getByTurnDayReceptionist(Long idTurn, LocalDate day, Long idReceptionist){
        return cutRepository.getByTurnDayReceptionist(idTurn, day, idReceptionist);
    }

    public Optional<List<Cut>> getInRangeByReceptionist(Long idReceptionist, LocalDate startDate, LocalDate endDate){
        return cutRepository.getInRangeByReceptionist(idReceptionist, startDate, endDate);
    }

    public Cut save(Cut cut){
        return cutRepository.save(cut);
    }

    public boolean delete(Long idCut){
        return cutRepository.delete(idCut);
    }

}
