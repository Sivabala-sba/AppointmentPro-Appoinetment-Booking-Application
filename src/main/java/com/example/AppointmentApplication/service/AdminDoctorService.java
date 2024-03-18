package com.example.AppointmentApplication.service;

import com.example.AppointmentApplication.entity.Doctor;
import com.example.AppointmentApplication.entity.Patient;
import com.example.AppointmentApplication.exception.DoctorException;

import java.util.List;

public interface AdminDoctorService {

    Doctor registerDoctor(Doctor doctor) throws DoctorException;

    Doctor revokePermissionOfDoctor(Doctor doctor) throws DoctorException;

    Doctor grantPermissionOfDoctor(Doctor doctor) throws DoctorException;

    List<Doctor> getAllValidInValidDoctors(String key) throws DoctorException;
}
