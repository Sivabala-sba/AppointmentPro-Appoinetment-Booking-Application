package com.example.AppointmentApplication.repository;

import com.example.AppointmentApplication.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDao extends JpaRepository<Review, Integer> {
}
