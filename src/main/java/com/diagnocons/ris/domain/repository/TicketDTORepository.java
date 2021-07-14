package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.TicketDTO;
import com.diagnocons.ris.persistence.entity.Ticket;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TicketDTORepository {
    Optional<List<TicketDTO>> getAll();
    Optional<List<TicketDTO>> getByIdBillingData(Long idBillingData);
    Optional<TicketDTO> getById(Long id);
    Optional<List<TicketDTO>> getByDate(LocalDate date);
    Optional<List<TicketDTO>> getByState(char state);
    Optional<List<TicketDTO>> getByIdBillingDataDate(Long idBillingData, LocalDate date);
    Optional<List<TicketDTO>> getByStateDate(char state, LocalDate date);
    TicketDTO save(TicketDTO  ticketDTO);
    boolean delete(Long id);
}
