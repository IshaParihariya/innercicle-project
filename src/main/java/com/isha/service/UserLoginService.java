package com.isha.service;

import com.isha.dao.UserLoginDao;
import com.isha.dao.UserRegistrationDao;
import com.isha.model.UserRegistration;

public class UserLoginService
{
    // method to fetch and compare the user data
    // comparing with email and password
    public UserRegistration loginUser(String email, String password)
    {
        // email validation
        // here we didn't user  UserRegistration object as these are not input , here we are just validating the format and not null and all
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("enter email");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }

        // password validation
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("enter password");
        }

        // incomplete from here...

        // comparing email
        // here we are using object of UserRegistration as we need the getter
        UserLoginDao dao = new UserLoginDao();
        UserRegistration user = dao.getUserByEmail(email);
        // email is unique so searching for email & if found then user exists then
        // password for verifying the user
        return user;
    }
    }
