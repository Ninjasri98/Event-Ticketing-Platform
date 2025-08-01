package com.ninjasri98.tickets.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ninjasri98.tickets.domain.CreateEventRequest;
import com.ninjasri98.tickets.domain.entities.Event;

public interface EventService {
  Event createEvent(UUID organizerId, CreateEventRequest event);

  Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);
}
