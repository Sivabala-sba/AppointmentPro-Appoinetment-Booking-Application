package com.example.AppointmentApplication.service;

import com.example.AppointmentApplication.entity.LoginDTO;
import com.example.AppointmentApplication.entity.LoginUUIDKey;
import com.example.AppointmentApplication.exception.LoginException;

public interface DoctorLoginService {

    LoginUUIDKey logIntoAccount(LoginDTO loginDTO) throws LoginException;

    String logoutFromAccount(String key) throws LoginException;

    Boolean checkUserLoginOrNot(String key) throws LoginException;
}
