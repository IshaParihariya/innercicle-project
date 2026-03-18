package com.isha.app;

import com.isha.model.UserRegistration;
import com.isha.service.UserLoginService;

public class MainApp {
    public static void main(String[] args) {

        // create service object
        UserLoginService service = new UserLoginService();

        try {
            // 🔹 test data (change this according to your DB)
            String email = "isha@gmail.com";
            String password = "123456";

            // 🔹 call login method
            UserRegistration user = service.loginUser(email, password);

            // 🔹 if login successful
            System.out.println("Login Successful");
            System.out.println("User Name: " + user.getName());
            System.out.println("User Email: " + user.getEmail());

        } catch (Exception e) {
            // 🔹 if login fails
            System.out.println("Login Failed");
            System.out.println(e.getMessage());
        }
    }
}