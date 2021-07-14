package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.TicketDTO;
import com.diagnocons.ris.persistence.entity.Ticket;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TickerMapper {

    @Mappings({
            @Mapping(source = "id", target = "idTicket"),
            @Mapping(source = "datosFacturacion.id", target = "idBillingData"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "hora", target = "hour"),
            @Mapping(source = "requiereFactura", target = "requiresInvoice"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "total", target = "total"),
    })
    TicketDTO toTicketDTO(Ticket ticket);
    List<TicketDTO> toTicketsDTO(List<Ticket> tickets);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "fotoTicket", ignore = true),
            @Mapping(target = "pagoTicketList", ignore = true),
            @Mapping(target = "estudioList", ignore = true)
    })
    Ticket toTicket(TicketDTO ticketDTO);
}
