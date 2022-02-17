package com.diego.mailsender.controllers;

import com.diego.mailsender.dto.EmailDTO;
import com.diego.mailsender.model.EmailModel;
import com.diego.mailsender.services.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RestController
public class EmailController {

    private EmailService emailService;

    @PostMapping(value = "send-email")
    public ResponseEntity<String> sendEmail(@RequestBody @Valid EmailDTO emailDTO){

       try {
           EmailModel emailModel = new EmailModel();
           BeanUtils.copyProperties(emailDTO, emailModel);
           emailService.sendEmail(emailModel);
           return new ResponseEntity<>("{\"mensagem\": \"email enviado com sucesso\"}", HttpStatus.OK);

       }catch (Exception ex){
           log.error("erro ao processar arquivo", ex);
           return new ResponseEntity<>("{ \"mensagem\": \"falha ao enviar email \"}",
                   HttpStatus.INTERNAL_SERVER_ERROR);

       }
    }
}
