package com.isha.app;

import com.isha.model.UserRegistration;
import com.isha.service.UserLoginService;
import com.isha.service.UserRegistrationService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainApp
{
    public static void main(String[] args)
    {
        // for testing purpose!
        // create object (this simulates form input)
        UserRegistration user = new UserRegistration();


        // call service
        UserLoginService service = new UserLoginService();
        service.registerUserService(user);
    }
}
