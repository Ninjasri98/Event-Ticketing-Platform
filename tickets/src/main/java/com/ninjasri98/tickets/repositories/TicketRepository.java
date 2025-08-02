package com.ninjasri98.tickets.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninjasri98.tickets.domain.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
   int countByTicketTypeId(UUID ticketTypeId);
}