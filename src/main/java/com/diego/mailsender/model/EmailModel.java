package com.diego.mailsender.model;


import com.diego.mailsender.enums.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_email")
public class EmailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDateTime sendDataEmail;

    private StatusEmail statusEmail;




}
