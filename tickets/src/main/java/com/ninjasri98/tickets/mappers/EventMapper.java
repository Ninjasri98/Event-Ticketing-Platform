package com.ninjasri98.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ninjasri98.tickets.domain.CreateEventRequest;
import com.ninjasri98.tickets.domain.CreateTicketTypeRequest;
import com.ninjasri98.tickets.domain.UpdateEventRequest;
import com.ninjasri98.tickets.domain.UpdateTicketTypeRequest;
import com.ninjasri98.tickets.domain.dtos.CreateEventRequestDto;
import com.ninjasri98.tickets.domain.dtos.CreateEventResponseDto;
import com.ninjasri98.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.ninjasri98.tickets.domain.dtos.GetEventDetailsResponseDto;
import com.ninjasri98.tickets.domain.dtos.GetEventDetailsTicketTypesResponseDto;
import com.ninjasri98.tickets.domain.dtos.GetPublishedEventDetailsResponseDto;
import com.ninjasri98.tickets.domain.dtos.GetPublishedEventDetailsTicketTypesResponseDto;
import com.ninjasri98.tickets.domain.dtos.ListEventResponseDto;
import com.ninjasri98.tickets.domain.dtos.ListEventTicketTypeResponseDto;
import com.ninjasri98.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.ninjasri98.tickets.domain.dtos.UpdateEventRequestDto;
import com.ninjasri98.tickets.domain.dtos.UpdateEventResponseDto;
import com.ninjasri98.tickets.domain.dtos.UpdateTicketTypeRequestDto;
import com.ninjasri98.tickets.domain.dtos.UpdateTicketTypeResponseDto;
import com.ninjasri98.tickets.domain.entities.Event;
import com.ninjasri98.tickets.domain.entities.TicketType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
  CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

  CreateEventRequest fromDto(CreateEventRequestDto dto);

  CreateEventResponseDto toDto(Event event);

  ListEventTicketTypeResponseDto toDto(TicketType ticketType);

  ListEventResponseDto toListEventResponseDto(Event event);

  GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(TicketType ticketType);

  GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

  UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);

  UpdateEventRequest fromDto(UpdateEventRequestDto dto);

  UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

  UpdateEventResponseDto toUpdateEventResponseDto(Event event);

  ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);

  GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(TicketType ticketType);

  GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event);
}
