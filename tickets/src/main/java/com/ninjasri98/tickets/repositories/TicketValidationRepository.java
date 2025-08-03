package com.ninjasri98.tickets.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninjasri98.tickets.domain.entities.TicketValidation;

@Repository
public interface TicketValidationRepository extends JpaRepository<TicketValidation, UUID> {
}
