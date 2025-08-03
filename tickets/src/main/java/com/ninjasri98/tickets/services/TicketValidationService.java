package com.ninjasri98.tickets.services;

import java.util.UUID;

import com.ninjasri98.tickets.domain.entities.TicketValidation;

public interface TicketValidationService {
    TicketValidation validateTicketByQrCode(UUID qrCodeId);

    TicketValidation validateTicketManually(UUID ticketId);
}
