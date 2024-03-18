package com.example.AppointmentApplication.repository;

import com.example.AppointmentApplication.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message, Integer> {
}
