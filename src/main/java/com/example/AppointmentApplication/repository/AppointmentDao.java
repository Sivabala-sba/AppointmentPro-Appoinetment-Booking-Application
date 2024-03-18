package com.example.AppointmentApplication.repository;

import com.example.AppointmentApplication.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDao extends JpaRepository<Appointment, Integer> {

}
