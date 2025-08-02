package com.ninjasri98.tickets.services.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.ninjasri98.tickets.domain.entities.QrCode;
import com.ninjasri98.tickets.domain.entities.QrCodeStatusEnum;
import com.ninjasri98.tickets.domain.entities.Ticket;
import com.ninjasri98.tickets.exceptions.QrCodeGenerationException;
import com.ninjasri98.tickets.repositories.QrCodeRepository;
import com.ninjasri98.tickets.services.QrCodeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QrCodeServiceImpl implements QrCodeService {
    private static final int QR_HEIGHT = 300;
    private static final int QR_WIDTH = 300;

    private final QRCodeWriter qrCodeWriter;
    private final QrCodeRepository qrCodeRepository;

    @Override
    public QrCode generateQrCode(Ticket ticket) {
        try {
            UUID uniqueId = UUID.randomUUID();
            String qrCodeImage = generateQrCodeImage(uniqueId);

            QrCode qrCode = new QrCode();
            qrCode.setId(uniqueId);
            qrCode.setStatus(QrCodeStatusEnum.ACTIVE);
            qrCode.setValue(qrCodeImage);
            qrCode.setTicket(ticket);

            return qrCodeRepository.saveAndFlush(qrCode);
        } catch (IOException | WriterException ex) {
            throw new QrCodeGenerationException("Failed to generate QR Code", ex);
        }
    }

    private String generateQrCodeImage(UUID uniqueId) throws WriterException, IOException {
        
        BitMatrix bitMatrix = qrCodeWriter.encode(
                uniqueId.toString(),
                BarcodeFormat.QR_CODE,
                QR_WIDTH,
                QR_HEIGHT);

        BufferedImage qrCodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(qrCodeImage, "PNG", baos);
            byte[] imageBytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);
        }
    }
}
