package com.ninjasri98.tickets.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ninjasri98.tickets.domain.CreateEventRequest;
import com.ninjasri98.tickets.domain.UpdateEventRequest;
import com.ninjasri98.tickets.domain.entities.Event;

public interface EventService {
  Event createEvent(UUID organizerId, CreateEventRequest event);

  Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);

  Optional<Event> getEventForOrganizer(UUID organizerId, UUID id);

  Event updateEventForOrganizer(UUID organizerId, UUID id, UpdateEventRequest event);

  void deleteEventForOrganizer(UUID organizerId, UUID eventId);

  Page<Event> listPublishedEvents(Pageable pageable);

  Page<Event> searchPublishedEvents(String query, Pageable pageable);
}
