package com.example.AppointmentApplication.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppointmentApplication.entity.Appointment;
import com.example.AppointmentApplication.entity.CurrentSession;
import com.example.AppointmentApplication.entity.Doctor;
import com.example.AppointmentApplication.entity.Patient;
import com.example.AppointmentApplication.exception.DoctorException;
import com.example.AppointmentApplication.exception.PatientException;
import com.example.AppointmentApplication.repository.AppointmentDao;
import com.example.AppointmentApplication.repository.DoctorDao;

@Service
public class AdminDoctorServiceImpl implements AdminDoctorService{

    @Autowired
    DoctorDao doctorDao;

    @Autowired
    AppointmentDao appointmentDao;

    @Override
    public Doctor registerDoctor(Doctor doctor) throws DoctorException{
        Doctor databaseDoctor = doctorDao.findByMobileNo(doctor.getMobileNo());
        if(databaseDoctor == null){
            doctor.setType("Doctor");
            doctor.setPassword(PatientServiceImpl.bCryptPasswordEncoder.encode(doctor.getPassword()));
            return doctorDao.save(doctor);
        }else {
            throw new DoctorException("Doctor already register with this mobile no: " + doctor.getMobileNo());
        }
    }

    @Override
    public Doctor revokePermissionOfDoctor(Doctor doctor) throws DoctorException {
        Optional<Doctor> registerDoctor = doctorDao.findById(doctor.getDoctorId());
        if(registerDoctor.isPresent()) {
            registerDoctor.get().setValidDoctor(false);
            return doctorDao.save(registerDoctor.get());
        }else {
            throw new DoctorException("Doctor not present with this id " + doctor.getDoctorId());
        }
    }

    @Override
    public Doctor grantPermissionOfDoctor(Doctor doctor) throws DoctorException {
        Optional<Doctor> registerDoctor = doctorDao.findById(doctor.getDoctorId());
        if(registerDoctor.isPresent()) {
            registerDoctor.get().setValidDoctor(true);
            return doctorDao.save(registerDoctor.get());
        }else {
            throw new DoctorException("Doctor not present with this id " + doctor.getDoctorId());
        }
    }

    @Override
    public List<Doctor> getAllValidInValidDoctors(String key) throws DoctorException {
        List<Doctor> listOfDoctors = doctorDao.findAll();
        if(!listOfDoctors.isEmpty()) {
            return listOfDoctors;
        }else {
            throw new DoctorException("No doctors register. Please contact admin.");
        }
    }
}
