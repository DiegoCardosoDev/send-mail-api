package com.diego.mailsender.services;


import com.diego.mailsender.enums.StatusEmail;
import com.diego.mailsender.model.EmailModel;
import com.diego.mailsender.repositories.EmailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@Service
public class EmailService {

    EmailRepository emailRepository;

    private JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {

        emailModel.setSendDataEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);

        }catch (MailException exception){
            log.error("erro ao enviar  email");
            emailModel.setStatusEmail(StatusEmail.ERROR);

        }finally {
            return emailRepository.save(emailModel);
        }


    }
}
