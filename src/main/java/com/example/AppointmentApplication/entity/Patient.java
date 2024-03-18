package com.example.AppointmentApplication.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "id_table")
    @SequenceGenerator(name = "id_table",
            sequenceName = "id_sequence",
            allocationSize = 1)
    private Integer patientId;

    private String name;

    @Pattern(regexp = "^[0-9]{10}$", message = "Please enter valid mobile number")
    private String mobileNo;

    private String password;

    @Email(message = "Email should be a valid email")
    private String email;

    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    List<Appointment> listOfAppointments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    List<Review> listReviews = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    List<Message> listOfMessage = new ArrayList<>();

    //Getter and Setter

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Appointment> getListOfAppointments() {
        return listOfAppointments;
    }

    public void setListOfAppointments(List<Appointment> listOfAppointments) {
        this.listOfAppointments = listOfAppointments;
    }

    public List<Review> getListReviews() {
        return listReviews;
    }

    public void setListReviews(List<Review> listReviews) {
        this.listReviews = listReviews;
    }

    public List<Message> getListOfMessage() {
        return listOfMessage;
    }

    public void setListOfMessage(List<Message> listOfMessage) {
        this.listOfMessage = listOfMessage;
    }
}





