package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.Cut;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CutRepository {
    Optional<Cut> getById(Long idCut);
    Optional<List<Cut>> getAll();
    Optional<List<Cut>> getByTurn(Long idTurn);
    Optional<List<Cut>> getByTurnDay(Long idTurn, LocalDate day);
    Optional<Cut> getByTurnDayReceptionist(Long idTurn, LocalDate day, Long idReceptionist);
    Optional<List<Cut>> getInRangeByReceptionist(Long idReceptionist, LocalDate startDate, LocalDate endDate);
    Cut save(Cut cut);
    boolean delete(Long idCut);

}
