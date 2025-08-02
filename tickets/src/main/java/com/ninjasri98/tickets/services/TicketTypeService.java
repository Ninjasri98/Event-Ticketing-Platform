package com.ninjasri98.tickets.services;

import java.util.UUID;

import com.ninjasri98.tickets.domain.entities.Ticket;

public interface TicketTypeService {

    Ticket purchaseTicket (UUID userId, UUID ticketTypeId);
}
