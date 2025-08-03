package com.ninjasri98.tickets.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ninjasri98.tickets.domain.entities.QrCode;
import com.ninjasri98.tickets.domain.entities.QrCodeStatusEnum;
import com.ninjasri98.tickets.domain.entities.Ticket;
import com.ninjasri98.tickets.domain.entities.TicketValidation;
import com.ninjasri98.tickets.domain.entities.TicketValidationMethod;
import com.ninjasri98.tickets.domain.entities.TicketValidationStatusEnum;
import com.ninjasri98.tickets.exceptions.QrCodeNotFoundException;
import com.ninjasri98.tickets.exceptions.TicketNotFoundException;
import com.ninjasri98.tickets.repositories.QrCodeRepository;
import com.ninjasri98.tickets.repositories.TicketRepository;
import com.ninjasri98.tickets.repositories.TicketValidationRepository;
import com.ninjasri98.tickets.services.TicketValidationService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketValidationServiceImpl implements TicketValidationService {

    private final QrCodeRepository qrCodeRepository;
    private final TicketValidationRepository ticketValidationRepository;
    private final TicketRepository ticketRepository;

    @Override
    public TicketValidation validateTicketByQrCode(UUID qrCodeId) {
        QrCode qrCode = qrCodeRepository.findByIdAndStatus(qrCodeId, QrCodeStatusEnum.ACTIVE)
                .orElseThrow(() -> new QrCodeNotFoundException(
                        String.format(
                                "QR Code with ID %s was not found", qrCodeId)));

        Ticket ticket = qrCode.getTicket();

        return validateTicket(ticket);
    }

    private TicketValidation validateTicket(Ticket ticket) {
        TicketValidation ticketValidation = new TicketValidation();
        ticketValidation.setTicket(ticket);
        ticketValidation.setValidationMethod(TicketValidationMethod.QR_SCAN);
        TicketValidationStatusEnum ticketValidationStatus = ticket.getValidations().stream()
                .filter(v -> TicketValidationStatusEnum.VALID.equals(v.getStatus()))
                .findFirst()
                .map(v -> TicketValidationStatusEnum.INVALID)
                .orElse(TicketValidationStatusEnum.VALID);
        ticketValidation.setStatus(ticketValidationStatus);
        return ticketValidationRepository.save(ticketValidation);
    }

    @Override
    public TicketValidation validateTicketManually(UUID ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(TicketNotFoundException::new);
        return validateTicket(ticket);
    }
}