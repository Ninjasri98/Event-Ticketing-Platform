package com.ninjasri98.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ninjasri98.tickets.domain.CreateEventRequest;
import com.ninjasri98.tickets.domain.CreateTicketTypeRequest;
import com.ninjasri98.tickets.domain.dtos.CreateEventRequestDto;
import com.ninjasri98.tickets.domain.dtos.CreateEventResponseDto;
import com.ninjasri98.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.ninjasri98.tickets.domain.dtos.ListEventResponseDto;
import com.ninjasri98.tickets.domain.dtos.ListEventTicketTypeResponseDto;
import com.ninjasri98.tickets.domain.entities.Event;
import com.ninjasri98.tickets.domain.entities.TicketType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
  CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

  CreateEventRequest fromDto(CreateEventRequestDto dto);

  CreateEventResponseDto toDto(Event event);

  ListEventTicketTypeResponseDto toDto(TicketType ticketType);

  ListEventResponseDto toListEventResponseDto(Event event);
}
