package com.diego.mailsender.services;


import com.diego.mailsender.model.EmailModel;
import com.diego.mailsender.repositories.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailService {

    private EmailRepository emailRepository;

    public void sendEmail(EmailModel emailModel) {


    }
}
