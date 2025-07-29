package com.ninjasri98.tickets.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ninjasri98.tickets.domain.CreateEventRequest;
import com.ninjasri98.tickets.domain.entities.Event;
import com.ninjasri98.tickets.domain.entities.TicketType;
import com.ninjasri98.tickets.domain.entities.User;
import com.ninjasri98.tickets.exceptions.UserNotFoundException;
import com.ninjasri98.tickets.repositories.EventRepository;
import com.ninjasri98.tickets.repositories.UserRepository;
import com.ninjasri98.tickets.services.EventService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest event) {
        User organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with ID '%s' not found", organizerId)));
        List<TicketType> ticketTypesToCreate = event.getTicketTypes().stream().map(
                ticketType -> {
                    TicketType ticketTypeToCreate = new TicketType();
                    ticketTypeToCreate.setName(ticketType.getName());
                    ticketTypeToCreate.setPrice(ticketType.getPrice());
                    ticketTypeToCreate.setDescription(ticketType.getDescription());
                    ticketTypeToCreate.setTotalAvailable(ticketType.getTotalAvailable());
                    return ticketTypeToCreate;
                }).toList();

        Event eventToCreate = new Event();
        eventToCreate.setName(event.getName());
        eventToCreate.setStart(event.getStart());
        eventToCreate.setEnd(event.getEnd());
        eventToCreate.setVenue(event.getVenue());
        eventToCreate.setSalesStart(event.getSalesStart());
        eventToCreate.setSalesEnd(event.getSalesEnd());
        eventToCreate.setStatus(event.getStatus());
        eventToCreate.setOrganizer(organizer);
        eventToCreate.setTicketTypes(ticketTypesToCreate);
        return eventRepository.save(eventToCreate);
    }
}