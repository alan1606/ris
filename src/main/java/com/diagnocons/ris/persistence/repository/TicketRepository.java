package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.TicketDTO;
import com.diagnocons.ris.domain.repository.TicketDTORepository;
import com.diagnocons.ris.persistence.crud.TicketCrudRepository;
import com.diagnocons.ris.persistence.entity.Ticket;
import com.diagnocons.ris.persistence.mapper.TickerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class TicketRepository implements TicketDTORepository {
    @Autowired
    private TicketCrudRepository ticketCrudRepository;

    @Autowired
    private TickerMapper mapper;


    @Override
    public Optional<List<TicketDTO>> getAll() {
        List<Ticket> tickets = (List<Ticket>) ticketCrudRepository.findAll();
        return Optional.of(mapper.toTicketsDTO(tickets));
    }

    @Override
    public Optional<List<TicketDTO>> getByIdBillingData(Long idBillingData) {
        return ticketCrudRepository.getByIdDatosFacturacion(idBillingData).map(ticket -> mapper.toTicketsDTO(ticket));
    }

    @Override
    public Optional<TicketDTO> getById(Long id) {
        return ticketCrudRepository.findById(id).map(ticket -> mapper.toTicketDTO(ticket));
    }

    @Override
    public Optional<List<TicketDTO>> getByDate(LocalDate date) {
        return ticketCrudRepository.findByFecha(date).map(tickets -> mapper.toTicketsDTO(tickets));
    }

    @Override
    public Optional<List<TicketDTO>> getByState(char state) {
        return ticketCrudRepository.findByEstado(state).map(tickets -> mapper.toTicketsDTO(tickets));
    }

    @Override
    public Optional<List<TicketDTO>> getByIdBillingDataDate(Long idBillingData, LocalDate date) {
        return ticketCrudRepository.getByIdDatosFacturacionFecha(idBillingData, date).map(ticket -> mapper.toTicketsDTO(ticket));
    }

    @Override
    public Optional<List<TicketDTO>> getByStateDate(char state, LocalDate date) {
        return ticketCrudRepository.findByEstadoFecha(state, date).map(tickets -> mapper.toTicketsDTO(tickets));
    }

    @Override
    public TicketDTO save(TicketDTO ticketDTO) {
        Ticket ticket = mapper.toTicket(ticketDTO);
        return mapper.toTicketDTO(ticketCrudRepository.save(ticket));
    }

    @Override
    public boolean delete(Long id) {
        if(getById(id).isPresent()){
            ticketCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
