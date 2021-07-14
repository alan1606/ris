package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.TicketDTO;
import com.diagnocons.ris.domain.repository.TicketDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TicketDTOService {

    @Autowired
    private TicketDTORepository ticketDTORepository;

    public Optional<List<TicketDTO>> getAll(){
        return ticketDTORepository.getAll();
    }

    public Optional<List<TicketDTO>> getByIdBillingData(Long idBillingData){
        return ticketDTORepository.getByIdBillingData(idBillingData);
    }

    public Optional<TicketDTO> getById(Long id){
        return ticketDTORepository.getById(id);
    }

    public Optional<List<TicketDTO>> getByDate(LocalDate date){
        return ticketDTORepository.getByDate(date);
    }

    public Optional<List<TicketDTO>> getByState(char state){
        return ticketDTORepository.getByState(state);
    }

    public Optional<List<TicketDTO>> getByIdBillingDataDate(Long idBillingData, LocalDate date){
        return ticketDTORepository.getByIdBillingDataDate(idBillingData, date);
    }

    public Optional<List<TicketDTO>> getByStateDate(char state, LocalDate date){
        return ticketDTORepository.getByStateDate(state, date);
    }

    public TicketDTO save(TicketDTO  ticketDTO){
        return ticketDTORepository.save(ticketDTO);
    }

   public boolean delete(Long id){
        return ticketDTORepository.delete(id);
    }

}
