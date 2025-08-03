package com.ninjasri98.tickets.services;

import java.util.UUID;

import com.ninjasri98.tickets.domain.entities.QrCode;
import com.ninjasri98.tickets.domain.entities.Ticket;

public interface QrCodeService {
    QrCode generateQrCode(Ticket ticket);

    byte[] getQrCodeImageForUserAndTicket (UUID userId, UUID ticketId);
}
