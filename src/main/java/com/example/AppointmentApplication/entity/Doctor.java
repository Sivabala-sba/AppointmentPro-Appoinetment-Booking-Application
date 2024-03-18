package com.example.AppointmentApplication.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "id_table")
    @SequenceGenerator(name = "id_table",
            sequenceName = "id_sequence",
            allocationSize = 1)
    private Integer doctorId;

    @Pattern(regexp = "^[0-9]{10}$", message = "Please enter valid mobile number")
    private String mobileNo;

    private String password;

    private String name;

    private String speciality;

    private String location;

    //@Column(name = "insurance")
    private Boolean insuranceAcceptance;

    private String education;

    private String experience;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "appointmentId")
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    List<Appointment> listOfAppointments = new ArrayList<>();

    //put time only 24hrs formate

    //@Column(name = "from")
    private Integer appointmentFromTime;

    //@Column(name = "to")
    private Integer appointmentToTime;

    //for checking this is doctor or patient

    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> listOfReviews = new ArrayList<>();

    private String doctorImg;

    private Boolean validDoctor = true;

    List<Message> listOfMessage = new ArrayList<>();

    //Getter and Setter

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getInsuranceAcceptance() {
        return insuranceAcceptance;
    }

    public void setInsuranceAcceptance(Boolean insuranceAcceptance) {
        this.insuranceAcceptance = insuranceAcceptance;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public List<Appointment> getListOfAppointments() {
        return listOfAppointments;
    }

    public void setListOfAppointments(List<Appointment> listOfAppointments) {
        this.listOfAppointments = listOfAppointments;
    }

    public Integer getAppointmentFromTime() {
        return appointmentFromTime;
    }

    public void setAppointmentFromTime(Integer appointmentFromTime) {
        this.appointmentFromTime = appointmentFromTime;
    }

    public Integer getAppointmentToTime() {
        return appointmentToTime;
    }

    public void setAppointmentToTime(Integer appointmentToTime) {
        this.appointmentToTime = appointmentToTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Review> getListOfReviews() {
        return listOfReviews;
    }

    public void setListOfReviews(List<Review> listOfReviews) {
        this.listOfReviews = listOfReviews;
    }

    public String getDoctorImg() {
        return doctorImg;
    }

    public void setDoctorImg(String doctorImg) {
        this.doctorImg = doctorImg;
    }

    public Boolean getValidDoctor() {
        return validDoctor;
    }

    public void setValidDoctor(Boolean validDoctor) {
        this.validDoctor = validDoctor;
    }

    public List<Message> getListOfMessage() {
        return listOfMessage;
    }

    public void setListOfMessage(List<Message> listOfMessage) {
        this.listOfMessage = listOfMessage;
    }
}
