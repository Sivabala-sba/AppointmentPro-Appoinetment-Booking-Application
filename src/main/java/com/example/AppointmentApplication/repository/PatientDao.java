package com.example.AppointmentApplication.repository;

import com.example.AppointmentApplication.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDao extends JpaRepository<Patient, Integer> {
    public Patient findByMobileNo(String mobileNo);
}
