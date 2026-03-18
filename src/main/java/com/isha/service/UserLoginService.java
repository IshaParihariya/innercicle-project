package com.isha.service;

import com.isha.dao.UserLoginDao;
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


        // comparing email
        // here we are using object of UserRegistration as we need the getter
        UserLoginDao dao = new UserLoginDao();
        //Get user from DB and store it inside user variable
        UserRegistration user = dao.getUserByEmail(email);
        // email is unique so searching for email & if found then user exists then
        // check user exists
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // check password
        // password for verifying the user
        // here user is the reference to the obj that has the fetched data of the user from the db
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }
        // on success return the object ( all data so we can it further in post and all)
        return user;
    }
    }
