package com.example.AppointmentApplication.service;

import com.example.AppointmentApplication.entity.EmailBody;
import jakarta.mail.MessagingException;

public interface EmailSenderService {
    Boolean sendAppointmentBookingMail(String toEmail, EmailBody emailBody) throws MessagingException;
}
