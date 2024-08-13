package com.example.demo.controller;

import com.example.demo.model.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @PostMapping("/CreateNewCustomer")
    public void createNewCustomer(Customer customer){

    }

    @PostMapping("/changePassword")
    public void changePassword(String oldPassword, String newPassword){

    }

    @PostMapping("/changeEmail")
    public void changeEmail(String oldEmail, String newEmail, String password){

    }
}
