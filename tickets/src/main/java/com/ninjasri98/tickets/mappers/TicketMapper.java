package com.ninjasri98.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ninjasri98.tickets.domain.dtos.ListTicketResponseDto;
import com.ninjasri98.tickets.domain.dtos.ListTicketTicketTypeResponseDto;
import com.ninjasri98.tickets.domain.entities.Ticket;
import com.ninjasri98.tickets.domain.entities.TicketType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {
    ListTicketTicketTypeResponseDto toListTicketTicketTypeResponseDto(TicketType ticketType);

    ListTicketResponseDto toListTicketResponseDto(Ticket ticket);
}
