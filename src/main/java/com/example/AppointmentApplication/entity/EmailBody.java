package com.example.AppointmentApplication.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class EmailBody {

    String emailSubject;

    String emailBody;

    //Getter and Setter

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }
}
