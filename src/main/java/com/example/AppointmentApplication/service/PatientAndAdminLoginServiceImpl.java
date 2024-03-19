package com.example.AppointmentApplication.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppointmentApplication.entity.LoginDTO;
import com.example.AppointmentApplication.entity.LoginUUIDKey;
import com.example.AppointmentApplication.entity.CurrentSession;
import com.example.AppointmentApplication.entity.Patient;
import com.example.AppointmentApplication.exception.LoginException;
import com.example.AppointmentApplication.repository.SessionDao;
import com.example.AppointmentApplication.repository.PatientDao;

@Service
public class PatientAndAdminLoginServiceImpl implements PatientAndAdminLoginService{

    @Autowired
    PatientDao patientDao;

    @Autowired
    SessionDao sessionDao;

    @Override
    public LoginUUIDKey logIntoAccount(LoginDTO loginDTO) throws LoginException {
        LoginUUIDKey loginUUIDKey = new LoginUUIDKey();
        Patient existingPatient = patientDao.findByMobileNo(loginDTO.getMobileNo());
        if(existingPatient == null) {
            throw new LoginException("Please enter valid mobile number " + loginDTO.getMobileNo());
        }

        Optional<CurrentSession> validCustomerSessionOpt = sessionDao.findById(existingPatient.getPatientId());

        ////////////////////////////////
        // this code is for only frontend application
        if(validCustomerSessionOpt.isPresent()) {
            if(PatientServiceImpl.bCryptPasswordEncoder.matches(loginDTO.getPassword(), existingPatient.getPassword())){
                loginUUIDKey.setUuid(validCustomerSessionOpt.get().getUuid());
                loginUUIDKey.setMsg("Login Successful");
                return loginUUIDKey;
            }
            throw new LoginException("Please enter valid details");
        }
        /////////////////////////////////////////////
        if(PatientServiceImpl.bCryptPasswordEncoder.matches(loginDTO.getPassword(), existingPatient.getPassword())) {
            String key = generateRandomString();
            CurrentSession currentPatientSession = new CurrentSession(existingPatient.getPatientId(), key, LocalDateTime.now());
            if(PatientServiceImpl.bCryptPasswordEncoder.matches("admin", existingPatient.getPassword()) && existingPatient.getMobileNo().equals("1234567890")) {
                existingPatient.setType("admin");
                currentPatientSession.setUserType("admin");
                currentPatientSession.setUserId(existingPatient.getPatientId());
                sessionDao.save(currentPatientSession);
                patientDao.save(existingPatient);
                loginUUIDKey.setMsg("Login Successful as admin with key");
                loginUUIDKey.setUuid(key);
                return loginUUIDKey;
            }else {
                existingPatient.setType("patient");
                currentPatientSession.setUserId(existingPatient.getPatientId());
                currentPatientSession.setUserType("patient");
            }
            patientDao.save(existingPatient);
            sessionDao.save(currentPatientSession);
            loginUUIDKey.setMsg("Login Successful as patient with this key");
            loginUUIDKey.setUuid(key);
            return loginUUIDKey;
        }else {
            throw new LoginException("Please enter valid password");
        }
    }

    @Override
    public String logoutFromAccount(String key) throws LoginException {
        CurrentSession currentPatientOptional = sessionDao.findByUuid(key);
        if(currentPatientOptional != null) {
            sessionDao.delete(currentPatientOptional);
            return "Logout successful";
        }else {
            throw new LoginException("Please enter valid key");
        }
    }

    @Override
    public Boolean checkUserLoginOrNot(String key) throws LoginException {
        CurrentSession currentPatientSession = sessionDao.findByUuid(key);
        if(currentPatientSession != null) {
            return true;
        }else {
            return false;
        }
    }

    public static String generateRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
