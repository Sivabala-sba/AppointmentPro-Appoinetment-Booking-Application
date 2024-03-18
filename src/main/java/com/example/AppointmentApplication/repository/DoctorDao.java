package com.example.AppointmentApplication.repository;

import com.example.AppointmentApplication.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDao extends JpaRepository<Doctor, Integer> {
    public Doctor findByMobileNo(String mobileNo);
}
