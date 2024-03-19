package com.example.AppointmentApplication.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.print.Doc;

import org.springframework.stereotype.Service;

import com.example.AppointmentApplication.entity.Doctor;
import com.example.AppointmentApplication.entity.Patient;
import com.example.AppointmentApplication.entity.Review;
import com.example.AppointmentApplication.entity.Appointment;
import com.example.AppointmentApplication.entity.CurrentSession;
import com.example.AppointmentApplication.exception.AppointmentException;
import com.example.AppointmentApplication.exception.DoctorException;
import com.example.AppointmentApplication.exception.LoginException;
import com.example.AppointmentApplication.exception.PatientException;
import com.example.AppointmentApplication.exception.ReviewException;
import com.example.AppointmentApplication.exception.TimeDateException;

public interface DoctorService {

    List<Doctor> getAllDoctorsRegisterFromDatabase() throws DoctorException;

    Doctor getDoctorByUuid(String uuid) throws PatientException;

    CurrentSession getCurrentUserByUuid(String uuid) throws LoginException;

    List<LocalDateTime> getDoctorAvailableTimingForBooking(String key, Doctor doctor) throws IOException, TimeDateException, DoctorException;

    List<Appointment> getUpcommingDoctorAppointment(Doctor doctor) throws AppointmentException;

    List<Appointment> getPastDoctorAppointment(Doctor doctor) throws AppointmentException;

    List<Appointment> getAllAppointments(Doctor registerDoctor) throws DoctorException;

    Doctor getDoctorDetails(String key) throws PatientException;

    Review getReviewOfParticularAppointment(String key, Appointment appointment) throws PatientException, ReviewException;

    List<Patient> getListOfPatient();
}
