package com.ninjasri98.tickets.services;

import com.ninjasri98.tickets.domain.entities.QrCode;
import com.ninjasri98.tickets.domain.entities.Ticket;

public interface QrCodeService {
    QrCode generateQrCode(Ticket ticket);
}
