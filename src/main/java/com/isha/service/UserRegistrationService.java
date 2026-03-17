package com.isha.service;

import com.isha.dao.UserRegistrationDao;
import com.isha.model.UserRegistration; // UserRegistration class from model

// Service layer
public class UserRegistrationService
{
    UserRegistrationDao userRegistrationDao=new UserRegistrationDao();
    // method for validation of email and password
    public void registerUserService(UserRegistration user)
    {
        // user.getName()==null -> server didnt recieve anything
        // user.getName().trim().isEmpty() -> user didnt write any name
        if(user.getName()==null||user.getName().trim().isEmpty())
        {
            throw new IllegalArgumentException("enter ur pretty name sweet heart!!");
        }
        if(!user.getEmail().contains("@"))
        {
            throw new IllegalArgumentException("Invalid email gurllie use @ please");
        }
       if(user.getEmail()==null||user.getEmail().trim().isEmpty()) // if email not entered
       {
           throw new IllegalArgumentException("email is needed sweetie!!");
       }
       if(user.getPassword()==null||user.getPassword().trim().isEmpty())
       {
           throw new IllegalArgumentException("enter password please lovie!!");
       }
       if(user.getPassword().length()<6)
       {
           throw new IllegalArgumentException("darling the password should be atleast 6 characters");
       }

        userRegistrationDao.registerUserDao(user);
    }
}
