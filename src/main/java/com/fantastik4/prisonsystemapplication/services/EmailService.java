package com.fantastik4.prisonsystemapplication.services;

public interface EmailService {
    void sendSimpleMessage(
            String to, String subject, String text);

    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
}
