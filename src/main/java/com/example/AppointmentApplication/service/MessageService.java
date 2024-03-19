package com.example.AppointmentApplication.service;

import java.util.List;

import com.example.AppointmentApplication.entity.Doctor;
import com.example.AppointmentApplication.entity.Patient;
import com.example.AppointmentApplication.entity.Message;
import com.example.AppointmentApplication.exception.DoctorException;
import com.example.AppointmentApplication.exception.PatientException;

public interface MessageService {

    Message sendMessageFromPatientToDoctor(String key, Message message) throws PatientException, DoctorException;

    Message sendMessageFromDoctorToPatient(String key, Message message) throws PatientException, DoctorException;

    List<Message> getMessageOfPatientParticularDoctor(String key, Doctor doctor) throws DoctorException, PatientException;

    List<Message> getMessageOfDoctorParticularPatient(String key, Patient patient) throws DoctorException, PatientException;
}
